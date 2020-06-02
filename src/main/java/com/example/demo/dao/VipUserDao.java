package com.example.demo.dao;

import com.example.demo.model.VipUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Z
 */
@Mapper
public interface VipUserDao {

    /**
     * 查询所有会员卡信息
     * @param vipUser
     * @return
     */
    List<VipUser> selectAll(VipUser vipUser);

    /**
     * 仅显示挂失会员卡
     * @param vipUser
     * @return
     */

    List<VipUser> selectByStatus(VipUser vipUser);
    /**
     * 插入vip卡信息
     * @param vipUser
     */
    void insert(VipUser vipUser);

    /**
     * 批量删除无效会员卡
     * @param ids
     */
    void deletes(Long[] ids);

    /**
     * 会员卡充值，积分不变
     * @param vipUser
     */

    void recharge(VipUser vipUser);

    /**
     * 会员卡消费，积分增加
     * @param vipUser
     */
    void consume(VipUser vipUser);

    /**
     * 会员卡挂失
     * @param vipUser
     */
    void cardLose(VipUser vipUser);

    /**
     * 消费
     * @param vipUser
     */
    void userBuy(VipUser vipUser);
}


