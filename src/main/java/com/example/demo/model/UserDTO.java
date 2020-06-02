package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class UserDTO {
    @TableId(value = "uid",type = IdType.AUTO)
    private  Long uid;
    private  String name;
    private  String phone;
    @TableField("birthday")
    private Date birthday;
    @TableField("cid")
    private Long cid;
    private String tip;
    private String searchFuture;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getSearchFuture() {
        return searchFuture;
    }

    public void setSearchFuture(String searchFuture) {
        this.searchFuture = searchFuture;
    }
}
