package com.example.soalabdemo.persistence;

import com.example.soalabdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByUsername(String username);
}
