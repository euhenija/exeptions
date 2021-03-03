import enums.FacultyName;
import exceptions.*;
import university.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws FacultyHasNoGroupsException, GroupHasNoStudentsException, UniversityHasNoFacultiesException, MarkIsOutOfBoundException, StudentHasNoSubjectsException {

        HashMap<String, Student> students1 = new HashMap<>();
        students1.put("Red", new Student.StudentBuilder().withStudentName("Rick").withStudentSurname("Red").withSubjectAndItsMark("HISTORY", 5).withSubjectAndItsMark("LITERATURE", 9).build());
        students1.put("Green", new Student.StudentBuilder().withStudentName("Ann").withStudentSurname("Green").withSubjectAndItsMark("HISTORY", 2).withSubjectAndItsMark("LITERATURE", 8).build());
        students1.put("Gren", new Student.StudentBuilder().withStudentName("An").withStudentSurname("Gren").withSubjectAndItsMark("HISTORY", 7).withSubjectAndItsMark("LITERATURE", 8).build());
        HashMap<String, Student> students2 = new HashMap<>();
        students2.put("Duck", new Student.StudentBuilder().withStudentName("Lissa").withStudentSurname("Duck").build());
        students2.put("Rise", new Student.StudentBuilder().withStudentName("John").withStudentSurname("Rise").withSubjectAndItsMark("LITERATURE", 4).withSubjectAndItsMark("HISTORY", 10).build());
        HashMap<String, Student> students3 = new HashMap<>();
        students3.put("Price", new Student.StudentBuilder().withStudentName("Alia").withStudentSurname("Price").withSubjectAndItsMark("PHYSICS", 6).withSubjectAndItsMark("HISTORY", 3).build());
        students3.put("Burg", new Student.StudentBuilder().withStudentName("Cris").withStudentSurname("Burg").withSubjectAndItsMark("PHYSICS", 9).withSubjectAndItsMark("MATHEMATICS", 8).build());
        HashMap<String, Student> students4 = new HashMap<>();
        students4.put("Gott", new Student.StudentBuilder().withStudentName("All").withStudentSurname("Gott").withSubjectAndItsMark("PHYSICS", 8).withSubjectAndItsMark("ENGINERING", 10).build());
        students4.put("Olly", new Student.StudentBuilder().withStudentName("Jennet").withStudentSurname("Olly").withSubjectAndItsMark("HISTORY", 4).withSubjectAndItsMark("ENGINERING", 9).build());

        Group group124 = new Group(124);
        Group group125 = new Group(125);
        Group group224 = new Group(224);
        Group group225 = new Group(225);
        Group group226 = new Group(226);

        group124.addStudentsToGroup(students1);
        group125.addStudentsToGroup(students2);
        group224.addStudentsToGroup(students3);
        group225.addStudentsToGroup(students4);

        Faculty historicalFaculty = new Faculty(FacultyName.HISTORICAL);
        Faculty telecomFaculty = new Faculty(FacultyName.TELECOM);
        Faculty economicalFaculty = new Faculty(FacultyName.ECONOMICAL);

        historicalFaculty.addGroupToFaculty(124, group124);
        historicalFaculty.addGroupToFaculty(125, group125);
        telecomFaculty.addGroupToFaculty(224, group224);
        telecomFaculty.addGroupToFaculty(225, group225);
        telecomFaculty.addGroupToFaculty(226, group226);

        HashMap<String, Faculty> listOfFaculties = new HashMap<>();
        listOfFaculties.put("Historical", historicalFaculty);
        listOfFaculties.put("Telecom", telecomFaculty);
        listOfFaculties.put("Economical", economicalFaculty);

        HashMap<String, Faculty> listOfFacultiess = new HashMap<>();
        University universityBSU = new University("BSU");
        University universityBNTU = new University("BNTU");

        universityBSU.setFacultiesToUniversity(listOfFaculties);
        universityBNTU.setFacultiesToUniversity(listOfFacultiess);

        System.out.println("Count from class UNIVERSITY " + universityBSU.getUniversityAverageMark("HISTORY"));
        System.out.println("Average mark from asked group is Count from class UNIVERSITY: " + universityBSU.getAverageMarkOfGroup("Historical", 124, "HISTORY"));
        System.out.println("Average mark from asked group is: " + universityBSU.getAverageMarkOfGroup("Historical", 125, "HISTORY"));
        System.out.println("Average mark of student is: " + universityBSU.getStudentAverageMark("Red"));
        System.out.println("Average University mark is: " + universityBSU.getUniversityAverageMark("HISTORY"));
        System.out.println("Average mark of student is: " + universityBSU.getStudentAverageMark("Duck"));

    }

}



