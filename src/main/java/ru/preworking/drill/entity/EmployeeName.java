package ru.preworking.drill.entity;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class EmployeeName {

    private String firstName;
    private String secondName;
    private String patronimic;

    public EmployeeName(String f, String s, String p){
        firstName = f;
        secondName = s;
        patronimic = p;
    }

    public String getFullName(){
        return firstName.concat(" ").concat(secondName).concat(" ").concat(patronimic);
    }
}
