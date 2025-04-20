package com.example.ecommerce.service;



import com.example.ecommerce.dto.UserDto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface UserService {
    public UserDto save(UserDto dto);


    @Cacheable(value = "users", key = "#id")
    UserDto get(Long id);

    @CacheEvict(value = "users", key = "#id")
    void delete(Long id);

    @CachePut(value = "users", key = "#id")
    UserDto update(Long id, UserDto dto);

    public UserDto get(String id);
    public void delete(String id);
    public UserDto update(String id, UserDto dto);
    public List<UserDto> getAll();



}
