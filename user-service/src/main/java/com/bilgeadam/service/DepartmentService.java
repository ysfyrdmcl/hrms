package com.bilgeadam.service;

import com.bilgeadam.repository.IDepartmentRepository;
import com.bilgeadam.repository.entity.Department;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends ServiceManager<Department, Long> {
    private final IDepartmentRepository departmentRepository;

    public DepartmentService(IDepartmentRepository departmentRepository) {
        super(departmentRepository);
        this.departmentRepository = departmentRepository;
    }
}
