package New_Assignment.DB_Repo;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import New_Assignment.Services.Zone;
import New_Assignment.Utility.Constant_Class;
import New_Assignment.Utility.EnumConstant;

/*
*********************************************************************************************************
 *  @Java Class Name :   ZoneRepository
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This class will Interact with Zone Table in Database.
********************************************************************************************************
*/
public class ZoneRepository {

    /*
    *********************************************************************************************************
     *  @Method Name     :   getZonesOfZoo
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for getting all the Zones of a particular Zoo.
     *  @Param           :   int zooId
     *  @Return          :   List of Zones.
    ********************************************************************************************************
    */
    public static ArrayList<Zone> getZonesOfZoo(int zooId) {
        ArrayList<Zone> arr = new ArrayList<>();
        try {
            Connection conn = null;
            conn = Connection_Provider.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Constant_Class.SELECT_ALL_FROM_ZONE + zooId);
            while (rs.next()) {
                EnumConstant.AnimalSpecies myenum = EnumConstant.AnimalSpecies.valueOf(rs.getString("speciesType"));
                arr.add(new Zone(rs.getInt("zoneId"), myenum, rs.getInt("maxNumberOfCages"), zooId));
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
     *  @Description     :   Responsible for getting ID of a Zone.
    ********************************************************************************************************
    */
    public static int getId() {
        int id = Constant_Class.ZONE_STRT_ID;
        try {
            Connection conn = null;
            conn = Connection_Provider.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Constant_Class.SELECT_ZONE_ID_FROM_ZONE);
            if (rs.next()) {
                id = rs.getInt("zoneId");
                id++;
            }
        } catch (SQLException e) {
            System.out.println(Constant_Class.ZONE_TABLE_NOT_CREATED_YET);

        }
        return id;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   ZoneTable
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for Creating the Zone Table.
    ********************************************************************************************************
    */
    public static void ZoneTable() {
        try {
            Connection c = null;
            c = Connection_Provider.getConn();

            String q = Constant_Class.CREATE_ZONE_TABLE;

            Statement stmt = c.createStatement();
            stmt.executeUpdate(q);
            stmt.executeUpdate(Constant_Class.ALTER_TABLE_ZONE);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   insertIntoZoneTable
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for inserting Zone into Zone Table.
     *  @Param           :   int id, EnumConstant.AnimalSpecies speciesType, int maxNumberOfCages,
                             int zooId
    ********************************************************************************************************
    */
    public static void insertIntoZoneTable(int id, EnumConstant.AnimalSpecies speciesType, int maxNumberOfCages,
            int zooId) {
        try {
            Connection c = null;
            c = Connection_Provider.getConn();
            String q2 = Constant_Class.INSERT_INTO_ZONE;

            PreparedStatement pstmt = c.prepareStatement(q2);
            pstmt.setString(1, speciesType.toString());
            pstmt.setInt(2, maxNumberOfCages);
            pstmt.setInt(3, zooId);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}
