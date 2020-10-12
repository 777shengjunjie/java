package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.Impl.UserServiceImpl;
import cn.itcast.travel.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private  UserService service=new UserServiceImpl();
    /**
     * 注册功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");

        if (!check.equalsIgnoreCase(checkcode_server)){
            ResultInfo info=new ResultInfo();

            info.setFlag(false);
            info.setErrorMsg("验证码错误");

            ObjectMapper mapper=new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);

            return;
        }


        Map<String, String[]> map = request.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //UserService service=new UserServiceImpl();
        boolean flag=service.regist(user);
        ResultInfo info=new ResultInfo();
        if (flag){
            info.setFlag(true);
        }else {
            info.setFlag(false);
            info.setErrorMsg("注册失败");
        }
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);



    }

    /**
     * 登录功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String  checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if (!check.equalsIgnoreCase(checkcode_server)){

            ResultInfo info =new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");

            ObjectMapper mapper=new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(),info);

            return;
        }

        Map<String, String[]> map = request.getParameterMap();
        User user =new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //UserService service=new UserServiceImpl();
        User u= service.login(user);

        ResultInfo info=new ResultInfo();

        if (u==null){
            info.setFlag(false);
            info.setErrorMsg("用户名或者密码错误");
        }

        if(u!=null&&!"Y".equals(u.getStatus())){
            info.setFlag(false);
            info.setErrorMsg("您尚未激活，请激活");
        }

        if (u!=null&&"Y".equals(u.getStatus())){
            request.getSession().setAttribute("user",u);
            info.setFlag(true);
        }

        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");

        mapper.writeValue(response.getOutputStream(),info);
    }

    /**
     * 查找一个
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object user = request.getSession().getAttribute("user");

        ObjectMapper mapper=new ObjectMapper();

        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),user);

    }

    /**
     * 退出功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //删除session
        request.getSession().invalidate();

        response.sendRedirect(request.getContextPath()+"/login.html");

    }

    /**
     * 激活功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String code = request.getParameter("code");
        if (code!=null){
           // UserService service=new UserServiceImpl();
            boolean flag= service.active(code);
            String msg=null;
            if (flag){
                msg="激活成功，请<a href='../login.html'>登录</a> ";
            }else {
                msg="激活失败";
            }

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }

}
