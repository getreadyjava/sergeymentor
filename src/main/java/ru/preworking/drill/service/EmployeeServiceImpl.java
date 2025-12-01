package ru.preworking.drill.service;

import java.util.*;

import org.springframework.stereotype.Service;
import ru.preworking.drill.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService<Employee> {

    private static final Employee[] employeesArrayInitializer = {
            Employee.of("1", "Иванов", "Иван", "Иванович"),
            Employee.of("2", "Петров", "Петр", "Петрович"),
            Employee.of("3", "Семёнов", "Семён", "Семёнович")
    };

    private List<Employee> employees;

    public EmployeeServiceImpl(){
        employees = new ArrayList<>(Arrays.asList(employeesArrayInitializer));
    }

    public Optional<Employee> getById(String id){
        return employees.stream()
                .filter(employee -> Objects.equals(id, employee.getId()))
                .findFirst();
    }

    public List<Employee> getAll(){
        return employees;
    }

    public boolean addToList(Employee e){

        return employees.add(e);
    }

    public boolean update(Employee e){
        String id = e.getId();
        Optional<Employee> currentEmployee = getById(id);
        currentEmployee.ifPresent(employee -> {
            employee.setId(id);
            employee.setFirstName(e.getFirstName());
            employee.setSecondName(e.getSecondName());
            employee.setPatronymic(e.getPatronymic());
        });

        return currentEmployee.isPresent();
    }

    public boolean delete(String id){

        return employees.removeIf(employee -> Objects.equals(id, employee.getId()));
    }

    public boolean deleteMany(List<String> ids){
        if (ids != null) {
            return employees.removeIf(employee -> ids.contains(employee.getId()));
        } else {
            return false;
        }
    }
}
