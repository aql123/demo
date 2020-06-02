package com.example.demo.controller;

import com.example.demo.model.Consumption;
import com.example.demo.model.Recharge;
import com.example.demo.service.RecordService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/vip/")
public class RecordController {
    @Resource
    private RecordService recordService;
    @RequestMapping("UserRecharge")
    public String UserRecharge(){
        return "recharge";
    }
    @RequestMapping("userBuy")
    public String userBuy(){
        return "consumption";
    }
    //通过姓名查消费
    @ResponseBody
    @RequestMapping("conByUser")
    public Object conByUser(Consumption consumption,Integer page,Integer rows){
        PageHelper.startPage(page, rows);
        Object user = recordService.getConByUser(consumption);
        return user;
    }
    //通过姓名查充值
    @ResponseBody
    @RequestMapping("recByUser")
    public Object recByUser(Recharge recharge,Integer page,Integer rows){
        PageHelper.startPage(page, rows);
        Object user = recordService.getRecByUser(recharge);
        return user;
    }
    //充值
//    @ResponseBody
//    @RequestMapping("recharge")
//    public Object recharge(Consumption consumption,Integer page,Integer rows){
//        PageHelper.startPage(page, rows);
//        Object all = recordService.getRecharge();
//        return all;
//    }
    //    @ResponseBody
//    @RequestMapping("consumption")
//    //消费记录
//    public Object consumption(Consumption consumption,Integer page,Integer rows){
//        PageHelper.startPage(page, rows);
//        Object all = recordService.getConsumption();
//        return all;
//    }
}
