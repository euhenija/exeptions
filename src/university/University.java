package university;

import exceptions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToLongFunction;

public class University {

    private String universityName;
    private Map<String, Faculty> mapOfFaculties;

    public University(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Map<String, Faculty> getMapOfFaculties() {
        return mapOfFaculties;
    }

    public void setFacultiesToUniversity(Map<String, Faculty> university) {
        this.mapOfFaculties = university;
    }

    public double getUniversityAverageMark(String subjectName) throws UniversityHasNoFacultiesException {
        if (mapOfFaculties.isEmpty()) {
            throw new UniversityHasNoFacultiesException(this.universityName + " university has no faculties!");
        }


        ToLongFunction<Group> function = group -> {
            try {
                return group.getGroupAverageMark(subjectName);
            } catch (StudentHasNoSubjectsException | MarkIsOutOfBoundException e) {
                e.printStackTrace();
            }
            return 0;
        };

        long sumOfGroupAverageMark = mapOfFaculties.values().stream().mapToLong(faculty -> {
            try {
                System.out.println("SUM Group" + faculty.getMapOfFacultyGroups().values().stream().mapToLong(function).sum());
                return faculty.getMapOfFacultyGroups().values().stream().mapToLong(function).sum();
            } catch (FacultyHasNoGroupsException e) {
                e.printStackTrace();
            }
            return 0;
        }).sum();
     long quantityOfGroups = mapOfFaculties.values().stream().mapToLong(faculty -> {
            try {
                System.out.println("Number of groups" + faculty.getMapOfFacultyGroups().values().size());
                return faculty.getMapOfFacultyGroups().values().size();
            } catch (FacultyHasNoGroupsException e) {
                e.printStackTrace();
            }
            return 0;
        }).sum();


        return sumOfGroupAverageMark / quantityOfGroups;
    }

    public int getAverageMarkOfGroup(String facultyName, int groupNumber, String subject) throws FacultyHasNoGroupsException, StudentHasNoSubjectsException, MarkIsOutOfBoundException {
        return mapOfFaculties.get(facultyName).getMapOfFacultyGroups().get(groupNumber).getGroupAverageMark(subject);
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
