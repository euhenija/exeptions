package Univercity;

import Enums.SubjectName;

import java.util.Objects;

public class Subject {
    SubjectName subjectName;


    public Subject(SubjectName subjectName) {
        this.subjectName = subjectName;
    }


    public SubjectName getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(SubjectName subjectName) {
        this.subjectName = subjectName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return  subjectName == subject.subjectName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectName);
    }

    @Override
    public String toString() {
        return
                "subjectName=" + subjectName;
    }
}
