package ru.preworking.drill.service;

import java.util.List;
import java.util.Optional;
import ru.preworking.drill.domain.Employee;

public interface EmployeeService {
    Optional<Employee> getById(String id);

    List<Employee> getAll();

    void addToList(Employee employee);

    void delete(Employee employee);

    void update(Employee employee);
}
