package com.example.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @Author: Yuchenxi
 * @Description:
 * @Date: Created in 18:08 2017/12/4
 * @Param:
 */
public class CustomDoubleSerialize extends JsonSerializer<Double>{

    private DecimalFormat df = new DecimalFormat("##.00");

    @Override
    public void serialize(Double aDouble, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString("");
    }
}
