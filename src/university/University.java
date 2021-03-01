package university;

import java.util.HashMap;

public class University {
    private String universityName;
    private  HashMap<String, Faculty> university;


    public University(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setuniversityName(String universityName) {
        this.universityName = universityName;
    }

    public HashMap<String, Faculty> getUniversity() {
        return university;
    }

    public void setFacultiesToUniversity(HashMap<String, Faculty> university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityName='" + universityName + '\'' +
                ", university=" + university +
                '}';
    }
}
