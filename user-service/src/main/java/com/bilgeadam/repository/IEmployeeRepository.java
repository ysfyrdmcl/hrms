package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long id);
}
