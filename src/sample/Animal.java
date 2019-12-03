package sample;

import java.util.Date;

public abstract class Animal {

  private String name;
  private String species;
  private double weight;
  private int estimatedAge;
  private Date checkedIn;
  private Date checkedOut;
  private boolean isAvailable;
  private boolean isFixed;
  private Date lastCheckUp;
  private Date lastGroomed;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public int getEstimatedAge() {
    return estimatedAge;
  }

  public void setEstimatedAge(int estimatedAge) {
    this.estimatedAge = estimatedAge;
  }

  public Date getCheckedIn() {
    return checkedIn;
  }

  public void setCheckedIn(Date checkedIn) {
    this.checkedIn = checkedIn;
  }

  public Date getCheckedOut() {
    return checkedOut;
  }

  public void setCheckedOut(Date checkedOut) {
    this.checkedOut = checkedOut;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  public boolean isFixed() {
    return isFixed;
  }

  public void setFixed(boolean fixed) {
    isFixed = fixed;
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
