package com.baizhi.service.impl;
import java.util.List;
import com.baizhi.dao.LoginUserDao;
import com.baizhi.entity.LoginUser;
import com.baizhi.entity.User;
import com.baizhi.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginUserServiceImpl implements LoginUserService{
    @Autowired
    private LoginUserDao loginUserDao;

    @Override
    public boolean login(String username, String password) {
        LoginUser loginUser = loginUserDao.selectByUsername(username);
        if (loginUser==null){
            return false;
        }else {
            if (password.equals(loginUser.getPassword())){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public void regist(LoginUser loginUser) {
        loginUserDao.insert(loginUser);
    }
}