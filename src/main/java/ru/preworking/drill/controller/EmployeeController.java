package ru.preworking.drill.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.preworking.drill.entity.Employee;
import ru.preworking.drill.service.EmployeeService;

/**
 * CRUD на сотрудников
 * POST, GET, PUT, DELETE
 */
@RestController
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    final private EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = service.getEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") String id){
        return new ResponseEntity<>(service.getEmployeeById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping("/living-test")
    public String hello() {
        return "Drill Application Live!";
    }
}
