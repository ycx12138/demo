package com.example.util;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @Author: Yuchenxi
 * @Description:
 * @Date: Created in 18:21 2017/12/4
 * @Param:
 */
public class CustomDoubleDeserialize extends JsonDeserializer<Double> {

    private DecimalFormat df = new DecimalFormat("##.00");

    @Override
    public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Double temp=jsonParser.getCodec().readValue(jsonParser, Double.class);
        String s = df.format(temp);
        double d = Double.parseDouble(s);
        System.out.println(s);
        System.out.println(d);
        return 111.1;
    }
}
