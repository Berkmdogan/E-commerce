package com.example.ecommerce.mapper;


import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.request.UserRequest;
import com.example.ecommerce.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class UserMapper {
    public UserResponse dtoToResponse(UserDto dto) {
        return  UserResponse.builder()
                .id(dto.getId())
                .userName(dto.getUserName())
                .fullName(dto.getFullName())
                .password(dto.getPassword())
                .telNo(dto.getTelNo())
                .birthDate(dto.getBirthDate())
                .birthPlace(dto.getBirthPlace())
                .tckn(dto.getTckn())
                .build();
    }
    public List<UserResponse> dtosToResponses(List<UserDto> userDtoList){
        return userDtoList.stream()
                .map(this::dtoToResponse)
                .collect(Collectors.toList());
    }
    public UserDto requestToDto(UserRequest request) {
        return UserDto.builder()
                .userName(request.getUserName())
                .fullName(request.getFullName())
                .password(request.getPassword())
                .birthDate(request.getBirthDate())
                .birthPlace(request.getBirthPlace())
                .telNo(request.getTelNo())
                .tckn(request.getTckn())
                .build();
    }
    public User dtoToEntity(UserDto dto) {
        User user = new User();
        user.setId(user.getId());
        user.setUserName(dto.getUserName());
        user.setFullName(dto.getFullName());
        user.setPassword(dto.getPassword());
        user.setBirthDate(dto.getBirthDate());
        user.setBirthPlace(dto.getBirthPlace());
        user.setTelNo(dto.getTelNo());
        user.setTckn(dto.getTckn());
        return user;

    }

    public UserDto entityToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        dto.setFullName(user.getFullName());
        dto.setPassword(user.getPassword());
        dto.setBirthDate(user.getBirthDate());
        dto.setBirthPlace(user.getBirthPlace());
        dto.setTelNo(user.getTelNo());
        dto.setTckn(user.getTckn());
        return dto;
    }
}
