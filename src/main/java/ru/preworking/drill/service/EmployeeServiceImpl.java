package ru.preworking.drill.service;

import java.util.*;

import org.springframework.stereotype.Service;
import ru.preworking.drill.domain.Employee;
import lombok.extern.slf4j.Slf4j;

/**
 * Реализует интерфейс {@link EmployeeService}
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService<Employee> {

    private static final List<Employee> employeesArrayInitializer = List.of(
            new Employee("1", "Иванов", "Иван", "Иванович"),
            new Employee("2", "Петров", "Петр", "Петрович"),
            new Employee("3", "Семёнов", "Семён", "Семёнович")
    );

    private List<Employee> employees;

    public EmployeeServiceImpl(){
        employees = new ArrayList<>(employeesArrayInitializer);
    }

    public Optional<Employee> getById(String id){
        return employees.stream()
                .filter(employee -> Objects.equals(id, employee.getId()))
                .findFirst();
    }

    public List<Employee> getAll(){
        return employees;
    }

    public void add(Employee e){
        employees.add(e);
    }

    public void update(Employee e){
        String id = e.getId();
        Optional<Employee> optionalEmployee = getById(id);
        optionalEmployee.ifPresent(employee -> {
            employee.setId(id);
            employee.setFirstName(e.getFirstName());
            employee.setSecondName(e.getSecondName());
            employee.setPatronymic(e.getPatronymic());
        });
    }

    public void delete(String id){
        employees.removeIf(employee -> Objects.equals(id, employee.getId()));
    }

    public void delete(List<String> ids){
        employees.removeIf(employee -> ids.contains(employee.getId()));
    }
}
