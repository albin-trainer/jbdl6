package com.library.secure.repo;
import org.springframework.data.repository.CrudRepository;

import com.library.entity.User;



public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String username);
}