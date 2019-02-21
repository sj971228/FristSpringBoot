package com.baizhi.test;

import com.baizhi.entity.LoginUser;
import com.baizhi.service.LoginUserService;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private LoginUserService loginUserService;
    @Autowired
    private UserService userService;

    @Test
    public void login(){
        System.out.println(loginUserService.login("sj","1234"));
    }
    @Test
    public void showAll(){
        System.out.println(userService.selectUser());
    }
    @Test
    public void regist(){
        loginUserService.regist(new LoginUser(null,"123","123","123",0));
    }


}
