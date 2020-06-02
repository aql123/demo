package com.example.demo.dao;

import com.example.demo.model.User;
import com.example.demo.model.VipUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.List;

/**
 * @author Z
 */
@Mapper
public interface UserDao {

    /**
     * 查询会员基本信息
     * @param user
     * @return
     */
    List<User> selectUserAll(User user);

    /**
     * 会员生日提醒
     * @return
     */

    List<User> selectByBirthday();


    /**
     * 添加会员
     * @param User
     */
    void insertUser(User User);

    /**
     * 编辑保存修改后用户信息
     * @param user
     */

    void  editUser(User user);

    /**
     * 批量删除用户信息
     * @param ids
     */

    void deleteUsers(Long[] ids);
}
