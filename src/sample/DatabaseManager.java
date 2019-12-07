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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param name
     * @param species
     * @param breed
     * @param checkInDate
     * @param groomDate
     * @param vetCheckDate
     */
    void updateAnimalInDB(String name, String species, String breed, Timestamp checkInDate,
                          Timestamp groomDate, Timestamp vetCheckDate) {
        animalInformationStr = new String[]{breed, species};

        animalInformationDate = new Timestamp[]{checkInDate, groomDate, vetCheckDate};

        try {
            //Execute a query
            animalQuery =
                    "UPDATE ANIMAL SET SUBSPECIES = ?, BREED = ?,"
                            + " CHECKINDATE=?, GROOMDATE = ?, VETCHECKDATE = ? where NAME = ?";
            preparedStatement = conn.prepareStatement(animalQuery);
            for (String s : animalInformationStr) {
                preparedStatement.setString(index, s);
                index++;
            }

            for (Timestamp ts : animalInformationDate) {
                preparedStatement.setTimestamp(index, ts);
                index++;
            }

            preparedStatement.setString(7, name);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }

    public void scheduleVisit(String lastVetVisit, String lastGroomerVisit, Timestamp nextVetVisit, Timestamp nextGroomerVisit) {
        String[] lastDates= new String[]{lastVetVisit, lastGroomerVisit};

        Timestamp[] newAppointments = new Timestamp[]{nextVetVisit, nextGroomerVisit};

        try {
            //Execute a query
            animalQuery = "INSERT INTO appointments VALUES(?,?,?,?)";
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
            animalQuery = "SELECT * FROM ANIMAL";
            preparedStatement = conn.prepareStatement(animalQuery);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                int ID = result.getInt("COLLARID");
                String name = result.getString("NAME");
                String subspecies = result.getString("SUBSPECIES");
                String breed = result.getString("BREED");
                Timestamp checkInDate = result.getTimestamp("CHECKINDATE");
                Timestamp groomDate = result.getTimestamp("GROOMDATE");
                Timestamp vetCheckDate = result.getTimestamp("VETCHECKDATE");
                animalsInDB.add(new Animal(ID, name, subspecies, breed, checkInDate, groomDate, vetCheckDate));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return animalsInDB;
    }
}