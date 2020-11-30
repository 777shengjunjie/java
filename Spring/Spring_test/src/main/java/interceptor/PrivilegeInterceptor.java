package interceptor;

import ssmweb.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrivilegeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user==null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
          // request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request,response);
            return false;
        }
        return true;
    }
}
