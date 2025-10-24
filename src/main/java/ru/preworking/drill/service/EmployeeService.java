package ru.preworking.drill.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import ru.preworking.drill.entity.Employee;
import ru.preworking.drill.entity.EmployeeName;

@Service
public class EmployeeService {

    final private List<Employee> employees;

    public EmployeeService(){
        employees = new ArrayList<>();
    }

    // Read
    public List<Employee> getEmployees(){
        return employees;
    }

    // Read
    public Optional<Employee> getEmployeeById(String id){
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst();
    }

    // Create @TODO 1) изменить сигнатуру - возвращать boolean, 2) добавить кастомное исключение
    public void addEmployeeToList(Employee e){
        employees.addLast(e);
    }

    // Update @TODO 1) изменить сигнатуру - возвращать boolean, 2) добавить кастомное исключение
    public void updateEmployee(Employee e){
        Optional<Employee> currentEmployee = getEmployeeById(e.getId());
        currentEmployee.ifPresent(employee -> {
            EmployeeName fio = e.getFio();
            employee.updateEmployeeName(fio.getFirstName(), fio.getSecondName(), fio.getPatronimic());
        });
    }

    // Delete @TODO 1) изменить сигнатуру - возвращать boolean, 2) добавить кастомное исключение
    public void deleteEmployee(Employee e){

        employees.remove(e);
    }
}
