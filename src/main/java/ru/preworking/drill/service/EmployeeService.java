package ru.preworking.drill.service;

import java.util.List;
import java.util.Optional;

public interface EmployeeService<T> {
    Optional<T> getById(String id);

    List<T> getAll();

    boolean addToList(T employee);

    boolean delete(String id);

    boolean update(T employee);
}
