package sample;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

  private Connection conn;
  private PreparedStatement preparedStatement;
  private ResultSet result;
  private String animalQuery;
  private int index = 1;


  void initializeDb() {
    try {
      final String jdbcDriver = "org.h2.Driver";
      Class.forName(jdbcDriver);
      final String db_Url = "jdbc:h2:./res/AnimalInformation";
      // Database credentials
      // to create a database username and password,
      // type Create USER [username] WITH PASSWORD "[password]"
      // to allow the user to edit the database use GRANT ALTER ANY SCHEMA TO [username]; in console
      final String user = "";
      final String pass = "";

      // STEP 1: Register JDBC driver
      //STEP 2: Open a connection
      conn = DriverManager.getConnection(db_Url, user, pass);

    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }


  void updateAnimalInDB(String name, Timestamp groomDate,
      Timestamp vetDate, String collarID) {

    try {
      //Execute a query
      animalQuery =
          "UPDATE ANIMALS SET ANIMALNAME = ?, LASTGROOMED = ?, LASTCHECKUP = ? where COLLARID = ?";
      preparedStatement = conn.prepareStatement(animalQuery);
      preparedStatement.setString(1, name);
      preparedStatement.setTimestamp(2, groomDate);
      preparedStatement.setTimestamp(3, vetDate);
      preparedStatement.setString(4, collarID);

      preparedStatement.executeUpdate();
    } catch (SQLException ex) {

      ex.printStackTrace();
    }
  }

  public void scheduleVisit(String lastVetVisit, String lastGroomerVisit, Timestamp nextVetVisit,
      Timestamp nextGroomerVisit, int collarID) {
    String[] lastDates = new String[]{lastVetVisit, lastGroomerVisit};

    Timestamp[] newAppointments = new Timestamp[]{nextVetVisit, nextGroomerVisit};

    try {
      //Execute a query
      animalQuery = "UPDATE ANIMALS SET VETNOTES = ?, GROOMERNOTES = ?, NEXTVETVISIT = ?, NEXTGROOMERVISIT = ? WHERE COllARID = ?";
      preparedStatement = conn.prepareStatement(animalQuery);
      for (String s : lastDates) {
        preparedStatement.setString(index, s);
        index++;
      }

      for (Timestamp ts : newAppointments) {
        preparedStatement.setTimestamp(index, ts);
        index++;
      }
      preparedStatement.setInt(index, collarID);
      preparedStatement.executeUpdate();

    } catch (SQLException ex) {

      ex.printStackTrace();
    }
  }

  public void resetID() {
    try {
      animalQuery = "ALTER TABLE ANIMALS DROP COLUMN COLLARID;"
          + "ALTER TABLE ANIMALS ADD COLLARID INT NOT NULL AUTO_INCREMENT primary key BEFORE ANIMALNAME";
      preparedStatement = conn.prepareStatement(animalQuery);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteAnimal(int id) {
    try {
      animalQuery = "delete from ANIMALS where ANIMALS.COLLARID = ?";
      preparedStatement = conn.prepareStatement((animalQuery));
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Animal> getAvailableAnimals() {
    List<Animal> animalsInDB = new ArrayList<>();
    try {
      animalQuery = "SELECT * FROM ANIMALS";
      preparedStatement = conn.prepareStatement(animalQuery);
      result = preparedStatement.executeQuery();
      while (result.next()) {
        String name = result.getString("ANIMALNAME");
        int ID = result.getInt("COLLARID");
        Timestamp groomDate = result.getTimestamp("LASTGROOMED");
        String breed = result.getString("BREED");
        Timestamp checkInDate = result.getTimestamp("CHECKEDIN");
        Timestamp vetCheckDate = result.getTimestamp("LASTCHECKUP");
        Timestamp nextGroomerVisit = result.getTimestamp("NEXTGROOMERVISIT");
        String subspecies = result.getString("SPECIES");
        Timestamp nextVetVisit = result.getTimestamp("NEXTVETVISIT");
        String vetNotes = result.getString("VetNotes");
        String groomerNotes = result.getString("Groomernotes");
        animalsInDB.add(
            new Animal(ID, name, subspecies, breed, checkInDate, groomDate, vetCheckDate, vetNotes,
                groomerNotes, nextVetVisit, nextGroomerVisit));
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return animalsInDB;
  }

  public List<Animal> getAnimalSearch(String animalName) {
    List<Animal> animalsInDB = new ArrayList<>();
    try {
      animalQuery = "SELECT * FROM ANIMALS WHERE ANIMALNAME LIKE ? OR SPECIES LIKE ? OR BREED LIKE ?";
      preparedStatement = conn.prepareStatement(animalQuery);
      preparedStatement.setString(1, animalName);
      preparedStatement.setString(2, animalName);
      preparedStatement.setString(3, animalName);
      result = preparedStatement.executeQuery();
      while (result.next()) {
        int ID = result.getInt("COLLARID");
        String name = result.getString("ANIMALNAME");
        String subspecies = result.getString("SPECIES");
        String breed = result.getString("BREED");
        Timestamp checkInDate = result.getTimestamp("CHECKEDIN");
        Timestamp groomDate = result.getTimestamp("LASTGROOMED");
        Timestamp vetCheckDate = result.getTimestamp("LASTCHECKUP");
        Timestamp nextVetVisit = result.getTimestamp("NEXTVETVISIT");
        Timestamp nextGroomerVisit = result.getTimestamp("NEXTGROOMERVISIT");
        String vetNotes = result.getString("VetNotes");
        String groomerNotes = result.getString("Groomernotes");
        animalsInDB.add(
            new Animal(ID, name, subspecies, breed, checkInDate, groomDate, vetCheckDate, vetNotes,
                groomerNotes, nextVetVisit, nextGroomerVisit));
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return animalsInDB;
  }

  public void addAnimal(String[] animalInfo) {
    try {
      animalQuery = "INSERT INTO ANIMALS(ANIMALNAME,SPECIES,BREED) VALUES(?,?,?)";
      preparedStatement = conn.prepareStatement(animalQuery);
      preparedStatement.setString(1, animalInfo[0]);
      preparedStatement.setString(2, animalInfo[1]);
      preparedStatement.setString(3, animalInfo[2]);
      preparedStatement.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

}