package com.example.ecommerce.mapper;



import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.request.UserRequest;
import com.example.ecommerce.response.UserResponse;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    public static UserDto toDto(UserRequest userRequest) {
        return UserDto.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())

                .build();


    }

    public static UserResponse toResponse(UserDto userDto) {
        return UserResponse.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();

    }
    public static User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();
    }

    public static UserDto toDto(User user) {

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())

                .build();

    }

}
