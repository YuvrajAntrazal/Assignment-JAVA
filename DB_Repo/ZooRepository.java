package New_Assignment.DB_Repo;
import java.sql.*;
import java.util.Scanner;
import New_Assignment.Operation.ZooManagerPrinter;
import New_Assignment.Utility.EnumConstant;
public class ZooRepository {
    static Scanner ip = new Scanner(System.in);


    public static int getId(){
        int id = 1000;    
        try{
                Connection conn = null; 
                conn = Connection_Provider.getConn();
                Statement st = conn.createStatement();
                ResultSet rs =  st.executeQuery("select zooId from zoo order by id DESC limit 1");
                if(rs.next()){
                    id = rs.getInt("zooId");
                    id++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return id;
        }


    public static void ZooTable(String zooName) {

        try {
            Connection c = null;
            c = Connection_Provider.getConn();
            String q = "create table IF NOT EXISTS zoo (zooId INT AUTO_INCREMENT PRIMARY KEY, zooName VARCHAR(255))";

            Statement stmt = c.createStatement();
            stmt.executeUpdate(q);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkIfZooExists(int zooId) {
        try {
            Connection c = null;
            c = Connection_Provider.getConn();
            String query = "SELECT COUNT(*) FROM zoo WHERE zooId = ?";
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

    public static void insertIntoZooTable(int zooId, String zooName) {
        try {
            Connection c = null;
            c = Connection_Provider.getConn();

            String q = "insert into Zoo(zooId,zooName) values(?,?)";

            PreparedStatement pstmt = c.prepareStatement(q);
            pstmt.setInt(1, zooId);
            pstmt.setString(2, zooName);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void AddZoneintoTable(String zoneName, EnumConstant.AnimalSpecies animalSpecies,
            int maxNumberOfCages) {
        try {
            Connection c = null;
            c = Connection_Provider.getConn();

            String query2 = "insert into Number_Of_Zones (Zones,Animal_Species,MaximumNoOfCages) values (?,?,?)";

            PreparedStatement pstmt = c.prepareStatement(query2);

            pstmt.setString(1, "zoneName");
            pstmt.setString(2, "animalSpecies");
            pstmt.setInt(3, 3);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeAnimalssById(int id) {
        try {
            Connection c = null;
            c = Connection_Provider.getConn();

            String sql = "delete from animal where id=" + id;
            Statement stmt = c.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void prevoiusZooDetails() {
        Connection c = null;
        Statement stmt = null;
        ResultSet result1 = null;
        ResultSet result2 = null;
        ResultSet result3 = null;

        try {
            c = Connection_Provider.getConn();
            stmt = c.createStatement();
            String q = "SELECT * FROM Zoo";
            result1 = stmt.executeQuery(q);

            while (result1.next()) {

                int id = result1.getInt("zooId");
                String zooName = result1.getString("zooName");

                System.out.println("Zoo ID: " + id + ", Zoo Name: " + zooName);
            }

            System.out.println("\nEnter Zoo ID from above to see Zoo Details.");

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
                String query = "select * from zone where zooId=" + zooIdFromUser;
                Statement stmt1 = coo.createStatement();

                result1 = stmt1.executeQuery(query);

                while (result1.next()) {

                    int zoneId = result1.getInt("id");
                    String zoneType = result1.getString("zoneType");
                    int maxNumberOfCages = result1.getInt("maxNumberOfCages");
                    int zooId = result1.getInt("zooId");

                    System.out.println("Zone ID: " + zoneId + "  " + "zoneType: " + zoneType + "  " + "Max.Cages: "
                            + maxNumberOfCages + "  " + "zooId: " + zooId);

                    query = "select * from cage where zooId=" + zooId + " && zoneId = " + zoneId;
                    Statement stmt2 = coo.createStatement();

                    result2 = stmt2.executeQuery(query);
                    while (result2.next()) {

                        int cageId = result2.getInt("id");
                        String animalSpeciestype = result2.getString("animalSpeciestype");
                        String cagetype = result2.getString("cagetype");
                        zooId = result2.getInt("zooId");

                        System.out
                                .println("      Cage ID: " + cageId + "  " + "Animal Species: " + animalSpeciestype + "  "
                                        + "Cage Type: " + cagetype + "  " + "zooId: " + zooId);

                        query = "select * from animal where zooId=" + zooIdFromUser + " && zoneId = " + zoneId
                                + " && cageId = " + cageId;
                        Statement stmt3 = coo.createStatement();

                        result3 = stmt3.executeQuery(query);

                        while (result3.next()) {

                            int animaliId = result3.getInt("id");
                            String animalName = result3.getString("animalName");
                            int animalAge = result3.getInt("animalAge");
                            int animalWeight = result3.getInt("animalWeight");
                            zooId = result3.getInt("zooId");

                            System.out.println("          Animal ID: " + animaliId + "  " + "Animal Name: " + animalName
                                    + "  "
                                    + "Animal Age: "
                                    + animalAge + "  " +  "Animal Weight: " + animalWeight + "  " + "zooId: " + zooId);
                        }
                    }
                    System.out.println("=".repeat(20));
                    System.out.println();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
