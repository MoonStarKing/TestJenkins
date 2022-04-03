package com.example.demojenkins.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demojenkins.common.TypeHandler;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "teacher",autoResultMap = true)
public class Teacher{
    @TableId(type = IdType.AUTO)
    private Long id ;
    private Integer age;
    private String name;

    @TableField(typeHandler = TypeHandler.class)
    private List<Object> teacherList;
}
