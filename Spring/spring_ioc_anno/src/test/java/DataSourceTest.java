import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;


import java.sql.Connection;

public class DataSourceTest {



    @Test
    public void test() throws Exception {

        /*
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://34.92.8.172:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf8");
        dataSource.setUser("root");
        dataSource.setPassword("shengjunjie");
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();
        */





        
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        // dataSource.setJdbcUrl("jdbc:mysql://34.92.8.172:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf8");
        dataSource.setJdbcUrl("jdbc:mysql://34.92.8.172:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("shengjunjie");

        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        int row = jdbcTemplate.update("insert into account value(?,?) ", "tom", 5000);
        System.out.println(row);



    }



}
