package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private String server = "localhost:3306";
    private String db_name = "tour_du_lich1";
    private String user = "root";
    private String password = "12345";
    private String driver_name = "com.mysql.cj.jdbc.Driver";
    private Connection conn = null;

    public ConnectDatabase() {
        loadDriver ();
    }

    private void loadDriver () {
        try{
            Class.forName(driver_name);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Cant load Driver!\n");
        }
    }

    private void loadConnectDb  () {

        try {
             conn= DriverManager.getConnection(
                    "jdbc:mysql://" + server +"/" + db_name,user,password);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Cant connect to Database!\n");
        }
    }

    public Connection getConnection() {
        this.loadConnectDb ();

        return conn;
    }

    public void closeConnection()  {
        try {
            if (conn != null) {
                conn.close();
            }
            else {
                System.out.println("conn is not null!! \n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
