package com.bilgeadam.controller;

import com.bilgeadam.dto.request.CreateEmployeeRequestDto;
import com.bilgeadam.dto.request.UpdateEmployeeRequestDto;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.UserManagerException;
import com.bilgeadam.service.EmployeeService;
import com.bilgeadam.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.bilgeadam.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + MANAGER)
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;
    private final EmployeeService employeeService;

    @PostMapping(NEW_CREATE_EMPLOYEE)
    public ResponseEntity<Boolean> createEmployee(@RequestBody @Valid CreateEmployeeRequestDto createEmployeeRequestDto) {
        try {
            employeeService.createEmployee(createEmployeeRequestDto);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            throw new UserManagerException(ErrorType.EMPLOYEE_DONT_CREATE);
        }
    }
    @GetMapping("/update")
    public ResponseEntity<Boolean> updateEmployee(@RequestBody @Valid Long id,UpdateEmployeeRequestDto updateEmployeeRequestDto) {
        try {
            employeeService.updateEmployee(id,updateEmployeeRequestDto);
            return ResponseEntity.ok(true);
        } catch (Exception e) {

        }
        return null;
    }



}
