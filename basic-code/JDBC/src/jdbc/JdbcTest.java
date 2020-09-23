package jdbc;


import java.sql.*;
import java.util.Scanner;

public class JdbcTest {




    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String user=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();

        /*String user="zhangsai",password="123";*/
        boolean flag=new JdbcTest().login(user,password);
        if (flag) System.out.println("登录成功");
        else System.out.println("登录失败");



    }

    public boolean login(String user,String password){

        if (user==null||password==null) return false;

        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {

            conn=JdbcConnection.getConnection();
            String sql="select * from account where Name=? and Password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user);
            pstmt.setString(2,password);
            rs= pstmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnection.close(rs,pstmt,conn);
        }

        return false;

    }



}
