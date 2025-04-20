package com.example.ecommerce.service;



import com.example.ecommerce.dto.BasketDto;

import java.util.List;

public interface BasketService {
    public BasketDto save(BasketDto dto);
    public BasketDto get(String id);
    public void delete(String id);
    public BasketDto update(String id, BasketDto dto);
    public List<BasketDto> getAll();
}
