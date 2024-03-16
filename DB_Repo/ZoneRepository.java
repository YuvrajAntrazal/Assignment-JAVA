package New_Assignment.DB_Repo;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import New_Assignment.Services.Zone;
import New_Assignment.Utility.EnumConstant;

public class ZoneRepository {

   public static ArrayList<Zone> getZonesOfZoo(int zooId){
    ArrayList<Zone> arr = new ArrayList<>();  
    try{
            Connection conn = null; 
            conn = Connection_Provider.getConn();
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery("select * from zone where zooId = "+zooId);
            // ("=").repeat(15);
            while(rs.next()){
                EnumConstant.AnimalSpecies myenum = EnumConstant.AnimalSpecies.valueOf(rs.getString("speciesType"));
                arr.add(new Zone(rs.getInt("zoneId"), myenum, rs.getInt("maxNumberOfCages"), zooId));
                // System.out.println("zone Id -> "+rs.getInt("zoneId"));
            }
            // ("=").repeat(15);
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
                ResultSet rs =  st.executeQuery("select zoneId from zone order by zoneId DESC limit 1");
                if(rs.next()){
                    id = rs.getInt("zoneId");
                    id++;
                }
            } catch (SQLException e) {
                System.out.println("Zone Table Is Not Created Yet");

            }
            return id;
        }

    public static void ZoneTable(){
            try{
                Connection c=null;
            c = Connection_Provider.getConn();

            String q="CREATE TABLE IF NOT EXISTS Zone ("
            + "id INT AUTO_INCREMENT PRIMARY KEY , "
            + "speciesType VARCHAR(255), "
            + "maxNumberOfCages INT,"
            + "zooId INT,"
            + "zoneId INT"
            + ")";
                
            Statement stmt=c.createStatement();
            stmt.executeUpdate(q);
            stmt.executeUpdate("ALTER TABLE Zone AUTO_INCREMENT = 100");
        }
        catch (SQLException e) {
         e.printStackTrace();
         
     }
    }

     public static void insertIntoZoneTable(int id, EnumConstant.AnimalSpecies speciesType, int maxNumberOfCages,int zooId){
        try{
                Connection c=null;
                c = Connection_Provider.getConn();
                String q2="insert into Zone(speciesType,maxNumberOfCages,zooId, zoneId) values(?,?,?, ?)";

                PreparedStatement pstmt=c.prepareStatement(q2);
                pstmt.setString(1, speciesType.toString());
                pstmt.setInt(2, maxNumberOfCages);
                pstmt.setInt(3, zooId);
                pstmt.setInt(4, id);
                pstmt.executeUpdate();
            }
           catch (SQLException e) {
            e.printStackTrace();
            
        }

    }

}
