package com.practice.bbas.repository;

import com.practice.bbas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Integer, User> {

}
