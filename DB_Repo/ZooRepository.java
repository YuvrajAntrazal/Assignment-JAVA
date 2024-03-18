package New_Assignment.DB_Repo;

import java.sql.*;
import java.util.Scanner;
import New_Assignment.Operation.ZooManagerPrinter;
import New_Assignment.Utility.Constant_Class;

/*
*********************************************************************************************************
 *  @Java Class Name :   ZooRepository
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This class will Interact with Zoo Table in Database.
********************************************************************************************************
*/
public class ZooRepository {
    static Scanner ip = new Scanner(System.in);

    /*
    *********************************************************************************************************
     *  @Method Name     :   getId
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for getting ID of a Zoo.
    ********************************************************************************************************
    */
    public static int getId() {
        int id = Constant_Class.ZONE_STRT_ID;
        try {
            Connection conn = null;
            conn = Connection_Provider.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Constant_Class.SELECT_ZOO_ID);
            if (rs.next()) {
                id = rs.getInt("zooId");
                id++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   ZooTable
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for Creating the Zoo Table.
    ********************************************************************************************************
    */
    public static void ZooTable(String zooName) {

        try {
            Connection c = null;
            c = Connection_Provider.getConn();
            String q = Constant_Class.CREATE_ZOO_TABLE;

            Statement stmt = c.createStatement();
            stmt.executeUpdate(q);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     /*
    *********************************************************************************************************
     *  @Method Name     :   checkIfZooExists
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for Checking if the Zoo Already exists or Not.
     *  @Param           :   int zooId
    ********************************************************************************************************
    */
    public static boolean checkIfZooExists(int zooId) {
        try {
            Connection c = null;
            c = Connection_Provider.getConn();
            String query = Constant_Class.SELECT_COUNT_FROM_ZOO;
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, zooId);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   insertIntoZooTable
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for inserting Zoo into Zoo Table.
     *  @Param           :   int zooId, String zooName
    ********************************************************************************************************
    */
    public static void insertIntoZooTable(int zooId, String zooName) {
        try {
            Connection c = null;
            c = Connection_Provider.getConn();

            String q = Constant_Class.INSERT_INTO_ZOO;

            PreparedStatement pstmt = c.prepareStatement(q);
            pstmt.setInt(1, zooId);
            pstmt.setString(2, zooName);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   prevoiusZooDetails
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for Viewing Previous Zoo details from the Zoo Table.
    ********************************************************************************************************
    */
    public static void prevoiusZooDetails() {
        Connection c = null;
        Statement stmt = null;
        ResultSet result1 = null;
        ResultSet result2 = null;
        ResultSet result3 = null;

        try {
            c = Connection_Provider.getConn();
            stmt = c.createStatement();
            String q =Constant_Class.SELECT_ALL_FROM_ZOO;
            result1 = stmt.executeQuery(q);

            while (result1.next()) {

                int id = result1.getInt("zooId");
                String zooName = result1.getString("zooName");

                System.out.println("Zoo ID: " + id + ", Zoo Name: " + zooName);
            }

            System.out.println(Constant_Class.SELECT_ZOO_ID_FROM_ABOVE);

            int zooIdFromUser = 0;
            boolean validzooIdInput = false;
            while (!validzooIdInput) {
                try {

                    zooIdFromUser = Integer.parseInt(ip.nextLine());
                    validzooIdInput = true;
                } catch (NumberFormatException e) {
                    ZooManagerPrinter.printPleaseMakeSure();
                }
            }

            try {
                Connection coo = null;
                coo = Connection_Provider.getConn();
                String query = Constant_Class.SELECT_ALL_FROM_ZONE + zooIdFromUser;
                Statement stmt1 = coo.createStatement();

                result1 = stmt1.executeQuery(query);

                while (result1.next()) {

                    int uniquezoneId = result1.getInt("id");
                    String speciesType = result1.getString("speciesType");
                    int maxNumberOfCages = result1.getInt("maxNumberOfCages");
                    int zooId = result1.getInt("zooId");
                    int zoneId = result1.getInt("zoneId");

                    System.out.println(
                            "Zone ID: " + zoneId + "   " + "speciesType: " + speciesType + "   " + "Max.Cages: "
                                    + maxNumberOfCages + "   " + "zooId: " + zooId);

                    query = "select * from cage where zooId=" + zooId + " && zoneId = " + zoneId;
                    Statement stmt2 = coo.createStatement();

                    result2 = stmt2.executeQuery(query);
                    while (result2.next()) {

                        int cageId = result2.getInt("id");
                        String animalSpeciestype = result2.getString("animalSpeciestype");
                        String cagetype = result2.getString("cagetype");
                       
                        System.out
                                .println("      Cage ID: " + cageId + "   " + "Animal Species: " + animalSpeciestype
                                        + "   "
                                        + "Cage Type: " + cagetype + "   " + "zooId: " + zooId);

                        query = Constant_Class.SELECT_ALL_FROM_ANIMAL_WHERE + zooIdFromUser + " && zoneId = " + zoneId
                                + " && cageId = " + cageId;
                        Statement stmt3 = coo.createStatement();

                        result3 = stmt3.executeQuery(query);

                        while (result3.next()) {

                            int animaliId = result3.getInt("id");
                            String animalName = result3.getString("animalName");
                            int animalAge = result3.getInt("animalAge");
                            int animalWeight = result3.getInt("animalWeight");

                            System.out
                                    .println("          Animal ID: " + animaliId + "   " + "Animal Name: " + animalName
                                            + "   "
                                            + "Animal Age: "
                                            + animalAge + "   " + "Animal Weight: " + animalWeight);
                        }
                    }
                    System.out.println("=".repeat(20));
                    System.out.println();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
