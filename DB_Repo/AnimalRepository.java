package New_Assignment.DB_Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import New_Assignment.Animal.Animal;
import New_Assignment.Operation.ZooManagerPrinter;
import New_Assignment.Services.Cage;
import New_Assignment.Utility.Animal_Factory;
import New_Assignment.Utility.Constant_Class;

/*
*********************************************************************************************************
 *  @Java Class Name :   AnimalRepository
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This class will Interact with Animal Table in Database.
********************************************************************************************************
*/
public class AnimalRepository {

    /*
    *********************************************************************************************************
     *  @Method Name     :   removeAnimal
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for Removing Animal from the Animal Table in the Database.
     *  @Param           :   Cage cage, int animalId
     *  @Return          :   Return True or False.
    ********************************************************************************************************
    */
    public static boolean removeAnimal(Cage cage, int animalId) {
        boolean fl = false;
        try {

            Connection conn = null;
            conn = Connection_Provider.getConn();
            Statement st = conn.createStatement();
            int rowsaffected = st.executeUpdate("delete from animal where zooId = " + cage.zooId + " && zoneId = "
                    + cage.zoneId + " && cageId = " + cage.id + " && animalId = " + animalId);
            if (rowsaffected > 0)
                fl = true;
        } catch (SQLException e) {
            fl = false;
            ZooManagerPrinter.AnimalNotRemovedMessage();
        }
        return fl;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getAnimalsOfCage
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for getting the List of all animals in a Cage.
     *  @Param           :   int zoneId, int zooId, int cageId
     *  @Return          :   Return ArrayList<Animal>.
    ********************************************************************************************************
    */
    public static ArrayList<Animal> getAnimalsOfCage(int zoneId, int zooId, int cageId) {
        ArrayList<Animal> arr = new ArrayList<>();
        try {

            Connection conn = null;
            conn = Connection_Provider.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Constant_Class.SELECT_ALL_FROM_ANIMAL_WHERE + zooId + " && zoneId = " + zoneId
                    + " && cageId = " + cageId);
            while (rs.next()) {
                Animal animal = Animal_Factory.createAnimalObj(rs.getString("animalType"), rs.getString("animalName"),
                        rs.getInt("animalAge"), rs.getDouble("animalWeight"));
                animal.setId(rs.getInt("animalId"));
                arr.add(animal);
            }
        } catch (SQLException e) {
            ZooManagerPrinter.AnimalIsNotRemovedYet();
        }
        return arr;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getAnimalList
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for getting the List of all animals.
     *  @Return          :   Return ArrayList<Animal>.
    ********************************************************************************************************
    */
    public static ArrayList<Animal> getAnimalList() {
        ArrayList<Animal> arr = new ArrayList<>();
        try {
            Connection conn = null;
            conn = Connection_Provider.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Constant_Class.SELECT_ALL_FROM_ANIMAL);
            if (rs.next()) {
                arr.add(Animal_Factory.createAnimalObj(rs.getString("animalType"), rs.getString("animalName"),
                        rs.getInt("animalAge"), rs.getDouble("animalWeight")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getId
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for getting the of animals.
     *  @Return          :   Return ID
    ********************************************************************************************************
    */
    public static int getId() {
        int id =Constant_Class.ZONE_STRT_ID;
        try {
            Connection conn = null;
            conn = Connection_Provider.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Constant_Class.SELECT_ANIMALID_FROM_ANIMAL);
            if (rs.next()) {
                id = rs.getInt("animalId");
                id++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   animalTable
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for creating the Animal Table.
    ********************************************************************************************************
    */
    public static void animalTable() {
        try {
            Connection c = null;
            c = Connection_Provider.getConn();

            String q = Constant_Class.CREATE_TABLE_ANIMAL;

            Statement stmt = c.createStatement();
            stmt.executeUpdate(q);
            stmt.executeUpdate(Constant_Class.ALTER_TABLE_ANIMAL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   insertIntoAnimalTable
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for Inserting Animal into Anaimal table
     *  @Param           :   int id, String animalName, int animalAge, double animalWeight, int zooId,
                             int cageId, int zoneId, String animalType
    ********************************************************************************************************
    */
    public static void insertIntoAnimalTable(int id, String animalName, int animalAge, double animalWeight, int zooId,
            int cageId, int zoneId, String animalType) {
        try {
            Connection c = null;
            c = Connection_Provider.getConn();
            String q = Constant_Class.INSERT_INTO_ANIMAL;

            PreparedStatement pstmt = c.prepareStatement(q);

            pstmt.setString(1, animalName);
            pstmt.setInt(2, animalAge);
            pstmt.setDouble(3, animalWeight);
            pstmt.setInt(4, zooId);
            pstmt.setInt(5, cageId);
            pstmt.setInt(6, zoneId);
            pstmt.setInt(7, id);
            pstmt.setString(8, animalType);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
