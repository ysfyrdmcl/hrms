package com.bilgeadam.service;


import com.bilgeadam.repository.IManagerRepository;
import com.bilgeadam.repository.entity.Employee;
import com.bilgeadam.repository.entity.Manager;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService extends ServiceManager<Manager, Long> {
    private final IManagerRepository managerRepository;

    public ManagerService(IManagerRepository managerRepository) {
        super(managerRepository);
        this.managerRepository = managerRepository;
    }

}
