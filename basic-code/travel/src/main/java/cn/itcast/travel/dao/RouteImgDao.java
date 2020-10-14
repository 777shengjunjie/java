package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {

    /**
     * 获取图片集合
     * @param rid
     * @return
     */
    public List<RouteImg>  findByRid(int rid);
}
