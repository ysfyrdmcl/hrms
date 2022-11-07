package com.bilgeadam.service;


import com.bilgeadam.dto.request.CreateEmployeeRequestDto;
import com.bilgeadam.dto.request.UpdateEmployeeRequestDto;
import com.bilgeadam.dto.response.SummaryInfoResponseDto;
import com.bilgeadam.repository.IEmployeeRepository;
import com.bilgeadam.repository.entity.Employee;
import com.bilgeadam.repository.entity.Person;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService extends ServiceManager<Employee, Long> {
    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(CreateEmployeeRequestDto createEmployeeRequestDto) {

        return save(Employee.builder().identityNumber(createEmployeeRequestDto.getIdentityNumber())
                .firstName(createEmployeeRequestDto.getFirstName())
                .middleName(createEmployeeRequestDto.getMiddleName())
                .lastName(createEmployeeRequestDto.getLastName())
                .profilePhoto(createEmployeeRequestDto.getProfilePhoto())
                .birthDay(createEmployeeRequestDto.getBirthDay())
                .startDate(createEmployeeRequestDto.getStartDate())
                .emailAddress(createEmployeeRequestDto.getEmailAddress())
                .phoneNumber(createEmployeeRequestDto.getPhoneNumber())
                .gender(createEmployeeRequestDto.getGender())
                .professionId(createEmployeeRequestDto.getProfessionId())
                .departmentId(createEmployeeRequestDto.getDepartmentId())
                .addressId(createEmployeeRequestDto.getAddressId())
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

    public List<SummaryInfoResponseDto> findSummaryInfo() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<SummaryInfoResponseDto> summaryInfoResponseDtoList = new ArrayList<>();
        employeeList.forEach(employee -> {
            summaryInfoResponseDtoList.add(SummaryInfoResponseDto.builder()
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .phoneNumber(employee.getPhoneNumber())
                    .profilePhoto(employee.getProfilePhoto())
                    .emailAddress(employee.getEmailAddress())
                    .departmentId(employee.getDepartmentId())
                    .professionId(employee.getProfessionId())
                    .build());
        });
        return summaryInfoResponseDtoList;
    }
    public SummaryInfoResponseDto findSummaryInfoById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return SummaryInfoResponseDto.builder()
                    .firstName(employee.get().getFirstName())
                    .lastName(employee.get().getLastName())
                    .phoneNumber(employee.get().getPhoneNumber())
                    .profilePhoto(employee.get().getProfilePhoto())
                    .emailAddress(employee.get().getEmailAddress())
                    .departmentId(employee.get().getDepartmentId())
                    .professionId(employee.get().getProfessionId())
                    .build();
        }
        return SummaryInfoResponseDto.builder().build();
    }

    public List<Employee> findByDepartmentId(Long id) {
        return employeeRepository.findByDepartmentId(id);
    }
}
