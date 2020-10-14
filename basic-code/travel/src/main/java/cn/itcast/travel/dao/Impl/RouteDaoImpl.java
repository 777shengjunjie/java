package cn.itcast.travel.dao.Impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());


    public static void main(String[] args) {

    }

    @Override
    public int findTotalCount(int cid, String rname) {

        // String sql="select count(*) from tab_route where cid = ? ";
        String sql="select count(*) from tab_route where 1 = 1 ";

        StringBuilder sb=new StringBuilder(sql);

        List paras=new ArrayList();  //条件们

        if(cid!=0){
            sb.append(" and cid = ? ");
            paras.add(cid);//添加对应的值
        }

        if(rname!=null&&rname.length()>0&&!"null".equals(rname)){
            sb.append(" and rname like ? ");
            paras.add("%"+rname+"%");
        }

        sql=sb.toString();


        return template.queryForObject(sql,Integer.class,paras.toArray());
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {

        //String sql="select * from tab_route where cid = ? limit ? , ? ";
        String sql="select * from tab_route where 1 = 1 ";

        StringBuilder sb=new StringBuilder(sql);

        List paras=new ArrayList();  //条件们

        if(cid!=0){
            sb.append(" and cid = ? ");
            paras.add(cid);//添加对应的值
        }

        if(rname!=null&&rname.length()>0&&!"null".equals(rname)){
            sb.append(" and rname like ? ");
            paras.add("%"+rname+"%");
        }

        sb.append(" limit ? , ? ");//分页条件

        sql=sb.toString();

        paras.add(start);
        paras.add(pageSize);


        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),paras.toArray());
    }

    @Override
    public Route findOne(int rid) {

        String sql="select * from tab_route where rid = ? ";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Route>(Route.class),rid);

    }
}
