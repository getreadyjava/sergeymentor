package ru.preworking.drill.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.preworking.drill.domain.Employee;
import ru.preworking.drill.service.EmployeeServiceImpl;


/**
 * CRUD на сотрудников
 * POST, GET, PUT, DELETE
 *
 * Логирование без WARN, DEBUG
 */
@RestController
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeServiceImpl service;
    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeServiceImpl service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        logger.trace("Получен GET-запрос на получение списка всех сотрудников");
        try {
            List<Employee> employees = service.getAll();

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e /*Будет Custom Exception*/) {
            logger.error("Ошибка при получении из сервисного слоя списка сотрудников", e);

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") String id){
        logger.trace("Получен GET-запрос на инфо о сотруднике с id {}", id);
        try {
            // Этот сниппет предложил IDE, я счёл разумным оставить его)))
            if (id == null) {
                logger.warn("При запросе инфо о сотруднике, в параметре запроса получен пустой id");

                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } // -- конец сниппета

            var employee = service.getById(id).orElse(null);

            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e /*Будет Custom Exception*/) {
            logger.error("Ошибка при получении из сервисного слоя сотрудника с id {}", id, e);

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Map<String, Boolean>> createEmployee(@RequestBody Employee employee){
        String id = employee.getId();
        String firstName = employee.getFirstName();
        String secondName = employee.getSecondName();
        String patronymic = employee.getPatronymic();

        logger.trace("Получен POST-запрос на создание записи о сотруднике. id: {}, firstName: {}, secondName: {}, patronymic: {}", id, firstName, secondName, patronymic);
        try {

            service.addToList(employee);

            return new ResponseEntity<>(Map.of("success", true), HttpStatus.OK);
        } catch (Exception e /*Будет Custom Exception*/) {
            logger.error("Ошибка при создании сотрудника {}", e);

            return new ResponseEntity<>(Map.of("success", false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
