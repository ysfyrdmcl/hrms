package com.bilgeadam.controller;

import com.bilgeadam.dto.request.CreateEmployeeRequestDto;
import com.bilgeadam.dto.request.UpdateEmployeeRequestDto;
import com.bilgeadam.dto.response.SummaryInfoResponseDto;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.UserManagerException;
import com.bilgeadam.repository.entity.Employee;
import com.bilgeadam.service.EmployeeService;
import com.bilgeadam.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

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

    public ResponseEntity<Boolean> updateEmployee(@RequestBody @Valid Long id, @RequestBody @Valid UpdateEmployeeRequestDto updateEmployeeRequestDto) {
        try {
            employeeService.updateEmployee(id, updateEmployeeRequestDto);
            return ResponseEntity.ok(true);
        } catch (Exception e) {

        }
        return null;
    }

    @PostMapping(FIND_SUMMARY_INFO_BY_ID)
    public ResponseEntity<SummaryInfoResponseDto> findSummaryInfoById(@RequestBody @Valid Long id) {
        try {
            return ResponseEntity.ok(employeeService.findSummaryInfoById(id));
        } catch (Exception e) {
            throw new UserManagerException(ErrorType.CANNOT_FIND_USER);
        }
    }

    @PostMapping(FIND_SUMMARY_INFO)
    public ResponseEntity<List<SummaryInfoResponseDto>> findSummaryInfo() {
        try {
            return ResponseEntity.ok(employeeService.findSummaryInfo());
        } catch (Exception e) {
            throw new UserManagerException(ErrorType.CANNOT_FIND_USER);
        }
    }

    @PostMapping(FIND_ALL_BY_DEPARTMENT_ID)
    public ResponseEntity<List<Employee>> findByDepartmentId(@RequestBody @Valid Long id) {
        try {
            return ResponseEntity.ok(employeeService.findByDepartmentId(id));
        } catch (Exception e) {
            throw new UserManagerException(ErrorType.CANNOT_FIND_USER);
        }
    }


}
