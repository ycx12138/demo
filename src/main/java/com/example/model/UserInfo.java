package com.example.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Yuchenxi
 * @Description:
 * @Date: Created in 14:58 2017/11/21
 * @Param:
 */
@Table(name = "userinfo")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private Integer age;
    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy/MM/dd HH/mm/ss")
    private Date updateTime;
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy/MM/dd HH/mm/ss")
    private Date createTime;
    @Column(name = "address")
    private String address;
    //  @JsonSerialize(using = CustomDoubleSerialize.class)
    // @JsonDeserialize(using = CustomDoubleDeserialize.class)
    @Column(name = "money")
    private double money;

    public  String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonFormat(pattern = "yyyy/MM/dd HH/mm/ss")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public UserInfo(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public UserInfo() {
    }
}