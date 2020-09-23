package jdbc;

import java.io.IOException;
import java.io.InputStream;

import java.sql.*;
import java.util.Properties;

public class JdbcConnection {


    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    static {

        try {

            Properties  pro=new Properties();
            ClassLoader classLoader=JdbcConnection.class.getClassLoader();
         /*   URL resource = classLoader.getResource("jdbc.properties");
            System.out.println(resource.getPath());*/
            InputStream is = classLoader.getResourceAsStream("jdbc.properties");
            pro.load(is);

            user=pro.getProperty("user");
            url=pro.getProperty("url");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");

            try {

                Class.forName(driver);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 链接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }


    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt,Connection conn){
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close(ResultSet rs, Statement stmt, Connection conn ){

        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
