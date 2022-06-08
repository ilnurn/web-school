package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private Long generatedFacultyId = 1L;

    public Faculty createFaculty(Faculty faculty) {
        faculties.put(generatedFacultyId, faculty);
        generatedFacultyId++;
        return faculty;
    }

    public Faculty getFacultyById(Long facultyId) {
        return faculties.get(facultyId);
    }

    public Faculty updateFaculty(Long facultyId, Faculty faculty) {
        faculties.put(generatedFacultyId, faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long facultyId) {
        return faculties.remove(facultyId);
    }

    public Collection<Faculty> findFacultiesByColor(String colour) {
        Collection<Faculty> facultiesWithFindingColour = faculties.values().stream()
                .filter(faculty -> faculty.getColor().equals(colour))
                .collect(Collectors.toList());
        return facultiesWithFindingColour;
    }
}
