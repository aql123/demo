package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dao.consumptionDao;
import com.example.demo.dao.rechargeDao;
import com.example.demo.model.Consumption;
import com.example.demo.model.Recharge;
import com.example.demo.model.VipUser;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordService {
    @Resource
    private consumptionDao consumptionDao;
    @Resource
    private rechargeDao rechargeDao;
    //消费
//    public Object getConsumption() {
//
//        Map<Object, Object> map = new HashMap<>();
//        List<Consumption> list = consumptionDao.selectList(null);
//        PageInfo<Consumption> pageInfo = new PageInfo<>(list);
//        map.put("total",pageInfo.getTotal());
//        map.put("rows",pageInfo.getList());
//        return map;
//    }
//    //充值
//    public Object getRecharge(){
//        Map<Object, Object> map = new HashMap<>();
//        List<Recharge> list = rechargeDao.selectList(null);
//        PageInfo<Recharge> pageInfo = new PageInfo<>(list);
//        map.put("total",pageInfo.getTotal());
//        map.put("rows",pageInfo.getList());
//        return map;
//    }
    //条件查消费
    public Object getConByUser(Consumption consumption) {
        Map<Object, Object> map = new HashMap<>();
        QueryWrapper<Consumption> wrapper = new QueryWrapper<>();
        if(consumption.getName()!=null){
            wrapper.like("name",consumption.getName());
        }
        List<Consumption> list = consumptionDao.selectList(wrapper);
        PageInfo<Consumption> pageInfo = new PageInfo<>(list);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    //条件查充值
    public Object getRecByUser(Recharge recharge) {
        Map<Object, Object> map = new HashMap<>();
        QueryWrapper<Recharge> wrapper = new QueryWrapper<>();
        if(recharge.getName()!=null){
            wrapper.like("name",recharge.getName());
        }
        List<Recharge> list = rechargeDao.selectList(wrapper);
        PageInfo<Recharge> pageInfo = new PageInfo<>(list);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
