package com.example;

import com.example.service.TestInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Yuchenxi
 * @Description:
 * @Date: Created in 18:33 2017/11/21
 * @Param:
 */
@Component
public class SchedulingTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TestInterFace testInterFace;

  /*  @Scheduled(cron = "0/5 * * * * ?") // 每5秒执行一次
    public void scheduler() {

        logger.info(testInterFace.insertUser("于晨曦","123"));
    }*/
}
