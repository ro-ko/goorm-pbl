package com.response.service;


import com.response.domain.Student;
import com.response.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student addStudent(String name, int grade) {
        Student student = new Student(name, grade);
        studentRepository.add(student);
        return student;
    }

    public List<Student> getOrderedStudents() {
        return studentRepository.getSorted();
    }

    public List<Student> getGradeStudents(int grade) {
        return studentRepository.getBy(grade);
    }
}
