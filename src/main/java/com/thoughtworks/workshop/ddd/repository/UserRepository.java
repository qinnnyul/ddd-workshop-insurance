package com.thoughtworks.workshop.ddd.repository;

import com.thoughtworks.workshop.ddd.domain.User;

public interface UserRepository {
    void save(User user);

    User findByUuid(String uuid);

    User findByEmail(String email);

    boolean isAlreadyExistby(String email);
}
