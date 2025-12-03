package ru.preworking.drill.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.preworking.drill.domain.Employee;
import ru.preworking.drill.service.EmployeeService;

/**
 * CRUD на сотрудников
 * POST, GET, PUT, DELETE
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeService service;
    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        try {
            List<Employee> employees = service.getAll();

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e /*Будет Custom Exception*/) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") String id){
        try {
            if (id == null) {

                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            Employee employee = (Employee) service.getById(id);
System.out.println("employee: " + employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e /*Будет Custom Exception*/) {
            System.out.println("catched exception: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @todo При создании репозитория, получение id со стороны клиента убрать
    @PostMapping
    public ResponseEntity<Map<String, Boolean>> createEmployee(@RequestBody Employee employee){
         try {

            service.add(employee);

            return new ResponseEntity<>(Map.of("success", true), HttpStatus.OK);
        } catch (Exception e /*Будет Custom Exception*/) {

            return new ResponseEntity<>(Map.of("success", false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Map<String, Boolean>> updateEmployee(@PathVariable("employeeId") String id, @RequestBody Employee employee){
        if (id == null) {

            return new ResponseEntity<>(Map.of("success", false), HttpStatus.BAD_REQUEST);
        } else {

            Employee employeeOptional = (Employee) service.getById(id);

            if (employeeOptional != null) {
                service.update(employee);
                return new ResponseEntity<>(Map.of("success", true), HttpStatus.OK);
            }

            return new ResponseEntity<>(Map.of("success", false), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable("employeeId") String id){
        if (id == null) {

            return new ResponseEntity<>(Map.of("success", false), HttpStatus.BAD_REQUEST);
        } else {
            service.delete(id);
            return new ResponseEntity<>(Map.of("success", true), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete-list")
    public ResponseEntity<Map<String, Boolean>> deleteManyEmployees(@RequestBody List<String> ids){
        if (ids == null) {

            return new ResponseEntity<>(Map.of("success", false), HttpStatus.BAD_REQUEST);
        } else {
            service.delete(ids);
            return new ResponseEntity<>(Map.of("success", true), HttpStatus.OK);
        }
    }
}
