package com.algoriant.sms.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Student {

    @Id
    private int id;
    private String name;
    private int number;

    public Student(Student student) {
    }
}
