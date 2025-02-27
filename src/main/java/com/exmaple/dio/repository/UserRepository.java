package com.exmaple.dio.repository;

import com.exmaple.dio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);
}
