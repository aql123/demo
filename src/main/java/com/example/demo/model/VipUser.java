package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author Z
 */
@TableName("vipcard")
public class VipUser {
    private  Long id;
    private  String name;
    private  int money;
    private  int integral;
    private  String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VipUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money='" + money + '\'' +
                ", integral='" + integral + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
