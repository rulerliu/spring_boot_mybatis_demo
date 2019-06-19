package com.mayikt.mybatis.service.impl;

import com.mayikt.mybatis.service.OrderService;

/**
 * @description:
 * @author: liuwq
 * @date: 2019/6/18 0018 下午 12:35
 * @version: V1.0
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public String add() {
        System.out.println(">>>添加订单...");
        return "success";
    }
}
