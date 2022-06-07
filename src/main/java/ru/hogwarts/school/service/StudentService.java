package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service

public class StudentService {
    private Map<Long, Student> students = new HashMap<>();
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

    public Set<Student> findStudentsWithFindingAge(int age) {
        Set<Student> studentsWithFindingAge = new HashSet<>();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                studentsWithFindingAge.add(student);
            }
        }
        if (studentsWithFindingAge == null) {
            throw new NotFoundException("студентов с таким возрастом нет");
        }
        return studentsWithFindingAge;
    }
}
