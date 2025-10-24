package ru.preworking.drill.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Employee {
    private String id;
    private EmployeeName fio;

    public Employee(String id, String firstName, String secondName, String patronimic){
        this.id = id;
        fio = new EmployeeName(firstName, secondName, patronimic);
    }

    public void updateEmployeeName(String firstName, String secondName, String patronimic){
        fio.setFirstName(firstName);
        fio.setSecondName(secondName);
        fio.setPatronimic(patronimic);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", fio=" + fio +
                '}';
    }
}
