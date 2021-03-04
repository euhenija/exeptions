package university;

import exceptions.*;
import java.util.HashMap;
import java.util.Map;

public class University {

    private String universityName;
    private HashMap<String, Faculty> mapOfFaculties;

    public University(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public HashMap<String, Faculty> getMapOfFaculties() throws UniversityHasNoFacultiesException {
        return mapOfFaculties;
    }

    public void setFacultiesToUniversity(HashMap<String, Faculty> university) {
        this.mapOfFaculties = university;
    }

    public float getUniversityAverageMark(String subjectName) throws FacultyHasNoGroupsException, StudentHasNoSubjectsException, MarkIsOutOfBoundException, UniversityHasNoFacultiesException {
        if (mapOfFaculties.isEmpty()) {
            throw new UniversityHasNoFacultiesException(this.universityName+" university has no faculties!");
        }
        Map<Integer, Group> mapOfAllGroups = new HashMap<>();
        for (Faculty faculty : mapOfFaculties.values()) {
            mapOfAllGroups.putAll(faculty.getMapOfFacultyGroups());
        }
        int sumOfGroupAverageMark = 0;
        int quantityOfGroups = 0;
        for (Group group : mapOfAllGroups.values()) {
            sumOfGroupAverageMark += group.getGroupAverageMark(subjectName);
            quantityOfGroups++;
        }
        return sumOfGroupAverageMark / quantityOfGroups;
    }

    public int getAverageMarkOfGroup(String facultyName, int groupNumber, String subject) throws FacultyHasNoGroupsException, StudentHasNoSubjectsException, MarkIsOutOfBoundException {
        Group group = mapOfFaculties.get(facultyName).getMapOfFacultyGroups().get(groupNumber);
        return group.getGroupAverageMark(subject);
    }

    public float getStudentAverageMark(String studentSurname) throws FacultyHasNoGroupsException, GroupHasNoStudentsException, MarkIsOutOfBoundException {

        Map<Integer, Group> mapOfAllUniversityGroups = new HashMap<>();
        for (Faculty faculty : mapOfFaculties.values()) {
            mapOfAllUniversityGroups.putAll(faculty.getMapOfFacultyGroups());
        }
        HashMap<String, Student> mapOfAllUniversityStudents = new HashMap<>();
        for (Group group : mapOfAllUniversityGroups.values()) {
            mapOfAllUniversityStudents.putAll(group.getStudentsOfGroup());
        }
        Student selectedStudent;
        int averageMark = 0;

        if (mapOfAllUniversityStudents.containsKey(studentSurname)) {
            selectedStudent = mapOfAllUniversityStudents.get(studentSurname);
            averageMark = selectedStudent.getStudentsAverageMark();
        }
        return averageMark;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityName='" + universityName + '\'' +
                ", university=" + mapOfFaculties +
                '}';
    }
}
