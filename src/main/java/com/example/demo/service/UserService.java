package com.example.demo.service;


import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.model.VipUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Z
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;
    public List<User> selectUserAll(User user){
        return userDao.selectUserAll(user);
    }

    public  List<User> selectByBirthday(){
        return userDao.selectByBirthday();
    }

    public  void  insertUser(User user){
        userDao.insertUser(user);
    }

    public  void  editUser(User user){
        userDao.editUser(user);
    }

    public  void deleteUsers(Long[] ids){userDao.deleteUsers(ids);}
}
