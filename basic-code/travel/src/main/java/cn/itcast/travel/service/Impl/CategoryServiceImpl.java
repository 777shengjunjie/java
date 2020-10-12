package cn.itcast.travel.service.Impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.Impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao=new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {

        Jedis jedis= JedisUtil.getJedis();
        Set<String> categorys = jedis.zrange("category", 0, -1);

        List<Category> cs=null;
        if (categorys==null||categorys.size()==0){

            System.out.println("从数据库查询");
            cs = categoryDao.findAll();
            for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("category",cs.get(i).getCid(),cs.get(i).getCname());
            }

        }else {
            System.out.println("从redis查询");
            cs  =new ArrayList<>();
            for (String name : categorys) {
                Category category=new Category();
                category.setCname(name);
                cs.add(category);

            }

        }

        return cs   ;

    }
}
