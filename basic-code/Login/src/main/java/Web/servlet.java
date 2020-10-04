package Web;


import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
       /* String username=req.getParameter("username");
        String password=req.getParameter("password");

        User loginUser=new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/
        Map<String, String[]> map = req.getParameterMap();
        String checkCode;

        User loginUser=new User();

        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");

        session.removeAttribute("checkCode_session");
        if (checkCode_session!=null&& checkCode_session.equalsIgnoreCase(loginUser.getCheckCode())){

            UserDao dao=new UserDao();
            User user = dao.login(loginUser);


            if (user==null){
                //失败
                req.setAttribute("login_error","用户名和密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }else {
                //成功
                session.setAttribute("user",user.getUsername());
                resp.sendRedirect(req.getContextPath()+"/success.jsp");
            }


        }else {

            req.setAttribute("cc_error","验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }

      /*  UserDao dao=new UserDao();
        User user = dao.login(loginUser);

        if (user==null){
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
*/


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
