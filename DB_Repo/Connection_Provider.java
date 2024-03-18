package New_Assignment.DB_Repo;

import java.sql.Connection;
import java.sql.DriverManager;

import New_Assignment.Utility.Constant_Class;

/*
*********************************************************************************************************
 *  @Java Class Name :   Connection_Provider
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This class is responsible for providing connection to all the classes.
********************************************************************************************************
*/
public class Connection_Provider {
    public static Connection con;

    /*
    *********************************************************************************************************
     *  @Method Name     :   getConn
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for  providing connection to all the Methods.
     *  @Return          :   Connection.
    ********************************************************************************************************
    */
    public static Connection getConn() {
        try {
            if (con == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = Constant_Class.URLHAI;
                con = DriverManager.getConnection(url, "root", "Yuvraj@123");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
