package com.example.ecommerce.service;



import com.example.ecommerce.dto.UserDto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);

    UserDto getUser(Long id);

    List<UserDto> getAll();

    UserDto update(Long id ,UserDto userDto);

    void delete(Long id);

}
