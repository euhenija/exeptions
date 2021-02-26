package univercity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Group {

   // private ArrayList<Student> studentsfromGroup = new ArrayList<>();
   private int groupNumber;
   private HashMap<Integer, HashMap<String, Student>> mapOfStudent = new HashMap<>();
    private HashMap<Integer, HashMap<String, Student>> mapOfStudents = new HashMap<>();
    private HashMap<String, Student> studentsOfGroup = new HashMap();


    public Group(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public HashMap<Integer, HashMap<String, Student>> getMapOfStudent() {
        return mapOfStudent;
    }

    public void setMapOfStudent(HashMap<Integer, HashMap<String, Student>> mapOfStudent) {
        this.mapOfStudent = mapOfStudent;
    }

    public void addStudentToGroup(Integer number, HashMap<String, Student> students){
       mapOfStudent.put(number, students);
   }

   public void addStudent(String surname, Student student){
       studentsOfGroup.put(surname, student);

   }

//
//    public Group(Map<Integer, HashMap<String, Student>> mapOfStudents) {
//        this.mapOfStudents = (HashMap<Integer, HashMap<String, Student>>) mapOfStudents;
//    }
//
//    public Group(int groupNumber, Map<Integer, HashMap<String, Student>> mapOfStudents) {
//        this.groupNumber = groupNumber;
//        this.mapOfStudents = (HashMap<Integer, HashMap<String, Student>>) mapOfStudents;
//    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Map<Integer, HashMap<String, Student>> getMapOfStudents() {
        return mapOfStudents;
    }

    public void setMapOfStudents(Map<Integer, HashMap<String, Student>> mapOfStudents) {
        this.mapOfStudents = (HashMap<Integer, HashMap<String, Student>>) mapOfStudents;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupNumber == group.groupNumber && Objects.equals(mapOfStudents, group.mapOfStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupNumber, mapOfStudents);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber=" + groupNumber +
                ", mapOfStudents=" + mapOfStudent +
                '}';

}}
