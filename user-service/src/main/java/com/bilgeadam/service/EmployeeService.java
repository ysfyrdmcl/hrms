package com.bilgeadam.service;


import com.bilgeadam.dto.request.CreateEmployeeRequestDto;
import com.bilgeadam.dto.request.UpdateEmployeeRequestDto;
import com.bilgeadam.repository.IEmployeeRepository;
import com.bilgeadam.repository.entity.Employee;
import com.bilgeadam.repository.entity.Person;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService extends ServiceManager<Employee, Long> {
    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(CreateEmployeeRequestDto createEmployeeRequestDto) {

        return save(Employee.builder().firstName(createEmployeeRequestDto.getFirstName())
                .lastName(createEmployeeRequestDto.getLastName())
                .state(createEmployeeRequestDto.getState())
                .emailAddress(createEmployeeRequestDto
                        .getEmailAddress()).build());

    }

    public Employee updateEmployee(Long id, UpdateEmployeeRequestDto updateEmployeeRequestDto) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employee.get().setEmailAddress(updateEmployeeRequestDto.getEmailAddress());
            employee.get().setPhoneNumber(updateEmployeeRequestDto.getPhoneNumber());
            employee.get().setProfilePhoto(updateEmployeeRequestDto.getProfilePhoto());

            employee.get().setState(updateEmployeeRequestDto.getState());
        }
        return null;
    }

    public Optional<Employee> findOptionalById(Long employeeId){
        return employeeRepository.findOptionalById(employeeId);
    }
}
