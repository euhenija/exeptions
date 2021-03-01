
import exceptions.Inspector;
import exceptions.MarkIsOutOfBoundException;
import university.*;

import java.util.*;


public class AcademicPerformanceManager {
    private University university;
    private Faculty faculty;
    Collection<Faculty> listOfAllFaculties;
    HashMap<String, Faculty> mapOfAllFaculties;



    public AcademicPerformanceManager(University university) {

        this.university = university;
    }

    public int getAverageMarkOfGroup(String facultyName, int groupNumber, Subject subject){
        try {
            mapOfAllFaculties = university.getUniversity();
            faculty = university.getUniversity().get(facultyName);

        } catch (NullPointerException e) {
            System.out.println("No faculties in University "+university.getUniversityName());
            return 0;
        }
        HashMap<String, Student> listOfStudentsFromGroup = faculty.getMapOfFacultyGroups().get(groupNumber).getStudentsOfGroup();
        Collection<Student> students = listOfStudentsFromGroup.values();
        Inspector markInspector = new Inspector();
        int totalSumOfMarks = 0;
        int quantityOfStudentsWithSubject = 0;
        for (Student student : students) {
            HashMap<Subject, Integer> listOfStudentSubjects = student.getListOfSubjects();
            if (listOfStudentSubjects.containsKey(subject)) {
                int subjectMark = listOfStudentSubjects.get(subject);
                try {
                    markInspector.checkTheMark(subjectMark);
                } catch (MarkIsOutOfBoundException e) {
                    System.out.println(e.toString() + ": Student  " + student.getStudentName() + " " + student.getStudentSurname() + " has unacceptable mark on " + subject.getSubjectName());
                }
                totalSumOfMarks += subjectMark;
                quantityOfStudentsWithSubject++;
            }
        }
        return totalSumOfMarks / quantityOfStudentsWithSubject;
    }

    public float getStudentAverageMark(String studentSurname) {

        try{
            listOfAllFaculties = university.getUniversity().values();
        }
        catch (NullPointerException e){
            System.out.println("No faculties in University "+university.getUniversityName());
            return 0;
        }
        Map<Integer, Group> mapOfAllUniversityGroups = new HashMap<>();
        for (Faculty faculty : listOfAllFaculties) {
            mapOfAllUniversityGroups.putAll(faculty.getMapOfFacultyGroups());
        }
        HashMap<String, Student> mapOfAllUniversityStudents = new HashMap<>();
        for (Group group : mapOfAllUniversityGroups.values()) {
            mapOfAllUniversityStudents.putAll(group.getStudentsOfGroup());
        }
        int totalSumOfMarks = 0;
        int quantityOfStudentsSubjects = 0;
        if (mapOfAllUniversityStudents.containsKey(studentSurname)) {
            Student selectedStudent = mapOfAllUniversityStudents.get(studentSurname);
            Collection<Integer> listOfStudentMarks = selectedStudent.getListOfSubjects().values();
            try {    if (listOfStudentMarks.size()==0){
                    throw new NullPointerException();
                }
            }
            catch (NullPointerException e){
                System.out.println("Student "+selectedStudent.getStudentName()+" "+selectedStudent.getStudentSurname()+" has no subjects!");
            return 0;
            }
            for (Integer mark : listOfStudentMarks) {
                totalSumOfMarks += mark;
                quantityOfStudentsSubjects++;
            }
        }
        return totalSumOfMarks / quantityOfStudentsSubjects;
    }

    public float getUniversityAverageMark(Subject subject) {
        listOfAllFaculties = university.getUniversity().values();
        Map<Integer, Group> mapOfAllFaculties = new HashMap<>();
        for (Faculty faculty : listOfAllFaculties) {
            mapOfAllFaculties.putAll(faculty.getMapOfFacultyGroups());
        }
        Collection<Student> listOfAllStudents = new ArrayList<>();
        for (Group group : mapOfAllFaculties.values()) {
            listOfAllStudents.addAll(group.getStudentsOfGroup().values());
        }
        int totalSum = 0;
        int quantityOfStudentsLearnThisSubject = 0;
        for (Student student : listOfAllStudents) {
            HashMap<Subject, Integer> listOfStudentSubjects = student.getListOfSubjects();
            if (listOfStudentSubjects.containsKey(subject)) {
                totalSum += listOfStudentSubjects.get(subject);
                quantityOfStudentsLearnThisSubject++;
            }
        }
        return totalSum / quantityOfStudentsLearnThisSubject;
    }
}








