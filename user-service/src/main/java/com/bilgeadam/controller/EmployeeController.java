package com.bilgeadam.controller;

import com.bilgeadam.dto.request.CreateEmployeeRequestDto;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.UserManagerException;
import com.bilgeadam.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.bilgeadam.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + EMPLOYEE)
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping(NEW_CREATE_EMPLOYEE)
    public ResponseEntity<Boolean> createEmployee(@RequestBody @Valid CreateEmployeeRequestDto createEmployeeRequestDto)
    {
        try {
            employeeService.createEmployee(createEmployeeRequestDto);
            return ResponseEntity.ok(true);
        }catch (Exception e){
            throw new UserManagerException(ErrorType.EMPLOYEE_DONT_CREATE);
        }
    }
}
