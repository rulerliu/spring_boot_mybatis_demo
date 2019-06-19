import com.mayikt.mybatis.proxy.JDKMapperProxy;
import com.mayikt.mybatis.service.OrderService;
import com.mayikt.mybatis.service.impl.OrderServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: liuwq
 * @date: 2019/6/10 0010 上午 11:07
 * @version: V1.0
 */
public class MyTest {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        OrderService orderServiceProxy = (OrderService) Proxy.newProxyInstance(OrderServiceImpl.class.getClassLoader(), OrderServiceImpl.class.getInterfaces(), new JDKMapperProxy(new OrderServiceImpl()));
        String result = orderServiceProxy.add();
        System.out.println("result:" + result);
        System.out.println(Integer.MAX_VALUE);
    }

    public static void test1() {
        int i = 12;
        System.out.println(i += i);
    }

    public static void test2() {
        int i = 12;
        System.out.println(i += i -= i);
    }

    public static void test3() {
        int i = 12;
        System.out.println(i += i -= i *= i);
    }

}
