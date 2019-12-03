package sample;

import java.sql.Date;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

  private Connection conn;
  private PreparedStatement preparedStatement;
  private ResultSet result;
  private String animalQuery;
  private String delQuery;
  private int index = 1;
  private String[] animalInformationStr;
  private Date[] animalInformationDate;



  public void initializeDb() {
    try {
      final String jdbcDriver = "org.h2.Driver";
      Class.forName(jdbcDriver);
      final String db_Url = "jdbc:h2:./res/AnimalInformation";
      //  Database credentials
      // to create a database username and password,
      // type Create USER [username] WITH PASSWORD "[password]"
      // to allow the user to edit the database use GRANT ALTER ANY SCHEMA TO [username]; in console
      final String user = "";
      final String pass = "";

      // STEP 1: Register JDBC driver

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(db_Url, user, pass);

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    //return conn;
  }

  public void closeDB(){
    try {
      result.close();
      preparedStatement.close();
      conn.close();
    }
    catch (SQLException exception){
      exception.printStackTrace();
    }
  }

  public void checkInAnimal(String name, String species, String subSpecies) {
    animalInformationStr = new String[]{name, species, subSpecies};
    try {

      //Execute a query
      animalQuery = "INSERT INTO ANIMAL(NAME, SUBSPECIES, BREED)"
          + "VALUES (?, ?, ?)";

      preparedStatement = conn.prepareStatement(animalQuery);
      for (String s : animalInformationStr) {
        System.out.println(s);
        preparedStatement.setString(index, s);
        index++;
      }
      preparedStatement.executeUpdate();
      preparedStatement.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  //should be working
  public void updateAnimalInDB(String name, String species, String subSpecies, Date checkInDate,
      Date adoptionDate, Date cleanUpDate, Date vetCheckDate) {
    animalInformationStr = new String[]{species, subSpecies};

    animalInformationDate = new Date[]{checkInDate, adoptionDate, cleanUpDate, vetCheckDate};

    try {
      //Execute a query
      animalQuery =
          "UPDATE ANIMAL SET SUBSPECIES = ?, BREED = ?, CHECKINDATE = ?, ADOPTIONDATE = ?,"
              + " GROOMDATE = ?, VETCHECKDATE = ? where NAME = ?";
      preparedStatement = conn.prepareStatement(animalQuery);
      for (String s : animalInformationStr) {
        preparedStatement.setString(index, s);
        index++;
      }

      for (Date d : animalInformationDate) {
        preparedStatement.setDate(index, d);
        index++;
      }

      preparedStatement.setString(7, name);

      preparedStatement.executeUpdate();
    } catch (SQLException ex) {

      ex.printStackTrace();
    }


  }

 /* public void adoptAnimal(String name, String adoptionDate) {
    animalInformationStr = new String[]{name, adoptionDate};
    try {

      //Execute a query
      animalQuery = "UPDATE ANIMAL SET ADOPTIONDATE = ? WHERE NAME = ?";

      preparedStatement = conn.prepareStatement(animalQuery);
      for (String s : animalInformationStr) {
        System.out.println(s);
        preparedStatement.setString(index, s);
        preparedStatement.setString(index, s);
        index++;
      }
      preparedStatement.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }*/

/* public ArrayList<Animal> getAvailableAnimals(){
   List<Animal> productLine = new ArrayList<>();
   try {
     animalQuery = "SELECT * FROM ANIMAL WHERE ADOPTIONDATE IS NOT NULL";
     preparedStatement = conn.prepareStatement(animalQuery);
     result = preparedStatement.executeQuery();
     while (result.next()) {
       Integer ID = result.getInt("COLLARID");
       String name = result.getString("NAME");
       String manufacturer = result.getString("SUBSPECIES");
       String type = result.getString("BREED");
       productLine.add(new Widget(ID, name, manufacturer, ItemType.valueOf(type)));
     }
   } catch (SQLException ex) {
     ex.printStackTrace();
   }
   return productLine;
 }*/

}