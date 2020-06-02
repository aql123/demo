package com.example.demo.dao;

import com.example.demo.model.admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Z
 */
@Mapper
public interface AdminDao {
    admin login(admin admin);
}
