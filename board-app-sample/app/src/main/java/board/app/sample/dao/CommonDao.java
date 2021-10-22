package board.app.sample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CommonDao {
   
    Connection con;

    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sample_db";
    //Docker Toolboxを使う場合は、URLを以下の行に置き換えること
    //private static final String JDBC_URL = "jdbc:mysql://192.168.99.100/sample_db";
    private static final String DATABASE_USER = "webuser";
    private static final String DATABASE_PASSWORD = "password";

    protected void open() throws Exception {
        try {
            Class.forName(DATABASE_DRIVER);
            con = DriverManager.getConnection(JDBC_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    protected void close(Statement stmt) throws Exception {
        try {
            if(stmt != null) {
                stmt.close();
            }
            if(con != null) {
                con.close();
            }
        } catch (Exception e){
            throw e;
        }
    } 
}
