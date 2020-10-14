package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface RouteService {
    /**
     * 分页查询
     * @param cid
     * @param pageSize
     * @param currentPage
     * @param rname
     * @return
     */
    public PageBean<Route> pageQuery(int cid, int pageSize, int currentPage, String rname);

    /**
     * 通过rid，查询route对象
     * @param rid
     * @return
     */
    Route findOne(String rid);
}
