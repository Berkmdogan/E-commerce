package com.example.ecommerce.controller;


import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.mapper.UserMapper;
import com.example.ecommerce.request.UserRequest;
import com.example.ecommerce.response.UserResponse;
import com.example.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    private final UserMapper UserMapper;

    @PostMapping("create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserDto userDto = UserMapper.toDto(userRequest);
        return ResponseEntity.ok(UserMapper.toResponse(userService.save(userDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponse> update(@PathVariable("id") Long userId, @RequestBody UserRequest userRequest) { // Parametreler düzeltildi
        UserDto userDto = UserMapper.toDto(userRequest);
        UserDto user = userService.update(userId, userDto);
        return ResponseEntity.ok(UserMapper.toResponse(user));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id")  Long id){
        UserDto userDto =userService.getUser(id);
        return ResponseEntity.ok(UserMapper.toResponse(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUser() {
        List<UserDto> userDtoList = userService.getAll();

        List<UserResponse> userResponseList = userDtoList.stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userResponseList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long Userid){
        userService.delete(Userid);
        return ResponseEntity.ok("User deleted successdully");
    }

}
