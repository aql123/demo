package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Z
 */

@Controller
@RequestMapping("/user/")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("usersAll")
    public String usersAll() {
        return "users";
    }

    @RequestMapping("findBirthday")
    public  String findBirthday(){
        return "findBirthday";
    }

    @ResponseBody
    @RequestMapping("selectUserAll")
    public Object selectUserAll(User user, Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        List<User> lists = userService.selectUserAll(user);
        PageInfo<User> pageInfo = new PageInfo<>(lists);
        Map<String,Object> map = new HashMap<>();
        map.put("total" , pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @ResponseBody
    @RequestMapping("insertUser")
    public Object insertUser(User user) {
        userService.insertUser(user);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "信息插入成功");
        return map;

    }

    @ResponseBody
    @RequestMapping("editUser")
    public Object editUser(User user) {
        userService.editUser(user);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "用户信息更新完成");
        return map;

    }

    @ResponseBody
    @RequestMapping("deleteUsers")
    public Object deletes(Long[] ids) {
       userService.deleteUsers(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "删除用户成功成功");
        return map;
    }

    @Scheduled(cron = "0 30 23 ? * *")
    @ResponseBody
    @RequestMapping("selectByBirthday")
    public Object selectByBirthday() {
        List<User> list = userService.selectByBirthday();
        Map<String,Object> map = new HashMap<>();
        for (User user:list){
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            int year=cal.get(Calendar.YEAR);
            int day = cal.get(Calendar.DATE);
            int month = cal.get(Calendar.MONTH)+1;


            Calendar ca = Calendar.getInstance();
            ca.setTime(user.getBirthday());
            int mon=ca.get(Calendar.MONTH)+1;
            int da = ca.get(Calendar.DATE);
            /*Date date= new Date(year,mon,da);*/

            Calendar c= Calendar.getInstance();
            c.set(year,mon,da);
            SimpleDateFormat birthday = new SimpleDateFormat("MM月dd日");
            String s=birthday.format(c.getTime());
            if (mon==month){

                if (da-day<3&&da-day>0){

                    map.put(user.getName(),s);
                }

            }
        }
        return map;
    }
}
