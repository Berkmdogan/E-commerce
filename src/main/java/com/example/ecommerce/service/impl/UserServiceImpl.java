package com.example.ecommerce.service.impl;


import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.exception.RecordNotFoundExceptions;
import com.example.ecommerce.mapper.UserMapper;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDto save(UserDto dto) {
        return userMapper.entityToDto(repository.save(userMapper.dtoToEntity(dto)));
    }

    @Override
    @Cacheable(value = "users")
    public UserDto get(Long id) {
        System.out.println("veritabanından id getir: " + id);
        User user = repository.findById(Long.parseLong(String.valueOf(id)))
                .orElseThrow(() -> new RecordNotFoundExceptions(4000, "User not found with id: " + id));
        return userMapper.entityToDto(user);
    }
    @Override
    @CacheEvict(value = "users")
    public void delete(Long id) {
        repository.deleteById(Long.parseLong(String.valueOf(id)));
    }
    @Override
    @CachePut(value = "users")
    public UserDto update(Long id, UserDto dto) {
        User user = repository.findById(Long.parseLong(String.valueOf(id)))
                .orElseThrow(() -> new RecordNotFoundExceptions(4000, "User not found with id: " + id));



        User updatedUser = userMapper.dtoToEntity(dto);
        updatedUser.setId(user.getId());

        return userMapper.entityToDto(repository.save(updatedUser));
    }



    @Override
    public UserDto get(String id) {
        User user = repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new RecordNotFoundExceptions(4000, "User not fund with" + id));

        return userMapper.entityToDto(user);
    }


    @Override
    public void delete(String id) {
        repository.deleteById(Long.parseLong(id));
    }

    @Override
    public UserDto update(String id, UserDto dto) {
        User userCategory = repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new RecordNotFoundExceptions(4000, "User not found with id" + id));

        User updateUser = userMapper.dtoToEntity(dto);
        updateUser.setId(userCategory.getId());

        return userMapper.entityToDto(repository.save(updateUser));

    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : repository.findAll()) {
            userDtoList.add(userMapper.entityToDto(user));
        }
        return userDtoList;
    }


    public User findUserById(Long userId) {
        if(userId == null){
            throw  new IllegalArgumentException("The given id must not be null");
        }
        return repository.findById(userId).orElseThrow();
    }
}
