package com.example.ecommerce.service.impl;



import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.mapper.UserMapper;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        userRepository.save(user);
        return UserMapper.toDto(user);

    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        User user = userRepository.findById(id).get();


        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        User updatedUser=userRepository.save(user);

        return UserMapper.toDto(updatedUser) ;
    }


    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).get();
        return UserMapper.toDto(user);
    }


    @Override
    public List<UserDto> getAll() {
        return null;
    }


    @Override
    public void delete(Long id) {

    }

}
