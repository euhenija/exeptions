import Enums.FacultyName;
import Enums.SubjectName;
import univercity.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


//        Group historicalFacultyGroupOne = new Group(123, students1);
//        Group historicalFacultyGroupTwo = new Group(321, students1);
//        Group telecomFacultyGroupOne = new Group(543, students1);
//        Group telecomFacultyGroupTwo = new Group(743, students1);

//        historicalFaculty.addGroup(historicalFacultyGroupOne);
//        historicalFaculty.addGroup(historicalFacultyGroupTwo);
//        telecomFaculty.addGroup(telecomFacultyGroupOne);
//        telecomFaculty.addGroup(telecomFacultyGroupTwo);
//
//        historicalFacultyGroupOne.addStudentToGroup(new Student.StudentBuilder().withStudentName("Rick").withStudentSurname("Red").withSubjectAndItsMark(new Subject(SubjectName.HISTORY), 5).withSubjectAndItsMark(new Subject(SubjectName.LITERATURE), 9).build());
//        historicalFacultyGroupOne.addStudentToGroup(new Student.StudentBuilder().withStudentName("Ann").withStudentSurname("Green").withSubjectAndItsMark(new Subject(SubjectName.HISTORY), 7).withSubjectAndItsMark(new Subject(SubjectName.LITERATURE), 8).build());
//        historicalFacultyGroupTwo.addStudentToGroup(new Student.StudentBuilder().withStudentName("Lissa").withStudentSurname("Duck").withSubjectAndItsMark(new Subject(SubjectName.MATHEMATICS), 9).build());
//        historicalFacultyGroupTwo.addStudentToGroup(new Student.StudentBuilder().withStudentName("John").withStudentSurname("Rise").withSubjectAndItsMark(new Subject(SubjectName.LITERATURE), 4).withSubjectAndItsMark(new Subject(SubjectName.MATHEMATICS), 8).build());
//        telecomFacultyGroupOne.addStudentToGroup(new Student.StudentBuilder().withStudentName("Alia").withStudentSurname("Price").withSubjectAndItsMark(new Subject(SubjectName.PHYSICS), 6).withSubjectAndItsMark(new Subject(SubjectName.MATHEMATICS), 3).build());
//        telecomFacultyGroupOne.addStudentToGroup(new Student.StudentBuilder().withStudentName("Cris").withStudentSurname("Burg").withSubjectAndItsMark(new Subject(SubjectName.PHYSICS), 9).withSubjectAndItsMark(new Subject(SubjectName.MATHEMATICS), 8).build());
//        telecomFacultyGroupTwo.addStudentToGroup(new Student.StudentBuilder().withStudentName("All").withStudentSurname("Gott").withSubjectAndItsMark(new Subject(SubjectName.PHYSICS), 8).withSubjectAndItsMark(new Subject(SubjectName.ENGINERING), 10).build());
//        telecomFacultyGroupTwo.addStudentToGroup(new Student.StudentBuilder().withStudentName("Jennet").withStudentSurname("Olly").withSubjectAndItsMark(new Subject(SubjectName.HISTORY), 4).withSubjectAndItsMark(new Subject(SubjectName.ENGINERING), 9).build());
//

//        AcademicPerformanceManager chiefManager = new AcademicPerformanceManager(univercity);
//        System.out.println(chiefManager.getAverageMarkOnSubjectForStudent("Rick", "Red"));


        HashMap<String, Student> students1 = new HashMap<>();
        students1.put("Red", new Student.StudentBuilder().withStudentName("Rick").withStudentSurname("Red").withSubjectAndItsMark(new Subject(SubjectName.HISTORY), 5).withSubjectAndItsMark(new Subject(SubjectName.LITERATURE), 9).build());
        students1.put("Green", new Student.StudentBuilder().withStudentName("Ann").withStudentSurname("Green").withSubjectAndItsMark(new Subject(SubjectName.HISTORY), 7).withSubjectAndItsMark(new Subject(SubjectName.LITERATURE), 8).build());
        students1.put("Gree", new Student.StudentBuilder().withStudentName("An").withStudentSurname("Gren").withSubjectAndItsMark(new Subject(SubjectName.HISTORY), 7).withSubjectAndItsMark(new Subject(SubjectName.LITERATURE), 8).build());
        HashMap<String, Student> students2 = new HashMap<>();
        students2.put("Duck", new Student.StudentBuilder().withStudentName("Lissa").withStudentSurname("Duck").withSubjectAndItsMark(new Subject(SubjectName.MATHEMATICS), 9).build());
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

        group124.addStudentToGroup(124, students1);
        group125.addStudentToGroup(125, students2);
        group224.addStudentToGroup(224, students3);
        group225.addStudentToGroup(225, students4);


        Faculty historicalFaculty = new Faculty(FacultyName.HISTORICAL);
        Faculty telecomFaculty = new Faculty(FacultyName.TELECOM);

        historicalFaculty.addGroupToFaculty(124, group124);
        historicalFaculty.addGroupToFaculty(125, group125);
        telecomFaculty.addGroupToFaculty(224, group224);
        telecomFaculty.addGroupToFaculty(225, group225);
        HashMap<String, Faculty> listOfFaculties = new HashMap<>();
        listOfFaculties.put("Historical", historicalFaculty);
        listOfFaculties.put("Telecom", telecomFaculty);
        Univercity univercity = new Univercity("BSU");

        univercity.addUnivercity("BSU", listOfFaculties);
        System.out.println(univercity.toString());
        Map<String, HashMap<String, Faculty>> faculties = univercity.getUnivercity();
        System.out.println(faculties.toString());
       Collection<HashMap<String, Faculty>> listOfFacultie = faculties.values();
        System.out.println(listOfFacultie.toString());


    }


}



