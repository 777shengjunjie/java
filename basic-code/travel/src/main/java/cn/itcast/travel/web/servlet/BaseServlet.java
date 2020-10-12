package cn.itcast.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

     /*   System.out.println("base的...");*/

        String uri = req.getRequestURI();
        System.out.println("请求uri："+uri);  ///travel/user/add
        String methodName= uri.substring(uri.lastIndexOf('/') + 1);
        System.out.println("方法名称："+methodName);
        //获取方法对象Method
        //谁调用我？就是谁
        System.out.println(this);//cn.itcast.travel.web.servlet.UserServlet@3cfa295f

        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
