package ru.preworking.drill.service;

import java.util.List;
import java.util.Optional;
import java.util.Objects;

import org.springframework.stereotype.Service;
import ru.preworking.drill.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // Read
    private final List<Employee> employees;

    public EmployeeServiceImpl(){
        employees = List.of(
                new Employee("1", "Иванов", "Иван", "Иванович"),
                new Employee("2", "Петров", "Петр", "Петрович"),
                new Employee("3", "Семёнов", "Семён", "Семёнович")
        );
    }

    // Read
    public Optional<Employee> getById(String id){
        return employees.stream()
                .filter(employee -> Objects.equals(id, employee.getId()))
                .findFirst();
    }

    public List<Employee> getAll(){
        return employees;
    }

    // Create @TODO 1) изменить сигнатуру - возвращать boolean, 2) добавить кастомное исключение
    public void addToList(Employee e){

        employees.addLast(e);
    }

    public void update(Employee e){
        Optional<Employee> currentEmployee = getById(e.getId());
        currentEmployee.ifPresent(employee -> {
            employee.setId(e.getId());
            employee.setFirstName(e.getFirstName());
            employee.setSecondName(e.getSecondName());
            employee.setPatronymic(e.getPatronymic());
        });
    }

    // Delete @TODO 1) изменить сигнатуру - возвращать boolean, 2) добавить кастомное исключение
    public void delete(Employee e){

        employees.remove(e);
    }
}
