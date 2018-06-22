package com.example.dao;

import com.example.dao.baseDao.MyMapper;
import com.example.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Yuchenxi
 * @Description:
 * @Date: Created in 17:18 2017/11/21
 * @Param:
 */
@Mapper
public interface UserDao extends MyMapper<UserInfo>{
    @Select("SELECT * FROM userinfo WHERE username = #{username}")
    UserInfo findByName(@Param("username") String username);

    @Insert("INSERT INTO userinfo(username, password) VALUES(#{username}, #{password})")
    int insertUser(@Param("username") String name, @Param("password") Integer age);

}

