package ru.preworking.drill.service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с сотрудниками
 * @param <T>
 */
public interface EmployeeService<T> {
    /**
     * Получить сотрудника по id
     * В случае отсутствия сотрудника вернуть пустой Optional
     * @param id
     * @return
     */
    Optional<T> getById(String id);

    /**
     * Получить всех сотрудников или пустой список
     * @return
     */
    List<T> getAll();

    /**
     * Добавить сотрудника в список
     * @param employee
     */
    void add(T employee);

    /**
     * Удалить сотрудника по id
     * @param id
     */
    void delete(String id);

    /**
     * Удалить сотрудников по списку id
     * @param ids
     */
    void delete(List<String> ids);

    /**
     * Обновить данные сотрудника
     * @param employee
     */
    void update(T employee);
}
