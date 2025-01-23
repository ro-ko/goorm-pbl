package com.response.repository;


import com.response.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    Set<Student> students = new HashSet<>();

    public void add(Student student) {
        students.add(student);
    }

    public List<Student> getSorted() {
        return students.stream().sorted().collect(Collectors.toList());
    }

    public List<Student> getBy(int grade) {
        return students.stream()
                .filter(student -> student.getGrade() == grade)
                .toList();
    }
}
