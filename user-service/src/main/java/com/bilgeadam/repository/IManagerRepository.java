package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Employee;
import com.bilgeadam.repository.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IManagerRepository extends JpaRepository<Manager, Long> {

}
