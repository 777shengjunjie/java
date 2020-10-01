package Util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    private  static DataSource ds;

    static {


        try {
            Properties pro =new Properties();
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            ds= DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        }  catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 获取连接池对象
     */
    public static DataSource getDs() {
        return ds;
    }

    /**
     * 获取Connection 连接
     */

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
