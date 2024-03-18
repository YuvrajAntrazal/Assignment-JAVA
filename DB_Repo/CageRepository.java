package New_Assignment.DB_Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import New_Assignment.Services.Cage;
import New_Assignment.Utility.Constant_Class;
import New_Assignment.Utility.EnumConstant;
import New_Assignment.Utility.EnumConstant.AnimalSpecies;

/*
*********************************************************************************************************
 *  @Java Class Name :   CageRepository
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This class will Interact with Cage Table in Database.
********************************************************************************************************
*/
public class CageRepository {

    /*
    *********************************************************************************************************
     *  @Method Name     :   getCagesOfZone
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for getting the Cages of a Zone.
     *  @Param           :   int zoneId, int zooId
     *  @Return          :   List of Cages.
    ********************************************************************************************************
    */
    public static ArrayList<Cage> getCagesOfZone(int zoneId, int zooId) {
        ArrayList<Cage> arr = new ArrayList<>();
        try {

            Connection conn = null;
            conn = Connection_Provider.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Constant_Class.SELECT_ALL_FROM_CAGE_WHERE + zooId + " && zoneId = " + zoneId);
            while (rs.next()) {
                EnumConstant.AnimalSpecies speciesType = EnumConstant.AnimalSpecies
                        .valueOf(rs.getString("animalSpeciestype"));
                EnumConstant.CageType cageType = EnumConstant.CageType.valueOf(rs.getString("cageType"));
                arr.add(new Cage(rs.getInt("cageId"), speciesType, cageType, rs.getInt("maxNumberOfAnimal"), zooId,
                        zoneId));
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
     *  @Description     :   Responsible for getting the ID of a Cage.
     *  @Return          :   ID
    ********************************************************************************************************
    */
    public static int getId() {
        int id = Constant_Class.ZONE_STRT_ID;
        try {
            Connection conn = null;
            conn = Connection_Provider.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Constant_Class.SELECT_CAGEID_FROM_CAGE);
            if (rs.next()) {
                id = rs.getInt("cageId");
                id++;
            }
        } catch (SQLException e) {
            System.out.println(Constant_Class.CAGE_TABLE_IS_NOT_CREATED);

        }
        return id;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   cageTable
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for Creating Cage Table.
    ********************************************************************************************************
    */
    public static void cageTable() {
        try {
            Connection c = null;
            c = Connection_Provider.getConn();
            String q = Constant_Class.CREATE_TABLE_CAGE;
            Statement stmt = c.createStatement();
            stmt.executeUpdate(q);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   insertintoCageTable
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for inserting Cages into Cage Table.
     *  @Param           :   int id, AnimalSpecies animalSpeciestype, int maxNumberOfAnimal,
                             String cageType, int zooId, int zoneId, int cageId
    ********************************************************************************************************
    */ 
    public static void insertintoCageTable(int id, AnimalSpecies animalSpeciestype, int maxNumberOfAnimal,
            String cageType, int zooId, int zoneId, int cageId) {
        try {
            Connection c = null;
            c = Connection_Provider.getConn();
            String q = Constant_Class.INSERT_INTO_CAGE;

            PreparedStatement pstmt = c.prepareStatement(q);
            pstmt.setString(1, animalSpeciestype.toString());
            pstmt.setInt(2, maxNumberOfAnimal);
            pstmt.setString(3, cageType);
            pstmt.setInt(4, zooId);
            pstmt.setInt(5, zoneId);
            pstmt.setInt(6, cageId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
