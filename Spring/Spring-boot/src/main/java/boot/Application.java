package boot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

/**
 * SpringBoot都有一个启动引导类，这是工程的入口
 */
@SpringBootApplication
//扫描mybatis所有的业务接口
@MapperScan("boot.mapper")
public class Application {



    public static void main(String[] args) {


        SpringApplication.run(Application.class,args);
    }
}
