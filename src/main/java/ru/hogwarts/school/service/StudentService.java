package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private Long generatedStudentId = 1L;

    public Student createStudent(Student student) {
        students.put(generatedStudentId, student);
        generatedStudentId++;
        return student;
    }

    public Student getStudentById(Long studentId) {
        return students.get(studentId);
    }

    public Student updateStudent(Long studentId, Student student) {
        students.put(generatedStudentId, student);
        return student;
    }

    public Student deleteStudent(Long studentId) {
        return students.remove(studentId);
    }

    public Collection<Student> findStudentsWithFindingAge(int age) {
        Collection<Student> studentsWithFindingAge = students.values().stream()
                .filter(faculty -> faculty.getAge() == age)
                .collect(Collectors.toList());
        return studentsWithFindingAge;
    }
}
