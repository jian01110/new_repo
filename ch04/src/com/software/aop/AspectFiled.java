package com.software.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectFiled {
    @Pointcut("execution(* com.software.aop.FieldService.addFieldInfo(..)) && args(field)")
    public void mythod(Field field){};
    @AfterReturning("mythod(field)")
    public void afterReturning(JoinPoint joinPoint , Field field){
        System.out.println("数据记录的主键为"+field.getFieldId());
    }
}
