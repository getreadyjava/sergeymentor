package ru.preworking.drill.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.preworking.drill.domain.Employee;
import ru.preworking.drill.service.EmployeeService;

/**
 * Контроллер, обрабатывающий запросы к сущности Employee
 * Есть возможность:
 * 1) получить список всех сотрудников,
 * 2) получить сотрудника по id,
 * 3) создать (нужно передавать данные в теле запроса: id, firstName, secondName, patronymic),
 * 4) обновить (нужно передавать данные в теле запроса: id, firstName, secondName, patronymic),
 * 5) удалить сотрудника по id
 * 6) удалить список сотрудников по списку id (JSON массив)
 */
@RestController
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EmployeeController {

    @NonNull
    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = service.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@NonNull @PathVariable("employeeId") String id){
        Optional<Employee> employee = service.getById(id);
        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
    }

    // @todo При создании репозитория, получение id со стороны клиента убрать
    @PostMapping
    public ResponseEntity<Map<String, Boolean>> createEmployee(@RequestBody Employee employee){
        service.add(employee);
        return new ResponseEntity<>(Map.of("success", true), HttpStatus.OK);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Map<String, Boolean>> updateEmployee(@NonNull @PathVariable("employeeId") String id, @RequestBody Employee employee){
        Optional<Employee> updatedEmployee = service.getById(id);
        if (updatedEmployee.isPresent()) {
            service.update(employee);
            return new ResponseEntity<>(Map.of("success", true), HttpStatus.OK);
        }

        return new ResponseEntity<>(Map.of("success", false), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@NonNull @PathVariable("employeeId") String id){
        service.delete(id);
        return new ResponseEntity<>(Map.of("success", true), HttpStatus.OK);
    }

    @DeleteMapping("/delete-list")
    public ResponseEntity<Map<String, Boolean>> deleteManyEmployees(@NonNull @RequestBody List<String> ids){
        service.delete(ids);
        return new ResponseEntity<>(Map.of("success", true), HttpStatus.OK);
    }
}
