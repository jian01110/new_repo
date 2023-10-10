package com.software.d4;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("aspectstudent")
@Aspect
public class AspectStudnet {
    @Pointcut("execution(* com.software.d4.Student.eat(..))")
    public void pointcut(){

    }
    @Before("pointcut()")
    public void before() {
        System.out.println("方法执行前");
    }
    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("方法执行后");
    }
    @After("execution(* com.software.d4.Student.study(..))")
    public void after(){
        System.out.println("最终执行");
    }
}