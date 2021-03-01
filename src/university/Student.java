package university;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Student {
    private String studentName;
    private String studentSurname;
    private HashMap<Subject, Integer> listOfSubjects = new HashMap();


    public HashMap<Subject, Integer> getListOfSubjects() {
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

        public StudentBuilder withSubjectAndItsMark(Subject subject, int mark) {
            newStudent.listOfSubjects.put(subject, mark);
            return this;
        }

        public Student build() {
            return newStudent;
        }
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
