package controller;


import ssmweb.domain.Role;
import ssmweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ssmweb.service.RoleService;
import ssmweb.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;


    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        User user=userService.login(username,password);
        if (user!=null){
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }



    /**
     * 删除用户
     * @param userId
     * @return
     */
    @RequestMapping("/del/{UserId}")
    public String del(@PathVariable("UserId") Long userId){
        userService.del(userId);
        return "forward:/user/list";
    }


    /**
     * 添加用户管理
     * @return
     */
    @RequestMapping("/save")
    public String save(User user,Long[] roleIds){

        userService.save(user,roleIds);
        return "forward:/user/list";

    }

    /**
     * 用户管里中(用户角色更新）展示
     * @return
     */
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){

        ModelAndView modelAndView=new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;

    }

    @RequestMapping("/list")
    public ModelAndView list(){

        ModelAndView modelAndView=new ModelAndView();
        List<User> userList=userService.list();
        modelAndView.addObject("users",userList);
        modelAndView.setViewName("user-list");

        return modelAndView;

    }


}
