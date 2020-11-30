package boot.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HelloBoot {

    @Autowired
    private DataSource dataSource;

    @Value("${boot.url}")
    private String boot;

    @Value(("${boot1.url}"))
    private String boot1;

    @GetMapping("hello")
    public String hello(){

        System.out.println("datasource"+dataSource);
        System.out.println("boot:"+boot);
        System.out.println("boot1:"+boot1);
        return "Hello";
    }
}
