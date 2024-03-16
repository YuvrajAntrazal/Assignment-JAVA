package New_Assignment.DB_Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import New_Assignment.Services.Cage;
import New_Assignment.Services.Zone;
import New_Assignment.Utility.EnumConstant;
import New_Assignment.Utility.EnumConstant.AnimalSpecies;

public class CageRepository {

    public static ArrayList<Cage> getCagesOfZone(int zoneId, int zooId){
    ArrayList<Cage> arr = new ArrayList<>();  
    try{

            Connection conn = null; 
            conn = Connection_Provider.getConn();
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery("select * from cage where zooId = "+zooId+" && zoneId = "+zoneId);
            if(rs.next()){
                EnumConstant.AnimalSpecies speciesType = EnumConstant.AnimalSpecies.valueOf(rs.getString("animalSpeciestype"));
                EnumConstant.CageType cageType = EnumConstant.CageType.valueOf(rs.getString("cageType"));
                arr.add(new Cage(rs.getInt("cageId"),speciesType, cageType, rs.getInt("maxNumberOfAnimal"),zooId, zoneId));
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
                ResultSet rs =  st.executeQuery("select cageId from cage order by id DESC limit 1");
                if(rs.next()){
                    id = rs.getInt("cageId");
                    id++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return id;
        }

    public static void cageTable(){
         try{
            Connection c=null;  
            c = Connection_Provider.getConn();

            String q="CREATE TABLE IF NOT EXISTS Cage ("
            + "id INT AUTO_INCREMENT PRIMARY KEY , "
            + "animalSpeciestype VARCHAR(255), "
            + "cagetype VARCHAR(255), "
            + "maxNumberOfAnimal INT, "
            + "zooId INT,"
            + "zoneId INT,"
            + "cageId INT"
            + ")";
                
            Statement stmt=c.createStatement();
            stmt.executeUpdate(q);
            
        }
        catch (SQLException e) {
         e.printStackTrace();
     }
    }

    public static void insertintoCageTable(int id, AnimalSpecies animalSpeciestype,int maxNumberOfAnimal,String cageType ,int zooId, int zoneId, int cageId){
       try{
        Connection c=null; 
        c = Connection_Provider.getConn();
        String q="insert into Cage(animalSpeciestype,maxNumberOfAnimal, cagetype,zooId, zoneId, cageId) values (?,?,?,?,?, ?)";

        PreparedStatement pstmt=c.prepareStatement(q);
        pstmt.setString(1, animalSpeciestype.toString());
        pstmt.setInt(2,maxNumberOfAnimal);
        pstmt.setString(3, cageType);
        pstmt.setInt(4, zooId);
        pstmt.setInt(5, zoneId);
        pstmt.setInt(6, cageId);
        pstmt.executeUpdate();
       }
       catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
