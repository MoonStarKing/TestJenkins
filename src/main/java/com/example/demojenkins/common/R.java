package com.example.demojenkins.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class R {
    private Integer code;
    private String message;
    private Map<String,Object> data = new HashMap();

    public static R ok(){
        R r = new R();
        return r;
    }

    public R data(Map<String,Object>  map){
        this.setData(map);
        return this;
    }

    public R data(String key ,String value){
        this.data.put(key,value);
        return this;
    }
}
