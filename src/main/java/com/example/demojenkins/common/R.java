package com.example.demojenkins.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {
    private Integer code;
    private String message;
    private Map<String,Object> data = new HashMap();

    //就是用什么的东西，哪个模式，哪个基础，才能做好一件事，这个需要很深的功力，要么早知道，要么探索
    //静态方法不属于这个类，只是逻辑上放这里也没事，这里静态函数new 这个类的实例，并返回
    public static R ok(){
        R r = new R();
        r.setCode(200);
        r.setMessage("请求成功");
        return r;
    }

    public R data(Map<String,Object>  map){
        this.setData(map);
        return this;
    }

    public R data(String key ,Object value){
        this.data.put(key,value);
        return this;
    }
}
