package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.BasketDto;
import com.example.ecommerce.dto.BasketProductDto;
import com.example.ecommerce.entity.Basket;
import com.example.ecommerce.entity.BasketProduct;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.mapper.BasketMapper;
import com.example.ecommerce.repository.BasketProductRepository;
import com.example.ecommerce.repository.BasketRepository;
import com.example.ecommerce.repository.CustomerRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.BasketProductService;
import com.example.ecommerce.service.BasketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Slf4j
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final BasketProductRepository basketProductRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final BasketMapper basketMapper;
    private final BasketProductService basketProductService;

    public final int BASKET_STATUS_ACTIVE = 0;

    @Override
    @Transactional
    public BasketDto addProductToBasket(BasketDto basketDto) {
        Long customerId = basketDto.getCustomer().getCustomerId();

        Optional<Basket> optionalBasket = basketRepository.findByCustomerIdAndStatus(customerId, BASKET_STATUS_ACTIVE);

        Basket updatedBasket;
        if (optionalBasket.isPresent()) {
            updatedBasket = addToExistingBasket(optionalBasket.get(), basketDto);
        } else {
            updatedBasket = createNewBasket(basketDto);
        }

        return basketMapper.toDto(updatedBasket);
    }

    @Override
    public BasketDto getBasketByCustomerId(String customerId) {
        Long cId = Long.parseLong(customerId);
        Basket basket = basketRepository.findByCustomerIdAndStatus(cId, BASKET_STATUS_ACTIVE)
                .orElseThrow(() -> new RuntimeException("Aktif sepet bulunamadı"));

        return basketMapper.toDto(basket);
    }

    @Override
    @Transactional
    public void removeProductFromBasket(String basketItemId) {
        basketProductRepository.deleteById(Long.parseLong(basketItemId));
    }

    // --- YARDIMCI METODLAR ---

    private Basket addToExistingBasket(Basket basket, BasketDto basketDto) {
        BasketProductDto productToAdd = basketDto.getBasketProductList().get(0);
        // ProductDto'da artık Long id kullanılıyor
        Long productId = productToAdd.getProduct().getId();

        BasketProduct existingItem = basketProductService.findBasketItemByBasketIdAndProductId(basket.getId(), productId);
        if (existingItem != null) {
            log.info("Ürün sepette bulundu, güncelleniyor. ID: " + productId);
            existingItem.setCount(existingItem.getCount() + productToAdd.getCount());

            double unitPrice = existingItem.getProduct().getPrice();
            existingItem.setTotalPrice(existingItem.getCount() * unitPrice);

            basketProductRepository.save(existingItem);
        } else {
            log.info("Ürün sepette yok, ekleniyor. ID: " + productId);
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));

            BasketProduct newBasketProduct = new BasketProduct();
            newBasketProduct.setBasket(basket);
            newBasketProduct.setProduct(product);
            newBasketProduct.setCount(productToAdd.getCount());
            newBasketProduct.setTotalPrice(productToAdd.getCount() * product.getPrice());

            basket.getBasketItems().add(newBasketProduct);
        }

        updateBasketTotalPrice(basket);
        return basketRepository.save(basket);
    }

    private Basket createNewBasket(BasketDto basketDto) {
        log.info("Yeni sepet oluşturuluyor...");
        Basket basket = new Basket();

        // CustomerDto'da artık Long id kullanılıyor
        Long customerId = basketDto.getCustomer().getCustomerId();

        if (!customerRepository.existsById(customerId)) {
            throw new RuntimeException("Müşteri bulunamadı!");
        }

        basket.setCustomerId(customerId);
        basket.setStatus(BASKET_STATUS_ACTIVE);

        List<BasketProduct> newBasketItems = new ArrayList<>();

        for (BasketProductDto itemDto : basketDto.getBasketProductList()) {
            // ProductDto'da artık Long id kullanılıyor
            Long productId = itemDto.getProduct().getId();
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));

            BasketProduct basketProduct = new BasketProduct();
            basketProduct.setBasket(basket);
            basketProduct.setProduct(product);
            basketProduct.setCount(itemDto.getCount());
            basketProduct.setTotalPrice(itemDto.getCount() * product.getPrice());

            newBasketItems.add(basketProduct);
        }

        basket.setBasketItems(newBasketItems);

        double total = newBasketItems.stream()
                .mapToDouble(BasketProduct::getTotalPrice).sum();
        basket.setTotalPrice(total);

        return basketRepository.save(basket);
    }

    private void updateBasketTotalPrice(Basket basket) {
        double totalAmount = basket.getBasketItems().stream()
                .mapToDouble(BasketProduct::getTotalPrice)
                .sum();
        basket.setTotalPrice(totalAmount);
    }
}

