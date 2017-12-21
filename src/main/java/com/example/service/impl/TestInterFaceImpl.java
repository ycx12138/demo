package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.model.UserInfo;
import com.example.service.TestInterFace;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Yuchenxi
 * @Description:
 * @Date: Created in 14:56 2017/11/21
 * @Param:
 */
@Service
public class TestInterFaceImpl implements TestInterFace {
    //引入dao层接口
    private final static Logger log = LoggerFactory.getLogger(TestInterFaceImpl.class);
    @Autowired
    UserDao userDao;
    @Override
    public int testInterFace() {
        return 0;
    }

    @Override
    public UserInfo testUser() {
        return new UserInfo();
    }

    //新增的接口实现
    @Override
    public int insertUser(UserInfo userInfo) {
        Integer i = null;
        try {
            String s = userInfo.getUsername();
            i = 0;
            System.out.println(userInfo.toString());
            i = userDao.insert(userInfo);
            log.info("插入成功！！！！");
        } catch (Exception e) {
            StackTraceElement[] st = e.getStackTrace();
            String exclass = st[0].getFileName();
            String s = StringUtils.substringAfterLast(exclass, ".");
            System.out.println(s);
        }
        return i;
    }

    //新增加的实现
    @Override
    public List<UserInfo> selectALL() {
        return userDao.selectAll();
    }

    public static void main(String args[]) {
        String exclass = "12345";
        System.out.println(exclass.length());
        String s1= exclass.substring(1, exclass.length() - 1);
    }
}
