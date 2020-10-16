package cn.itcast.travel.web.servlet;


import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.Impl.FavoriteServiceImpl;
import cn.itcast.travel.service.Impl.RouteServiceImpl;
import cn.itcast.travel.service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService=new FavoriteServiceImpl();
    /**
     * 分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1.获取数据
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");

        String rname = request.getParameter("rname");
        rname = new String(rname.getBytes("iso-8859-1"), "utf-8");


        //2.处理参数
        int cid = 0;//类别id
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }

        int pageSize = 0;//每页显示的条数，如果不传递，则默认为5
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }

        int currentPage = 0;//当前页码，如果不传递，则默认为1
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }

        //分页查询
        PageBean<Route> routePageBean = routeService.pageQuery(cid, pageSize, currentPage, rname);

        //将pageBean序列化
        writeValue(routePageBean, response);

    }

    /**
     * 根据id查询一个旅游线路的具体信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接受id
        String rid = request.getParameter("rid");
        //通过service查询route对象
        Route route = routeService.findOne(rid);
        //转为json写回客户端
        writeValue(route, response);



    }

    /**
     * 判断当前登录用户是否收藏过该线路
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1.获取线路id
        String rid = request.getParameter("rid");

        //2.获取当前登录的用户 user
        User user = (User)request.getSession().getAttribute("user");
        int uid;//用户id
        if (user==null){
            //用户尚未登录
            uid=0;
        }else {
            uid=user.getUid();
        }

        //3.调用FavoriteService查询是否收藏
        boolean flag = favoriteService.isFavorite(rid, uid);

        //4.写回客户端
        writeValue(flag,response);


    }

    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取线路id
        String rid = request.getParameter("rid");

        //2.获取当前登录的用户 user
        User user = (User)request.getSession().getAttribute("user");
        int uid;//用户id
        if (user==null){
            //用户尚未登录
            return;
        }else {
            uid=user.getUid();
        }

        //调用favorireService添加
        favoriteService.add(rid,uid);

    }
}
