package com.platzi.makert.domain.repository;

import com.platzi.makert.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);

    User save(User user);
}
