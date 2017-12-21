package com.example.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@Log4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageServer<T>{
    
    private int code = -1;
    private String msg = "OK";
    private String exception;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public void printException(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw, true));
        this.exception = (this.exception==null?sw.toString():this.exception+"\r\n"+sw.toString());
        try {
            sw.close();
        } catch (IOException e1) {
           log.error(e1);
        }
    }

}
