package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    String DBDRIVER = "com.mysql.jdbc.Driver";
    String DBURL = "jdbc:mysql://172.22.146.251:4342/rubic";
    String DBUSER = "root";
    String DBPASSWORD = "cqupt2013+";
    private Connection conn = null;

    public DataBaseConnection() {
        try {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DataBaseConnection db = new DataBaseConnection();
    }
}