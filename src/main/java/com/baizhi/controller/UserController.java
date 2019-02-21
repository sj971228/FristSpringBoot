package com.baizhi.controller;

import com.baizhi.entity.LoginUser;
import com.baizhi.entity.User;
import com.baizhi.service.LoginUserService;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginUserService loginUserService;
    @Autowired
    private HttpSession session;


    @RequestMapping("/login")
    public String login(String username,String password){
        boolean login = loginUserService.login(username, password);
        if (login){
            return "redirect:/user/showAll.do";
        }else {
            return "redirect:/login.jsp";
        }

    }

    @RequestMapping("/regist")
    public String regist(LoginUser loginUser,String code){
        String realCode = (String) session.getAttribute("code");
        if (realCode.equals(code)){
            loginUserService.regist(loginUser);
            return "redirect:/login.jsp";
        }else {
            return "regist";
        }

    }


    @RequestMapping("showAll")
    public ModelAndView showAll(ModelAndView modelAndView){
        List<User> list = userService.selectUser();
        modelAndView.addObject("user",list);
        modelAndView.setViewName("emplist");
        return modelAndView;
    }

    @RequestMapping("delete")
    public String delete(Integer id){
        userService.deleteUserById(id);
        return "redirect:/user/showAll.do";
    }

    @RequestMapping("/updateEmp")
    public ModelAndView updateEmp(Integer id,ModelAndView modelAndView){
        User user = userService.selectUserById(id);
        modelAndView.addObject("updateEmp",user);
        modelAndView.setViewName("updateEmp");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(User user){
        userService.updateUserById(user);
        return "redirect:/user/showAll.do";
    }

    @RequestMapping("/add")
    public String add(User user){
        userService.insertUser(user);
        return "redirect:/user/showAll.do";
    }

}
