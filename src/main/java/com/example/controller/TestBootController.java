package com.example.controller;

import com.example.model.UserInfo;
import com.example.service.TestInterFace;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @Author: Yuchenxi
 * @Description:
 * @Date: Created in 14:51 2017/11/21
 * @Param:
 */

@Controller
@RequestMapping("test")
@Log4j
public class TestBootController {

    @Autowired
    private TestInterFace testInterFace;

    @RequestMapping("/num")
    @ResponseBody
    int home() {
        int i = testInterFace.testInterFace();
        return i;
    }

    @RequestMapping("/get")
    @ResponseBody
    UserInfo getUser() {
        log.info("TestBootController getUser info");
        log.error("TestBootController getUser info");
        return testInterFace.testUser();
    }
}
