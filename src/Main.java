import enums.FacultyName;
import enums.SubjectName;
import university.*;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {


        HashMap<String, Student> students1 = new HashMap<>();
        students1.put("Red", new Student.StudentBuilder().withStudentName("Rick").withStudentSurname("Red").withSubjectAndItsMark(new Subject(SubjectName.HISTORY), 12).withSubjectAndItsMark(new Subject(SubjectName.LITERATURE), 9).build());
        students1.put("Green", new Student.StudentBuilder().withStudentName("Ann").withStudentSurname("Green").withSubjectAndItsMark(new Subject(SubjectName.HISTORY), 7).withSubjectAndItsMark(new Subject(SubjectName.LITERATURE), 8).build());
        students1.put("Gren", new Student.StudentBuilder().withStudentName("An").withStudentSurname("Gren").withSubjectAndItsMark(new Subject(SubjectName.HISTORY), 7).withSubjectAndItsMark(new Subject(SubjectName.LITERATURE), 8).build());
        HashMap<String, Student> students2 = new HashMap<>();
        students2.put("Duck", new Student.StudentBuilder().withStudentName("Lissa").withStudentSurname("Duck").build());
        students2.put("Rise", new Student.StudentBuilder().withStudentName("John").withStudentSurname("Rise").withSubjectAndItsMark(new Subject(SubjectName.LITERATURE), 4).withSubjectAndItsMark(new Subject(SubjectName.MATHEMATICS), 8).build());
        HashMap<String, Student> students3 = new HashMap<>();
        students3.put("Price", new Student.StudentBuilder().withStudentName("Alia").withStudentSurname("Price").withSubjectAndItsMark(new Subject(SubjectName.PHYSICS), 6).withSubjectAndItsMark(new Subject(SubjectName.MATHEMATICS), 3).build());
        students3.put("Burg", new Student.StudentBuilder().withStudentName("Cris").withStudentSurname("Burg").withSubjectAndItsMark(new Subject(SubjectName.PHYSICS), 9).withSubjectAndItsMark(new Subject(SubjectName.MATHEMATICS), 8).build());
        HashMap<String, Student> students4 = new HashMap<>();
        students4.put("Gott", new Student.StudentBuilder().withStudentName("All").withStudentSurname("Gott").withSubjectAndItsMark(new Subject(SubjectName.PHYSICS), 8).withSubjectAndItsMark(new Subject(SubjectName.ENGINERING), 10).build());
        students4.put("Olly", new Student.StudentBuilder().withStudentName("Jennet").withStudentSurname("Olly").withSubjectAndItsMark(new Subject(SubjectName.HISTORY), 4).withSubjectAndItsMark(new Subject(SubjectName.ENGINERING), 9).build());

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

        University universityBSU = new University("BSU");
        University universityBNTU = new University("BNTU");
        universityBSU.setFacultiesToUniversity(listOfFaculties);

        System.out.println(universityBSU.toString());
        AcademicPerformanceManager managerBNTU = new AcademicPerformanceManager(universityBNTU);
        AcademicPerformanceManager managerBSU = new AcademicPerformanceManager(universityBSU);
        System.out.println("Average mark from asked group is: " + managerBSU.getAverageMarkOfGroup("Historical", 124, new Subject(SubjectName.HISTORY)));
        System.out.println("Average mark of student is: " + managerBSU.getStudentAverageMark("Green"));
        System.out.println("Average University mark is: " + managerBSU.getUniversityAverageMark(new Subject(SubjectName.HISTORY)));


        System.out.println("Average mark of student is: "+managerBSU.getStudentAverageMark("Duck"));
        System.out.println("Average mark from asked group is: " + managerBNTU.getAverageMarkOfGroup("Economical", 124, new Subject(SubjectName.LITERATURE)));
    }
}



