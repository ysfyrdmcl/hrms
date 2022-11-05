package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Employee;
import com.bilgeadam.repository.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
