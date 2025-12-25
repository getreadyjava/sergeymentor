package ru.preworking.drill.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import ru.preworking.drill.domain.Employee;
import ru.preworking.drill.controller.EmployeeController;
import ru.preworking.drill.service.EmployeeService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

  @Autowired
  private MockMvc mockMvc;
  private EmployeeService service;
  private EmployeeController controller;

  @Test
  @DisplayName("Тест на getAllEmployees")
  public void testGetAllEmployees(){
    //mockMvc.perform(get("/employees")).andExpect(status().isOk()).andExpect(content().contentType("application/json"));
  }

  @Test
  @DisplayName("Тест на getEmployeeById")
  public void testGetEmployeeById(){}

  @Test
  @DisplayName("Тест на createEmployee")
  public void testCreateEmployee(){}

  @Test
  @DisplayName("Тест на updateEmployee")
  public void testUpdateEmployee(){}

  @Test
  @DisplayName("Тест на deleteEmployee")
  public void testDeleteEmployee(){}

  @Test
  @DisplayName("Тест на deleteManyEmployees")
  public void testDeleteManyEmployees(){}
}
