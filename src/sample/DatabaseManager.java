package sample;

import java.sql.Date;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
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
    private Timestamp[] animalInformationDate;


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

    public void closeDB() {
        try {
            result.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    void updateAnimalInDB(String name, Timestamp groomDate,
                          Timestamp vetDate, String collarID) {

        try {
            //Execute a query
            initializeDb();
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

    public void scheduleVisit(String lastVetVisit, String lastGroomerVisit, Timestamp nextVetVisit, Timestamp nextGroomerVisit) {
        String[] lastDates = new String[]{lastVetVisit, lastGroomerVisit};

        Timestamp[] newAppointments = new Timestamp[]{nextVetVisit, nextGroomerVisit};

        try {
            initializeDb();
            //Execute a query
            animalQuery = "INSERT INTO ANIMALS VALUES(?,?,?,?)";
            preparedStatement = conn.prepareStatement(animalQuery);
            for (String s : lastDates) {
                preparedStatement.setString(index, s);
                index++;
            }

            for (Timestamp ts : newAppointments) {
                preparedStatement.setTimestamp(index, ts);
                index++;
            }
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

    public List<Animal> getAvailableAnimals() {
        List<Animal> animalsInDB = new ArrayList<>();
        try {
            initializeDb();
            animalQuery = "SELECT * FROM ANIMALS";
            preparedStatement = conn.prepareStatement(animalQuery);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                int ID = result.getInt("COLLARID");
                String name = result.getString("ANIMALNAME");
                String subspecies = result.getString("SPECIES");
                String breed = result.getString("BREED");
                Timestamp checkInDate = result.getTimestamp("CHECKEDIN");
                Timestamp groomDate = result.getTimestamp("LASTGROOMED");
                Timestamp vetCheckDate = result.getTimestamp("LASTCHECKUP");
                animalsInDB.add(new Animal(ID, name, subspecies, breed, checkInDate, groomDate, vetCheckDate));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return animalsInDB;
    }
    public List<Animal> getAnimalSearch(String animalName) {
        List<Animal> animalsInDB = new ArrayList<>();
        try {
            initializeDb();
            animalQuery = "SELECT * FROM ANIMALS WHERE ANIMALNAME LIKE ? OR SPECIES LIKE ? OR BREED LIKE ?";
            preparedStatement = conn.prepareStatement(animalQuery);
            preparedStatement.setString(1,animalName);
            preparedStatement.setString(2,animalName);
            preparedStatement.setString(3,animalName);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                int ID = result.getInt("COLLARID");
                String name = result.getString("ANIMALNAME");
                String subspecies = result.getString("SPECIES");
                String breed = result.getString("BREED");
                Timestamp checkInDate = result.getTimestamp("CHECKEDIN");
                Timestamp groomDate = result.getTimestamp("LASTGROOMED");
                Timestamp vetCheckDate = result.getTimestamp("LASTCHECKUP");
                animalsInDB.add(new Animal(ID, name, subspecies, breed, checkInDate, groomDate, vetCheckDate));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return animalsInDB;
    }

    public void addAnimal(String[] animalInfo) throws SQLException {
        try {

            initializeDb();
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