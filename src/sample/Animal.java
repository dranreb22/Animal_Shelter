package sample;

import java.util.Date;

public class Animal {

  private String name;
  private String species;
  private String breed;
  private int collarID;
  private Date checkedIn;
  private Date lastCheckUp;
  private Date lastGroomed;

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

  public void setCheckedIn(Date checkedIn) {
    this.checkedIn = checkedIn;
  }


  public Date getLastCheckUp() {
    return lastCheckUp;
  }

  public void setLastCheckUp(Date lastCheckUp) {
    this.lastCheckUp = lastCheckUp;
  }

  public Date getLastGroomed() {
    return lastGroomed;
  }

  public void setLastGroomed(Date lastGroomed) {
    this.lastGroomed = lastGroomed;
  }
}
