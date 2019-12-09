package sample;

import java.util.Date;
import java.sql.Timestamp;

public class Animal {

  private String name;
  private String species;
  private String breed;
  private String vetNotes;
  private String groomerNotes;
  private Timestamp nextVetVisit;
  private Timestamp nextGroomerVisit;
  private int collarID;
  private Timestamp checkedIn;
  private Timestamp lastCheckUp;
  private Timestamp lastGroomed;

  Animal(int collarID, String name, String species, String breed, Timestamp checkedIn,
      Timestamp lastCheckUp, Timestamp lastGroomed, String vetNotes, String groomerNotes, Timestamp nextVetVisit, Timestamp nextGroomerVisit ) {
    this.collarID = collarID;
    this.name = name;
    this.species = species;
    this.breed = breed;
    this.checkedIn = checkedIn;
    this.lastCheckUp = lastCheckUp;
    this.lastGroomed = lastGroomed;
    this.vetNotes = vetNotes;
    this.groomerNotes = groomerNotes;
    this.nextGroomerVisit = nextGroomerVisit;
    this.nextVetVisit = nextVetVisit;
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

  public void setNextVetVisit(Timestamp nextVetVisit) {
    this.nextVetVisit = nextVetVisit;
  }

  public Timestamp getNextVetVisit() {
    return nextVetVisit;
  }

  public void setNextGroomerVisit(Timestamp nextGroomerVisit) {
    this.nextGroomerVisit = nextGroomerVisit;
  }

  public Timestamp getNextGroomerVisit() {
    return nextGroomerVisit;
  }

  public void setVetNotes(String vetNotes){ this.vetNotes = vetNotes;}
  public String getVetNotes(){return vetNotes;}

  public void setGroomerNotes(String groomerNotes){this.groomerNotes = groomerNotes;}
  public String getGroomerNotes(){return groomerNotes;}

  @Override
  public String toString() {
    return name + " " + species + " " + breed;
  }
}
