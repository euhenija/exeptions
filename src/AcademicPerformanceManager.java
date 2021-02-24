
import Univercity.*;
import java.util.ArrayList;
import java.util.HashMap;


public class AcademicPerformanceManager {
    private Univercity univercity;

    public AcademicPerformanceManager(Univercity univercity) {
        this.univercity = univercity;
    }


    public double getAverageMarkOnSubjectForStudent(String studentName, String studentSurname) {
        int totalSumOfMarks = 0;
        int quantityOfStudentsSubjects = 0;
        ArrayList<Faculty> faculties = univercity.getListOfFaculties();
        for (Faculty faculty : faculties) {
            ArrayList<Group> groups = faculty.getFacultyGroupList();
            for (Group group : groups) {
                ArrayList<Student> students = group.getStudentsfromGroup();
                for (Student student : students) {
                    if (student.getStudentName().equals(studentName) && student.getStudentSurname().equals(studentSurname)) {
                        HashMap<Subject, Integer> listOfStudentSubjects = student.getListOfSubjects();
                        for (int mark : listOfStudentSubjects.values()) {
                            totalSumOfMarks += mark;
                            quantityOfStudentsSubjects++;
                        }

                    }

                }
            }
        }
        double averageMark=totalSumOfMarks/quantityOfStudentsSubjects;
        return averageMark;
    }

}
