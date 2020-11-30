package boot.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * ConfigurationProperties从application配置文件中读取配置项
 * prefix 表示配置的前缀
 * 配置项的类变量名称必须要与前缀之后的名称保持 松散绑定（相同）
 */
//
// ConfigurationProperties(prefix = "jdbc")
@Data
public class JdbcProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;

/*
    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/

}
