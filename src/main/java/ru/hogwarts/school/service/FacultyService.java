package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service

public class FacultyService {
    private Map<Long, Faculty> faculties = new HashMap<>();
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

    public Set<Faculty> findFacultiesByColor(String colour) {
        Set<Faculty> facultiesWithFindingColour = new HashSet<>();
        for (Faculty faculty : faculties.values()) {
            if (faculty.getColor().equals(colour)) {
                facultiesWithFindingColour.add(faculty);
            }
        }
        if (facultiesWithFindingColour == null) {
            throw new NotFoundException("факультетов с таким цветом нет");
        }
        return facultiesWithFindingColour;
    }
}
