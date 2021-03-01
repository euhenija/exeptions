package university;

import enums.FacultyName;

import java.util.HashMap;
import java.util.Map;

public class Faculty {
    private FacultyName facultyName;
    private Map<Integer, Group> mapOfFacultyGroups = new HashMap<>();

    public Map<Integer, Group> getMapOfFacultyGroups() {
        return mapOfFacultyGroups;
    }

    public void addGroupToFaculty(Integer groupNumber, Group mapOfFacultyGroups) {
        this.mapOfFacultyGroups.put(groupNumber, mapOfFacultyGroups);
    }

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }

    @Override
    public String toString() {
        return "mapOfFacultyGroups=" + mapOfFacultyGroups +
                '}';
    }
}
