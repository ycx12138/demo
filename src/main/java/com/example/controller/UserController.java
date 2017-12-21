package com.example.controller;


import com.example.model.UserInfo;
import com.example.model.message.DemoData;
import com.example.model.message.MessageServer;
import com.example.service.TestInterFace;
import com.example.util.JsonDateValueProcessor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


/**
 * @Author: Yuchenxi
 * @Description:
 * @Date: Created in 15:06 2017/11/21
 * @Param:
 */
@Slf4j
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private TestInterFace testInterFace;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    UserInfo getUser() {
        return testInterFace.testUser();
    }

    //增加新的对外访问接口
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    MessageServer add(@RequestBody DemoData<UserInfo> demoData) {
        MessageServer messageServer = null;
        try {
            UserInfo userInfo = demoData.getData();
            Integer i = testInterFace.insertUser(userInfo);
            messageServer = new MessageServer();
            if (i == 1) {
                messageServer.setMsg("添加成功llllll11111");
                List<UserInfo> list = new ArrayList<UserInfo>();
                list = testInterFace.selectALL();
                messageServer.setData(list);
                messageServer.setCode(1);
            } else {
                messageServer.setMsg("添加失败llllll11111");
                log.error("新增用户失败！！！");
                List<UserInfo> list = new ArrayList<UserInfo>();
                list = testInterFace.selectALL();
                messageServer.setData(list);
            }
        } catch (Exception e) {
            log.error("新增用户失败！！！", e);
        }

        return messageServer;
    }

    //新增的接口方法
    @RequestMapping(value = "/getall", method = RequestMethod.POST)
    @ResponseBody
    JSONObject getall() {
        log.info("=============================" + "今晚打老虎" + "=============================");
        List<UserInfo> list = testInterFace.selectALL();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject json = new JSONObject();
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("list", list);
//        map.put("rowCount", 1);
//        map.put("pageSize", 3);
//        json.putAll(map, jsonConfig);
//
//        log.info(String.valueOf(json));
//        JavaBean转JSON
        JSONObject jsonObject =JSONObject.fromObject(list.get(1), jsonConfig);
        JSONObject js =  JSONObject.fromObject(jsonObject);
//        JSONArray subMsgs = JSONArray.fromObject(list, jsonConfig);
        log.info(String.valueOf(js));
        return js;
    }

    public static void main(String[] args) {
        String s = "1232213" + "" + "成功";
        System.out.println(s);
    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            // 注意这里得到的n是其上边界类型的, 也就是Number, 需要将其转换为double.
            s += n.doubleValue();
        }
        return s;
    }
}
