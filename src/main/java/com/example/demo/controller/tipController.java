package com.example.demo.controller;

import cn.hutool.core.date.DateUtil;
import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import com.example.demo.service.tipService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/birth/")
public class tipController {
    @Resource
    private tipService tipService;
    @RequestMapping("vipcard")
    public String tip(){
        return "vipcard";
    }
    @ResponseBody
    @RequestMapping("selectAll")
    //查询或者获取所有
    public Object selectAll(UserDTO user,Integer page,Integer rows){
        if(rows==null){
            rows=10;
        }
        Object all = null;
        if(null!=user.getSearchFuture()){
            //查未来日期
            all = tipService.search(user, page, rows);
        }else{
            //通过姓名查或者查全部
            all=tipService.selectAll(user,page,rows);
        }
        return all;
    }
    @ResponseBody
    @RequestMapping("tip")
    //提醒
    public Object tip(User user){
        Map<Object, Object> map = new HashMap<>();
        Integer tip = tipService.tip(user);
        if(tip==1){
            map.put("code", 1);
            map.put("msg", "提醒成功");
        }else if(tip==2){
            map.put("code", 2);
            map.put("msg", "取消提醒成功");
        }else{
            map.put("code", 0);
            map.put("msg", "失败");
        }
        return map;
    }
//    @ResponseBody
//    @RequestMapping("searchFuture")
    //查询未来时间
//    public Object searchFuture(UserDTO userDTO,Integer page,Integer rows){
////        PageInfo<User> pageInfo = new PageInfo<>(users);
////        map.put("total" , pageInfo.getTotal());
////        map.put("rows",pageInfo.getList());
//        Object search = tipService.search(userDTO, page, rows);
//        return search;
//    }
}
