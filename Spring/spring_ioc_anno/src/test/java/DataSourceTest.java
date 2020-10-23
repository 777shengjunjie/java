import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;


import java.sql.Connection;

public class DataSourceTest {



    @Test
    public void test() throws Exception {


        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://34.92.8.172:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf8");
        dataSource.setUser("root");
        dataSource.setPassword("shengjunjie");
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }



}
