package com.example.demo.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dao.tipDao;
import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class tipService {
    @Resource
    private tipDao tipDao;
    public static String today= DateUtil.today();
    //获取或者查询用户
    public Object selectAll(UserDTO user, Integer page, Integer rows) {
        Map<Object, Object> map = new HashMap<>();
        PageHelper.startPage(page,rows);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(user.getName()!=null){
            wrapper.like("name",user.getName());
        }
        List<User> users = tipDao.selectList(wrapper);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        map.put("total" , pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    //提醒
    public Integer tip(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(user.getTip()!=null&&user.getName()!=null){
            if(user.getTip().equals("是")) {
                wrapper.eq("uid",user.getUid());
                tipDao.update(user, wrapper);
                return 1;
            }
            else{
                wrapper.eq("uid",user.getUid());
                tipDao.update(user, wrapper);
                return 2;
            }
        }
        return 0;
    }

    public Object search(UserDTO userDTO, Integer page, Integer rows) {
        Map<Object, Object> map = new HashMap<>();
        List<User> users=null;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        PageHelper.startPage(page,rows);
        //失误点
        if(null==userDTO.getSearchFuture()){
            Object o = selectAll(new UserDTO(), page, rows);
            return o;
        }
        if(userDTO.getSearchFuture().equals("未来三天")){
            //当前时间+3天
            Date date = DateUtil.parse(today);
            //常用偏移，结果：2017-03-04 22:33:23
            DateTime threeDay = DateUtil.offsetDay(date, 3);
            DateTime threeDay_end = DateUtil.offsetHour(threeDay, 1);
            wrapper.ge("birthday",today);
            wrapper.le("birthday",threeDay_end);
            users = tipDao.selectList(wrapper);
        }else{
            //当前时间+7天
            Date date = DateUtil.parse(today);
            //常用偏移，结果：2017-03-04 22:33:23
            DateTime threeDay = DateUtil.offsetDay(date, 7);
            DateTime threeDay_end = DateUtil.offsetHour(threeDay, 1);
            wrapper.ge("birthday",today);
            wrapper.le("birthday",threeDay_end);
            users = tipDao.selectList(wrapper);
        }
        PageInfo<User> pageInfo = new PageInfo<>(users);
        map.put("total" , pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
