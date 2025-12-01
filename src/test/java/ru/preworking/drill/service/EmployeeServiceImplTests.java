package ru.preworking.drill.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.preworking.drill.domain.Employee;
import ru.preworking.drill.domain.Employee;
import ru.preworking.drill.service.EmployeeService;
import ru.preworking.drill.service.EmployeeServiceImpl;

public class EmployeeServiceImplTests {
    private final EmployeeService<Employee> employeeService = new EmployeeServiceImpl();

    // TODO переписать этот тест, после задания репозитория
    @Test
    public void testGetEmployee() {
        assertEquals("2", employeeService.getById("2").get().getId());
    }
}
