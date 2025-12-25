package ru.preworking.drill.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ru.preworking.drill.domain.Employee;
import ru.preworking.drill.domain.Employee;
import ru.preworking.drill.service.EmployeeService;
import ru.preworking.drill.service.EmployeeServiceImpl;

public class EmployeeServiceImplTests {
    private final EmployeeService<Employee> employeeService = new EmployeeServiceImpl();

    // TODO переписать этот тест, после задания репозитория
    @Test
    @DisplayName("Тест получения сотрудника по id")
    public void testGetById() {
        assertEquals("2", employeeService.getById("2").get().getId());
    }

    @Test
    @DisplayName("Тест получения всех сотрудников")
    public void testGetAll() {}

    @Test
    @DisplayName("Тест добавления сотрудника")
    public void testAdd() {}

    @Test
    @DisplayName("Тест удаления сотрудника по id")
    public void testDelete() {}

    @Test
    @DisplayName("Тест удаления нескольких сотрудников по списку id")
    public void testDeleteAll() {}

    @Test
    @DisplayName("Тест обновления сотрудника")
    public void testUpdate() {}
}
