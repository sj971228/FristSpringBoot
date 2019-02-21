package com.baizhi.service.impl;
import java.util.List;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public long getUserRowCount(){
        return userDao.getUserRowCount();
    }
    @Override
    public List<User> selectUser(){
        return userDao.selectUser();
    }
    @Override
    public User selectUserByObj(User obj){
        return userDao.selectUserByObj(obj);
    }
    @Override
    public User selectUserById(Integer id){
        return userDao.selectUserById(id);
    }
    @Override
    public int insertUser(User value){
        return userDao.insertUser(value);
    }
    @Override
    public int insertNonEmptyUser(User value){
        return userDao.insertNonEmptyUser(value);
    }
    @Override
    public int deleteUserById(Integer id){
        return userDao.deleteUserById(id);
    }
    @Override
    public int updateUserById(User enti){
        return userDao.updateUserById(enti);
    }
    @Override
    public int updateNonEmptyUserById(User enti){
        return userDao.updateNonEmptyUserById(enti);
    }

    public UserDao getUserDao() {
        return this.userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}