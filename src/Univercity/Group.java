package Univercity;

import java.util.ArrayList;
import java.util.Objects;

public class Group {
    private int groupNumber;
    private ArrayList<Student> studentsfromGroup = new ArrayList<>();

    public Group(int groupNumber) {
        this.groupNumber = groupNumber;
    }
    public void addStudentToGroup(Student student){
        this.studentsfromGroup.add(student);
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public ArrayList<Student> getStudentsfromGroup() {
        return studentsfromGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupNumber == group.groupNumber && Objects.equals(studentsfromGroup, group.studentsfromGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupNumber, studentsfromGroup);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber=" + groupNumber +
                ", studentsfromGroup=" + studentsfromGroup +
                '}';
    }
}
