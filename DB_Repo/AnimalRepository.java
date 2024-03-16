package New_Assignment.DB_Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import New_Assignment.Animal.Animal;
import New_Assignment.Services.Cage;
import New_Assignment.Utility.Animal_Factory;
import New_Assignment.Utility.EnumConstant;

public class AnimalRepository {


    public static boolean removeAnimal(Cage cage, int animalId){
        boolean fl = false;
        try{

            Connection conn = null; 
            conn = Connection_Provider.getConn();
            Statement st = conn.createStatement();
            int rowsaffected  = st.executeUpdate("delete from animal where zooId = "+cage.zooId+" && zoneId = "+cage.zoneId+" && cageId = "+cage.id+" && animalId = "+animalId);
            if(rowsaffected>0) return true;
            return false;
        } catch (SQLException e) {
            System.out.println("Animal Is Not Removed");
        }
        return fl;
    }


    public static ArrayList<Animal> getAnimalsOfCage(int zoneId, int zooId, int cageId){
    ArrayList<Animal> arr = new ArrayList<>();  
    try{

            Connection conn = null; 
            conn = Connection_Provider.getConn();
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery("select * from animal where zooId = "+zooId+" && zoneId = "+zoneId+" && cageId = "+cageId);
            while(rs.next()){
                Animal animal = Animal_Factory.createAnimalObj(rs.getString("animalType"), rs.getString("animalName"), rs.getInt("animalAge"), rs.getDouble("animalWeight"));
                animal.setId(rs.getInt("animalId"));
                arr.add(animal);
            }
        } catch (SQLException e) {
            System.out.println("Animal Table Is Not Created Yet");
        }
        return arr;
    }


    public static ArrayList<Animal> getAnimalList(){
        ArrayList<Animal> arr = new ArrayList<>();
        try{
                Connection conn = null; 
                conn = Connection_Provider.getConn();
                Statement st = conn.createStatement();
                ResultSet rs =  st.executeQuery("select * from animal");
                if(rs.next()){
                    arr.add(Animal_Factory.createAnimalObj(rs.getString("animalType"), rs.getString("animalName"), rs.getInt("animalAge"), rs.getDouble("animalWeight")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arr;
        }

        

       public static int getId(){
        int id = 1000;    
        try{
                Connection conn = null; 
                conn = Connection_Provider.getConn();
                Statement st = conn.createStatement();
                ResultSet rs =  st.executeQuery("select animalId from animal order by animalId DESC limit 1");
                if(rs.next()){
                    id = rs.getInt("animalId");
                    id++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return id;
        }

        public static void animalTable(){
            try{
                Connection c=null;  
                c = Connection_Provider.getConn();
    
                String q="CREATE TABLE IF NOT EXISTS Animal ("
                + "id INT AUTO_INCREMENT PRIMARY KEY , "
                + "animalId INT NOT NULL, "
                + "animalName VARCHAR(255), "
                + "animalType VARCHAR(255), "
                + "animalAge INT, "
                + "animalWeight DOUBLE,"
                + "zooId INT ,"
                + "cageId INT,"
                + "zoneId INT "
                + ")";
                    
                Statement stmt=c.createStatement();
                stmt.executeUpdate(q);
                stmt.executeUpdate("ALTER TABLE Animal AUTO_INCREMENT = 1000");
            }
            catch (SQLException e) {
             e.printStackTrace();
         }
        }

        public static void insertIntoAnimalTable(int id,String animalName,int animalAge ,double animalWeight,int zooId, int cageId, int zoneId, String animalType){
            try{
                Connection c=null; 
                c = Connection_Provider.getConn();
                String q="insert into Animal(animalName,animalAge,animalWeight,zooId,cageId, zoneId, animalId, animalType) values (?,?,?,?,?, ?, ?, ?)";

                 PreparedStatement pstmt=c.prepareStatement(q);

        pstmt.setString(1,animalName);
        pstmt.setInt(2,animalAge);
        pstmt.setDouble(3,animalWeight);
        pstmt.setInt(4, zooId);
        pstmt.setInt(5, cageId);
        pstmt.setInt(6, zoneId);
        pstmt.setInt(7, id);
        pstmt.setString(8,animalType);
        pstmt.executeUpdate();


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
}}
