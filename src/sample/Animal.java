package sample;

import java.util.Date;

public class Animal {

  private String name;
  private int collarID;
  private String subSpecies;
  private String breed;
  private Date checkedIn;
  private Date adoptionDate;
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

  public String getSubSpecies() {
    return subSpecies;
  }

  public void setSubSpecies(String species) {
    this.subSpecies = species;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public Date getCheckedIn() {
    return checkedIn;
  }

  public void setCheckedIn(Date checkedIn) {
    this.checkedIn = checkedIn;
  }

  public Date getAdoptionDate() {
    return adoptionDate;
  }

  public void setAdoptionDate(Date adoptionDate) {
    this.adoptionDate = adoptionDate;
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
