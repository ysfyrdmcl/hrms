package com.bilgeadam.controller;

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

import static com.bilgeadam.constants.ApiUrls.BASE_URL;
import static com.bilgeadam.constants.ApiUrls.MANAGER;

@RestController
@RequestMapping("/Controller")
@RequiredArgsConstructor
public class YusufController {

    private final EmployeeService employeeService;

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
     * Tüm employee'leri liste olarak dönen endpoint. Frontendde istenilen bilgeler geri dönülecek
     * Employee Serviceye ve Reposuna birer method eklendi
     */
     @PostMapping("/findAllEmployee")
    public ResponseEntity<List<Employee>>findAllEmployee(){
       return ResponseEntity.ok(employeeService.findAll());
    }


}
