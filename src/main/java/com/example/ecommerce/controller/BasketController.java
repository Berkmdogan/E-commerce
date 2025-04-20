package com.example.ecommerce.controller;


import com.example.ecommerce.mapper.BasketMapper;
import com.example.ecommerce.request.BasketRequest;
import com.example.ecommerce.response.BasketResponse;
import com.example.ecommerce.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baskets")
public class BasketController {
    @Autowired
    private BasketService service;
    @Autowired
    @Lazy
    private BasketMapper basketMapper;
    @PostMapping
    public BasketResponse save(@RequestBody BasketRequest request) {
        return basketMapper.dtoToResponse(service.save(basketMapper.requestToDto(request)));
    }



    @GetMapping("/{id}")
    public BasketResponse get(@PathVariable(name = "id") String id) {
        return basketMapper.dtoToResponse(service.get(id));
    }

    @GetMapping
    public List<BasketResponse> getAll(){
        return basketMapper.mapDtosToResponses(service.getAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public BasketResponse update(@PathVariable(name = "id") String id, @RequestBody BasketRequest request) {
        return basketMapper.dtoToResponse(service.update(id, basketMapper.requestToDto(request)));
    }




}
