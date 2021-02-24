package Univercity;

import java.util.ArrayList;
import java.util.Objects;

public class Univercity {
    private ArrayList<Faculty> listOfFaculties = new ArrayList<Faculty>();

    public ArrayList<Faculty> getListOfFaculties() {
        return listOfFaculties;
    }

    public void addFaculty(Faculty faculty){
        listOfFaculties.add(faculty);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Univercity that = (Univercity) o;
        return Objects.equals(listOfFaculties, that.listOfFaculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfFaculties);
    }

    @Override
    public String toString() {
        return "Univercity{" +
                "listOfFaculties=" + listOfFaculties +
                '}';
    }
}
