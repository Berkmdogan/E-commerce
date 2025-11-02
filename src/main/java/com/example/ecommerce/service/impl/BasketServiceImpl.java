package com.example.ecommerce.service.impl;



import com.example.ecommerce.dto.BasketDto;
import com.example.ecommerce.dto.BasketProductDto;
import com.example.ecommerce.entity.Basket;
import com.example.ecommerce.entity.BasketProduct;
import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.mapper.BasketMapper;
import com.example.ecommerce.mapper.CustomerMapper;
import com.example.ecommerce.repository.BasketRepository;
import com.example.ecommerce.service.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class BasketServiceImpl implements BasketService {
    private final BasketRepository repository;
    private final BasketProductService basketProductService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final CustomerService customerService;

    public final int BASKET_STATUS_NONE = 0;

    @Override
    public BasketDto addProductToBasket(BasketDto basketDto) {


        //müşteri ID ve sepet durumu ile aktif sepeti bulur
        Basket basket = repository.findBasketByCustomer_CustomerIdAndStatusEquals(basketDto.getCustomer().getCustomerId(), BASKET_STATUS_NONE);
        if (basket != null) {
            return sepetVarUrunEKle(basket, basketDto);
        } else {
            return sepetYokYeniSepetOlustur(basketDto);
        }
    }

    @Override
    public BasketDto getBasketByCustomerId(String customerId) {
        Basket basket = repository.findBasketByCustomer_CustomerIdAndStatusEquals(Integer.parseInt(customerId), BASKET_STATUS_NONE);
        return BasketMapper.toDto(basket);
    }


    @Override
    public void removeProductFromBasket(String basketItemId) {
        basketProductService.delete(Integer.parseInt(basketItemId));
    }

    private BasketDto sepetVarUrunEKle(Basket basket, BasketDto basketDto) {
        List<BasketProduct> basketItemList = basket.getBasketProductList(); //sepette mevcut ürünlerin listesi
        BasketProduct basketProduct = basketProductService.findBasketItemByBasketIdAndProductId(basket.getBasketId(), basketDto.getBasketProductList().get(0).getProduct().getId());
        if (basketProduct == null) {  //Eğer ürün sepette yoksa yeni bir ürün eklenir
            System.out.println("Eklenen ürün sepette yok");
            BasketProduct newBasketProduct = new BasketProduct();
            Product product = findProductById(basketDto.getBasketProductList().get(0).getProduct().getId());
            //Product product=basketItem.getProduct();//ürünü sepette olmayan bir ürün olarak alıyor bunun içinde 58. satır gereklidir
            newBasketProduct.setProduct(product);
            newBasketProduct.setBasket(basket);
            newBasketProduct.setCount(basketDto.getBasketProductList().get(0).getCount());
            newBasketProduct.setBasketProductTotalPrice(basketDto.getBasketProductList().get(0).getCount() * product.getPrice());

            basketItemList.add(newBasketProduct);

        } else {  //ürün sepetete varsa miktar güncellenir
            System.out.println("Ekelenen ürün sepette var");
            System.out.println("liste var mı" + basketDto.getBasketProductList());
            System.out.println("basketItemList boş mu" + basketDto.getBasketProductList().get(0).getProduct().getName());
            System.out.println("BasketItem" + basketProduct);

            //Eklenen ürün sepette var
            Product product = basketProduct.getProduct();//mevcut ürünü alıyorum
            basketProduct.setProduct(product);
            basketProduct.setCount(basketDto.getBasketProductList().get(0).getCount());
            basketProduct.setBasket(basket);
            basketProduct.setBasketProductTotalPrice(basketDto.getBasketProductList().get(0).getCount() * product.getPrice());//yeni toplam fiyat belirlenir
        }

        basket.setTotalPrice(calculateBasketAmount(basket.getBasketId()));//sepet toplamı hesaplanır
        basket.setBasketProductList(basketItemList);
        repository.save(basket);
        return BasketMapper.toDto(basket);
    }

    private double calculateBasketAmount(int basketId) {
        Basket basket = repository.findBasketByBasketId(basketId);
        double totalAmount = 0.0;
        for (BasketProduct basketProduct : basket.getBasketProductList()) {
            totalAmount += basketProduct.getBasketProductTotalPrice();
        }
        return totalAmount;
    }


    private Product findProductById(int productId) {
        return BasketMapper.toEntity(categoryService, productService.getProduct(productId));
    }

    private BasketDto sepetYokYeniSepetOlustur(BasketDto basketDto) {
        Basket basket = new Basket();
        Customer customer = findCustomerById(String.valueOf(basketDto.getCustomer().getCustomerId()));
        basket.setCustomer(customer);
        basket.setStatus(BASKET_STATUS_NONE);
        List<BasketProduct> basketProductList = new ArrayList<>();
        for (BasketProductDto basketProductDto : basketDto.getBasketProductList()) {
            BasketProduct basketProduct = new BasketProduct();
            basketProduct.setBasketProductTotalPrice(basketProductDto.getCount());
            basketProduct.setProduct(findProductById(basketProductDto.getProduct().getId()));
            basketProduct.setBasket(basket);
            basketProduct.setCount(basketProductDto.getCount());
            basketProductList.add(basketProduct);

        }
        basket.setBasketProductList(basketProductList);
        basket.setTotalPrice(basket.getBasketProductList().get(0).getCount() * basketProductList.get(0).getProduct().getPrice());

        return BasketMapper.toDto(repository.save(basket));
    }


    public Customer findCustomerById(String id) {
        return CustomerMapper.toEntity(customerService.getCustomer(Long.valueOf(id)));
    }
}




