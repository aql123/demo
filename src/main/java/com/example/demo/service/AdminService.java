package com.example.demo.service;

import com.example.demo.dao.AdminDao;
import com.example.demo.model.admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Z
 */
@Service
public class AdminService  {
    @Resource
    private AdminDao adminDao;

    public admin adminLogin(admin admin){
        return  adminDao.login(admin);
    }

}
