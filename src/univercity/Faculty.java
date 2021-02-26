package univercity;

import Enums.FacultyName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Faculty {
    private FacultyName facultyName;
    private ArrayList<Group> facultyGroupList = new ArrayList<Group>();
    private Map<Integer, Group> mapOfGroups = new HashMap<Integer, Group>();


    public void addGroupToFaculty(Integer groupNumber, Group mapOfFacultyGroups){
        mapOfGroups.put(groupNumber, mapOfFacultyGroups);
    }


    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

//    public Faculty(FacultyName facultyName, Map<String, Group> mapOfGroups) {
//        this.facultyName = facultyName;
//        this.mapOfGroups = mapOfGroups;
//    }
//
//    public Faculty(Map<String, Group> mapOfGroups) {
//        this.mapOfGroups = mapOfGroups;
//    }

    public FacultyName getFacultyName() {
        return facultyName;
    }

    public ArrayList<Group> getFacultyGroupList() {
        return facultyGroupList;
    }

    public  void addGroup (Group group){
        this.facultyGroupList.add(group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return facultyName == faculty.facultyName && Objects.equals(facultyGroupList, faculty.facultyGroupList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyName, facultyGroupList);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName=" + facultyName +
                ", facultyGroupList=" + mapOfGroups +
                '}';
    }
}
