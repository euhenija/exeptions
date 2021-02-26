package univercity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Univercity {
    private String univercityName;
    private Map<String, HashMap<String, Faculty>> univercity = new HashMap<>();
    private Map<String, Faculty> listOfFaculties = new HashMap<>();

    public Univercity(String univercityName) {
        this.univercityName = univercityName;
    }

    public String getUnivercityName() {
        return univercityName;
    }

    public void setUnivercityName(String univercityName) {
        this.univercityName = univercityName;
    }

    public Map<String, HashMap<String, Faculty>> getUnivercity() {
        return univercity;
    }

    public void addUnivercity(String univercityName, HashMap<String, Faculty> listOfFaculties){
        univercity.put(univercityName, listOfFaculties);
    }

    public Map<String, Faculty> getListOfFaculties() {
        return listOfFaculties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Univercity that = (Univercity) o;
        return Objects.equals(univercityName, that.univercityName) && Objects.equals(univercity, that.univercity) && Objects.equals(listOfFaculties, that.listOfFaculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(univercityName, univercity, listOfFaculties);
    }

    @Override
    public String toString() {
        return "Univercity" + univercity +
                '}';
    }

}
