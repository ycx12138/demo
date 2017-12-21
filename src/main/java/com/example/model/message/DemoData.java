package com.example.model.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @Author: Yuchenxi
 * @Description:
 * @Date: Created in 11:48 2017/11/23
 * @Param:
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemoData<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
