package com.mayikt.mybatis.proxy;

import com.mayikt.mybatis.entity.UserEntity;
import org.apache.ibatis.reflection.ExceptionUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: liuwq
 * @date: 2019/6/18 0018 下午 12:31
 * @version: V1.0
 */
public class JDKMapperProxy implements InvocationHandler {

    /**
     * 目标对象
     */
    private Object target;

    public JDKMapperProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 判断有没有实现类
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                System.out.println(">>>before...");
                Object result = method.invoke(target, args);
                System.out.println(">>>after...");
                return result;
            } catch (Throwable t) {
                throw ExceptionUtil.unwrapThrowable(t);
            }
        }
        return new UserEntity(1L, "aa", 2);
    }
}
