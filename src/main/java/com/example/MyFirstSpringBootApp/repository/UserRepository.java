package com.example.MyFirstSpringBootApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MyFirstSpringBootApp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
