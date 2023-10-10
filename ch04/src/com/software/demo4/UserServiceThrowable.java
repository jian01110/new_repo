package com.software.demo4;

import org.springframework.aop.ThrowsAdvice;

/**
 * @Author: hugx
 * @Date: 2023-9-25 15:57
 */
public class UserServiceThrowable implements ThrowsAdvice {
    /**
     * Spring API对于异常通知，有要求，业务方法的异常与参数的异常必须是同一类型
     * 或其子类
     * @param ex
     */
    public void afterThrowing(Exception ex) {
        System.out.println("执行了异常");
    }

}
