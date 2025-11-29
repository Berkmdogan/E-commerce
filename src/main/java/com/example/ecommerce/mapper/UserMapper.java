package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.request.UserRequest;
import com.example.ecommerce.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    @Mapping(target = "id", ignore = true)
    UserDto toDto(UserRequest userRequest);


    UserResponse toResponse(UserDto userDto);


    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget User entity, UserDto dto);
}
