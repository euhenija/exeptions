import Enums.FacultyName;
import Enums.SubjectName;
import Univercity.*;

public class Main {
    public static void main(String[] args) {
        Univercity univercity = new Univercity();

        Faculty historicalFaculty = new Faculty(FacultyName.HISTORICAL);
        Faculty telecomFaculty = new Faculty(FacultyName.TELECOM);

        univercity.addFaculty(historicalFaculty);
        univercity.addFaculty(telecomFaculty);

        Group historicalFacultyGroupOne = new Group(123);
        Group historicalFacultyGroupTwo = new Group(321);
        Group telecomFacultyGroupOne = new Group(543);
        Group telecomFacultyGroupTwo = new Group(743);

        historicalFaculty.addGroup(historicalFacultyGroupOne);
        historicalFaculty.addGroup(historicalFacultyGroupTwo);
        telecomFaculty.addGroup(telecomFacultyGroupOne);
        telecomFaculty.addGroup(telecomFacultyGroupTwo);

        historicalFacultyGroupOne.addStudentToGroup(new Student.StudentBuilder().withStudentName("Rick").withStudentSurname("Red").withSubjectAndItsMark(new Subject(SubjectName.HISTORY), 5).withSubjectAndItsMark(new Subject(SubjectName.LITERATURE), 9).build());
        historicalFacultyGroupOne.addStudentToGroup(new Student.StudentBuilder().withStudentName("Ann").withStudentSurname("Green").withSubjectAndItsMark(new Subject(SubjectName.HISTORY), 7).withSubjectAndItsMark(new Subject(SubjectName.LITERATURE), 8).build());
        historicalFacultyGroupTwo.addStudentToGroup(new Student.StudentBuilder().withStudentName("Lissa").withStudentSurname("Duck").withSubjectAndItsMark(new Subject(SubjectName.MATHEMATICS), 9).build());
        historicalFacultyGroupTwo.addStudentToGroup(new Student.StudentBuilder().withStudentName("John").withStudentSurname("Rise").withSubjectAndItsMark(new Subject(SubjectName.LITERATURE), 4).withSubjectAndItsMark(new Subject(SubjectName.MATHEMATICS), 8).build());
        telecomFacultyGroupOne.addStudentToGroup(new Student.StudentBuilder().withStudentName("Alia").withStudentSurname("Price").withSubjectAndItsMark(new Subject(SubjectName.PHYSICS), 6).withSubjectAndItsMark(new Subject(SubjectName.MATHEMATICS), 3).build());
        telecomFacultyGroupOne.addStudentToGroup(new Student.StudentBuilder().withStudentName("Cris").withStudentSurname("Burg").withSubjectAndItsMark(new Subject(SubjectName.PHYSICS), 9).withSubjectAndItsMark(new Subject(SubjectName.MATHEMATICS), 8).build());
        telecomFacultyGroupTwo.addStudentToGroup(new Student.StudentBuilder().withStudentName("All").withStudentSurname("Gott").withSubjectAndItsMark(new Subject(SubjectName.PHYSICS), 8).withSubjectAndItsMark(new Subject(SubjectName.ENGINERING), 10).build());
        telecomFacultyGroupTwo.addStudentToGroup(new Student.StudentBuilder().withStudentName("Jennet").withStudentSurname("Olly").withSubjectAndItsMark(new Subject(SubjectName.HISTORY), 4).withSubjectAndItsMark(new Subject(SubjectName.ENGINERING), 9).build());


        AcademicPerformanceManager chiefManager = new AcademicPerformanceManager(univercity);
        System.out.println(chiefManager.getAverageMarkOnSubjectForStudent("Rick", "Red"));


    }

}



