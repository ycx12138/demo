package com.example.model;

import net.sf.json.JSONObject;

import java.io.*;

/**
 * @author: ycx
 * @date: 2018/5/16 17:00
 * @description： IO练习
 */
public class IOTest {

    public static void writeByteToFile() {
        String hello = "{\n" +
                "\t\"secondaryClassify\":1,\n" +
                "\t\"loginRole\": 1,\n" +
                "\t\"pageNum\": 1,\n" +
                "\t\"pageSize\": 10\n" +
                "}";
        try {
            byte[] bytes = hello.getBytes();
            File file = new File("d:/test.txt");
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(bytes);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readByteFromFile() {
        try {
            File file = new File("d:/test.txt");
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            int size = inputStream.read(bytes);
            String s = new String(bytes);
            JSONObject jsonObject = JSONObject.fromObject(s);
//            OrderListParam orderListParam = (OrderListParam) JSONObject.toBean(jsonObject,OrderListParam.class);
            System.out.println(String.join(",",String.valueOf(size),s));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        IOTest.writeByteToFile();
        IOTest.readByteFromFile();
    }

}
