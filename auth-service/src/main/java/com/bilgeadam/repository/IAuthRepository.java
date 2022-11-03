package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth,Long> {
    Optional<Auth>findOptionalByUsernameIgnoreCaseAndPassword(String username,String password);


    Optional<Auth> findOptionalById(Long authid);
}
