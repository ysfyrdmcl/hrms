package com.bilgeadam.service;


import com.bilgeadam.dto.request.CreateEmployeeRequestDto;
import com.bilgeadam.repository.IEmployeeRepository;
import com.bilgeadam.repository.entity.Employee;
import com.bilgeadam.repository.entity.Person;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends ServiceManager<Employee, Long> {
    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(CreateEmployeeRequestDto createEmployeeRequestDto)
    {

        return save(Employee.builder().firstName(createEmployeeRequestDto.getFirstName())
                .lastName(createEmployeeRequestDto.getLastName())
                .emailAddress(createEmployeeRequestDto
                .getEmailAddress()).build());

    }
}
