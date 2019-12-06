package sample;

import java.util.Date;
import java.sql.Timestamp;

public class Animal {

    private String name;
    private String species;
    private String breed;
    private int collarID;
    private Timestamp checkedIn;
    private Timestamp lastCheckUp;
    private Timestamp lastGroomed;

    Animal(int collarID, String name, String species, String breed, Timestamp checkedIn,
           Timestamp lastCheckUp, Timestamp lastGroomed) {
        this.collarID = collarID;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.checkedIn = checkedIn;
        this.lastCheckUp = lastCheckUp;
        this.lastGroomed = lastGroomed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCollarID() {
        return collarID;
    }

    public void setCollarID(int collarID) {
        this.collarID = collarID;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Date getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Timestamp checkedIn) {
        this.checkedIn = checkedIn;
    }


    public Date getLastCheckUp() {
        return lastCheckUp;
    }

    public void setLastCheckUp(Timestamp lastCheckUp) {
        this.lastCheckUp = lastCheckUp;
    }

    public Date getLastGroomed() {
        return lastGroomed;
    }

    public void setLastGroomed(Timestamp lastGroomed) {
        this.lastGroomed = lastGroomed;
    }

    @Override
    public String toString() {
        return name + " " + species + " " + breed;
    }
}
