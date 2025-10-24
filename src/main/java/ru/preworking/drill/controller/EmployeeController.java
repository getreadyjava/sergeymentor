package ru.preworking.drill.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * CRUD на сотрудников
 * POST, GET, PUT, DELETE
 */
@RestController
public class EmployeeController {

    @GetMapping("/living-test")
    public String hello() {
        return "Hello from Drill Application!";
    }
}
