package ru.preworking.drill.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

//@Getter
//@Setter
//@AllArgsConstructor
public class Employee {

    private String id;
    private String firstName;
    private String secondName;
    private String patronymic;

    public Employee(String id, String firstName, String secondName, String patronymic) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
    }

    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getSecondName() { return secondName; }
    public String getPatronymic() { return patronymic; }

    public void setId(String id) { this.id = id; }
    public void setFirstName(String f) { firstName = f; }
    public void setSecondName(String s) { secondName = s; }
    public void setPatronymic(String p) { patronymic = p; }
}
