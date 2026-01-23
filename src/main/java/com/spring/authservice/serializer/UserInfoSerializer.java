package com.spring.authservice.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.authservice.models.UserInfoDto;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class UserInfoSerializer implements Serializer<UserInfoDto> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No configuration needed
    }

    @Override
    public byte[] serialize(String arg0, UserInfoDto arg1){
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            retVal = objectMapper.writeValueAsString(arg1).getBytes();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return retVal;
    }

    @Override
    public void close() {
        // No resources to close
    }
}
