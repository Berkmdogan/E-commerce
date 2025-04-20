package com.example.ecommerce.repository;



import com.example.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //UserDto findUserById(Long id);

    //UserDto deleteUserById(Long id);

}
