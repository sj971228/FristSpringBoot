package com.baizhi.service;
import java.util.List;
import com.baizhi.entity.LoginUser;
import com.baizhi.entity.User;

public interface LoginUserService{
	boolean login(String username,String password);
	void regist(LoginUser loginUser);
}