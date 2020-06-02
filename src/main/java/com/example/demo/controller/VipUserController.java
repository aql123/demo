package com.example.demo.controller;


import com.example.demo.model.VipUser;
import com.example.demo.service.VipUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Z
 */
@Controller
@RequestMapping("/vipUser/")
public class VipUserController {

    @Resource
    private VipUserService vipUserService;

    @RequestMapping("vipcard")
    public String vipcard() {
        return "vipcard";
    }
    @RequestMapping("userBuy")
    public String userBuy(){
        return "userBuy";
    }
    @RequestMapping("UserRecharge")
    public String UserRecharge() {
        return "UserRecharge";
    }

    @RequestMapping("userconsume")
    public String userconsume() {
        return "userconsume";
    }

    @RequestMapping("vipCardLose")
    public String cardLose() {
        return "vipcardlose";
    }

    @ResponseBody
    @RequestMapping("selectAll")
    public Object selectAll(VipUser vipUser, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<VipUser> lists = vipUserService.selectAll(vipUser);
        return getObject(lists);
    }

    @ResponseBody
    @RequestMapping("selectByStatus")
    public Object selectByStatus(VipUser vipUser, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<VipUser> lists = vipUserService.selectAll(vipUser);
        return getObject(lists);
    }

    private Object getObject(List<VipUser> lists) {
        PageInfo<VipUser> pageInfo = new PageInfo<>(lists);
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @ResponseBody
    @RequestMapping("insert")
    public Object insert(VipUser vipUser) {
        vipUserService.insert(vipUser);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "插入成功");
        return map;

    }

    @ResponseBody
    @RequestMapping("deletes")
    public Object deletes(Long[] ids) {
        vipUserService.deletes(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "批删除成功");
        return map;
    }

    @ResponseBody
    @RequestMapping("recharge")
    public Object recharge(VipUser vipUser) {
        vipUserService.recharge(vipUser);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "充值成功");
        return map;

    }

    @ResponseBody
    @RequestMapping("consume")
    public Object consume(VipUser vipUser) {
        vipUserService.consume(vipUser);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "消费成功,积分更新完成");
        return map;

    }

    @ResponseBody
    @RequestMapping("cardLose")
    public Object cardLose(VipUser vipUser) {
        vipUserService.cardlLose(vipUser);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "挂失/解除挂失成功");
        return map;

    }
    @ResponseBody
    @RequestMapping("vipUserBuy")
    public Object userBuy(VipUser vipUser){
        vipUserService.userBuy(vipUser);
        Map<Object, Object> map = new HashMap<>();
        map.put("code",1);
        map.put("msg","消费成功");
        return map;
    }
}
