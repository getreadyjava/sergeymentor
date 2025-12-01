package ru.preworking.drill.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Employee {
    private String id;
    private String firstName;
    private String secondName;
    private String patronymic;
}
