package com.response.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Getter
@Data
@AllArgsConstructor
public class Student implements Comparable<Student>{

    private String name;
    private int grade;

    @Override
    public int compareTo(Student student) {
        return student.grade - this.grade;
    }
}
