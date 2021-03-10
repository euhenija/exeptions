package university;

import exceptions.GroupHasNoStudentsException;
import helpers.Inspector;
import exceptions.MarkIsOutOfBoundException;
import exceptions.StudentHasNoSubjectsException;
import java.util.HashMap;

public class Group {

    private int groupNumber;
    private HashMap<String, Student> studentsOfGroup = new HashMap();

    public int getGroupNumber() {
        return groupNumber;
    }

    public HashMap<String, Student> getStudentsOfGroup() throws GroupHasNoStudentsException {
        if (studentsOfGroup.isEmpty()) {
            throw new GroupHasNoStudentsException("Group " + this.groupNumber + " has no students!");
        }
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

    public int getGroupAverageMark(String subjectName) throws StudentHasNoSubjectsException, MarkIsOutOfBoundException {
        int totalSumOfMarks = 0;
        int quantityOfStudentsWithSubjectInGroup = 0;
        Inspector markInspector = new Inspector();
        for (Student student : studentsOfGroup.values()) {
            HashMap<String, Integer> list = student.getListOfSubjects();
            if (student.getListOfSubjects().containsKey(subjectName)) {
                markInspector.checkTheMark(list.get(subjectName));
                totalSumOfMarks += list.get(subjectName);
                quantityOfStudentsWithSubjectInGroup++;
            }
        }
        if (quantityOfStudentsWithSubjectInGroup == 0) {
            return 0;
        } else {
            return totalSumOfMarks / quantityOfStudentsWithSubjectInGroup;
        }
    }
}
