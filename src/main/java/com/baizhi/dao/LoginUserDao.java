package com.baizhi.dao;

import com.baizhi.entity.LoginUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserDao{
	LoginUser selectByUsername(String username);
	void insert(LoginUser loginUser);
}