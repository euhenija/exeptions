package university;

import java.util.HashMap;

public class Group {

    private int groupNumber;
    private HashMap<String, Student> studentsOfGroup = new HashMap();

    public int getGroupNumber() {
        return groupNumber;
    }

    public HashMap<String, Student> getStudentsOfGroup() {
        return studentsOfGroup;
    }

    public void addStudentsToGroup(HashMap<String, Student> studentsOfGroup) {
        this.studentsOfGroup = studentsOfGroup;
    }

    public Group(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void addStudent(String surname, Student student) {
        studentsOfGroup.put(surname, student);
    }
}
