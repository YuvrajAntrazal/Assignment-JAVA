package New_Assignment.DB_Repo;

import java.sql.Connection;
import java.sql.DriverManager;

public  class Connection_Provider {
    public static Connection con;
    public static Connection getConn(){
            try{
            if(con==null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url="jdbc:mysql://localhost:3306/ZOO_MANAGEMENT_SYSTEM";
                con=DriverManager.getConnection(url, "root", "Yuvraj@123");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
