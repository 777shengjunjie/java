import dao.UserDao;
import domain.User;
import org.junit.jupiter.api.Test;

public class test {



    @Test
    public void  testLogin(){

        User loginUser=new User();
        loginUser.setPassword("1234");
        loginUser.setUsername("superbaby");

        UserDao dao=new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);


    }

}
