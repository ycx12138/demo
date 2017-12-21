package com.example.service;

import com.example.model.UserInfo;

import java.util.List;

/**
 * @Author: Yuchenxi
 * @Description:
 * @Date: Created in 14:55 2017/11/21
 * @Param:
 */
public interface TestInterFace {

    public int testInterFace();

    public UserInfo testUser();

    public int insertUser(UserInfo userInfo);//新增的接口

    //新增加的方法
    List<UserInfo> selectALL();
}
