package com.bilgeadam.controller;

import com.bilgeadam.dto.request.CreateEmployeeRequestDto;
import com.bilgeadam.dto.request.UpdateEmployeeRequestDto;
import com.bilgeadam.dto.response.SummaryInfoResponseDto;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.UserManagerException;
import com.bilgeadam.repository.entity.Employee;
import com.bilgeadam.repository.enums.State;
import com.bilgeadam.service.EmployeeService;
import com.bilgeadam.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import static com.bilgeadam.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + MANAGER)
@RequiredArgsConstructor
@CrossOrigin("*")
public class ManagerController {
    private final ManagerService managerService;
    private final EmployeeService employeeService;

    @PostMapping(NEW_CREATE_EMPLOYEE)
    public ResponseEntity<Boolean> createEmployee(@RequestBody @Valid CreateEmployeeRequestDto createEmployeeRequestDto ) {
        try {
            employeeService.createEmployee(createEmployeeRequestDto);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            throw new UserManagerException(ErrorType.EMPLOYEE_DONT_CREATE);
        }
    }
    /**
     *Update Empoloyee frontend kısmında düzenlenecek.
     */
    @PostMapping(UPDATE_EMPLOYEE)
    public ResponseEntity<Boolean> updateEmployee(@RequestBody UpdateEmployeeRequestDto updateEmployeeRequestDto, Long id) {
        try {
            employeeService.updateEmployee(id, updateEmployeeRequestDto);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            throw new UserManagerException(ErrorType.EMPLOYEE_DONT_UPDATE);
        }

    }

    @PostMapping(FIND_SUMMARY_INFO_BY_ID)
    public ResponseEntity<SummaryInfoResponseDto> findSummaryInfoById(@RequestParam @Valid Long id) {
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
    public ResponseEntity<List<Employee>> findByDepartmentId(@RequestParam @Valid Long id) {
        try {
            return ResponseEntity.ok(employeeService.findByDepartmentId(id));
        } catch (Exception e) {
            throw new UserManagerException(ErrorType.CANNOT_FIND_USER);
        }
    }
    /**
     * Çalışanın izinli olduğunu göstermek için state'ini passive çeken endpoint
     */
    @PostMapping("/changeEmployeeStateToPassive")
    public ResponseEntity<Boolean> changeStatusToPassive (@RequestParam @Valid Long employeeId){
        Optional<Employee> employee = employeeService.findOptionalById(employeeId);
        try {
            if (employee.isPresent()){
                employee.get().setState(State.PASSIVE);
                employeeService.update(employee.get());
                return ResponseEntity.ok().body(true);
            }
        }
        catch (Exception e){
            throw new RuntimeException("Employee not found");
        }
        return ResponseEntity.ok().body(false);
    }

    /**
     * Çalışanın silinmiş olduğunu göstermek için state'ini deleteye çeken endpoint
     */
    @PostMapping("/changeEmployeeStateToDelete")
    public ResponseEntity<Boolean> changeStatusToDelete (@RequestParam @Valid Long employeeId){
        Optional<Employee> employee = employeeService.findOptionalById(employeeId);
        try {
            if (employee.isPresent()){
                employee.get().setState(State.DELETED);
                employeeService.update(employee.get());
                return ResponseEntity.ok().body(true);
            }
        }
        catch (Exception e){
            throw new RuntimeException("Employee not found");
        }
        return ResponseEntity.ok().body(false);
    }

    /**
     * Tüm employee'leri liste olarak dönen endpoint. Frontendde istenilen bilgiler özet şeklinde geri dönülecek
     */
    @GetMapping("/findAllEmployee")
    public ResponseEntity<List<Employee>>findAllEmployee(){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Employee> findById(@PathVariable  Long  id){
        return ResponseEntity.ok(employeeService.findById(id));
    }
    @PostMapping("/updatebyid/{id}")
    public ResponseEntity<Boolean> updateEmployee(@PathVariable  Long id,@RequestBody  UpdateEmployeeRequestDto updateEmployeeRequestDto) {
        try {
            employeeService.updateEmployee(id,updateEmployeeRequestDto);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            throw new UserManagerException(ErrorType.EMPLOYEE_DONT_CREATE);
        }
    }
}
