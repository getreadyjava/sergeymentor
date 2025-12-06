package ru.preworking.drill.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ru.preworking.drill.domain.Employee;
import ru.preworking.drill.controller.EmployeeController;
/**
 * {@see https://docs.spring.io/spring-framework/reference/testing/webtestclient.html}
 */
//import org.springframework.test.web.reactive.server.WebTestClient;
import ru.preworking.drill.service.EmployeeService;

public class EmployeeControllerTests {
//  private WebTestClient client;
  private EmployeeService service;
  private EmployeeController controller;

  @Test
  public void testClient(){
//    client = WebTestClient.bindToController(new EmployeeController(service)).build();
  }

  @Test
  @DisplayName("Тест на getAllEmployees")
  public void testGetAllEmployees(){}

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
