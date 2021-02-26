package univercity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Student {
    private String studentName;
    private String studentSurname;
    private Subject subjectWithMark;
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

    public Subject getSubjectWithMark() {
        return subjectWithMark;
    }


    public static class StudentBuilder{
        private Student newStudent;
        private ArrayList<Subject> subjectss = new ArrayList<>();

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

        public StudentBuilder withLearnedSubject (Subject subjectWithMark){
            newStudent.subjectWithMark = subjectWithMark;
            return this;
        }

        public StudentBuilder withSubjectAndItsMark(Subject subject, int mark){
            newStudent.listOfSubjects.put(subject, mark);
            return this;
        }
        public Student build () {
            return newStudent;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentName, student.studentName) && Objects.equals(studentSurname, student.studentSurname) && Objects.equals(subjectWithMark, student.subjectWithMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, studentSurname, subjectWithMark);
    }

    @Override
    public String toString() {
        return "Univercity.Student{" +
                "studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                " "+listOfSubjects+
                '}';
    }
}
