package com.practice.bbas.repository;

import com.practice.bbas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByName(String name);

    User findByName(String name);
}
