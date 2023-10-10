package com.software.aop;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component("fieldservice")
public class FieldServiceImpl implements FieldService{
    public boolean addFieldInfo (Field field) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.print("【日志-新增田块】："+formatter.format(date)+"   ");
        System.out.print(field.getFieldId() + "新增田块信息"+field.getFieldName()+"   ");

        return true;

    }
}
