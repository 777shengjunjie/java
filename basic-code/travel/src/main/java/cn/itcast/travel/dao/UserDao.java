package cn.itcast.travel.dao;


import cn.itcast.travel.domain.User;

public interface UserDao {

    /**
     * 根据用户查询用户信息
     * @param name
     * @return
     */
    public User findByUsername(String name);

    /**
     * 用户保存
     * @param user
     */
    public void save(User user);

    /**
     * 根据激活码查找用户
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     * 修改激活码指定用户的激活状态
     * @param user
     */
    void updateStatus(User user);

    /**
     * 根据用户名或者密码查询用户
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);
}
