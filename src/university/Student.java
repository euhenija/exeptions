package university;

import exceptions.Inspector;
import exceptions.MarkIsOutOfBoundException;
import exceptions.StudentHasNoSubjectsException;
import java.util.HashMap;


public class Student {
    private String studentName;
    private String studentSurname;
    private HashMap<String, Integer> listOfSubjects = new HashMap();
    private int studentAverageMark;

    public HashMap<String, Integer> getListOfSubjects() throws StudentHasNoSubjectsException {
        if (listOfSubjects.isEmpty()){
            throw new StudentHasNoSubjectsException();
        }
        return listOfSubjects;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public static class StudentBuilder {
        private Student newStudent;

        public StudentBuilder() {
            newStudent = new Student();
        }

        public StudentBuilder withStudentName(String studentName) {
            newStudent.studentName = studentName;
            return this;
        }

        public StudentBuilder withStudentSurname(String studentSurname) {
            newStudent.studentSurname = studentSurname;
            return this;
        }

        public StudentBuilder withSubjectAndItsMark(String subjectName, int mark) {
            newStudent.listOfSubjects.put(subjectName, mark);
            return this;
        }

        public Student build() {
            return newStudent;
        }
    }

    public int getStudentsAverageMark() throws MarkIsOutOfBoundException {
        int totalSumOfMarks = 0;
        int quantityOfStudentsSubjects = 0;
        Inspector markInspector = new Inspector();
        for (Integer mark : listOfSubjects.values()) {
            markInspector.checkTheMark(mark);
            totalSumOfMarks += mark;
            quantityOfStudentsSubjects++;
        }
        studentAverageMark = totalSumOfMarks / quantityOfStudentsSubjects;
        return studentAverageMark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", listOfSubjects=" + listOfSubjects +
                '}';
    }
}
