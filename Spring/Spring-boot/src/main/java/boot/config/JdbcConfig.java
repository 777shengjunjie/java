package boot.config;


//@Configuration
//@PropertySource("classpath:application.properties")
//@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {

  /*  @Value("${jdbc.url}")
    String url;

    @Value("${jdbc.driverClassName}")
    String driver;

    @Value("${jdbc.name}")
    String username;

    @Value("${jdbc.password}")
    String password;

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(name);
        dataSource.setPassword(password);
        return dataSource;
    }*/

   /* @Bean
    public DataSource dataSource(JdbcProperties jdbcProperties){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl(jdbcProperties.getUrl());
        dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
        dataSource.setUsername(jdbcProperties.getUsername());
        dataSource.setPassword(jdbcProperties.getPassword());
        return dataSource;
    }*/


   /* @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource(){
        return new DruidDataSource();
    }*/
}
