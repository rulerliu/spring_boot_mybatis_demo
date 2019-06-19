import com.mayikt.mybatis.entity.UserEntity;
import com.mayikt.mybatis.mapper.UserMapper;
import com.mayikt.mybatis.proxy.JDKMapperProxy;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: liuwq
 * @date: 2019/6/5 0005 下午 5:26
 * @version: V1.0
 */
public class TestMyBatis2 {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserMapper userMapper = getMapper(UserMapper.class);
        UserEntity user = userMapper.getUser(1L);
        System.out.println(user.getName());
    }

    private static <T> T getMapper(Class<T> type) {
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[] {type}, new JDKMapperProxy(type));
    }

}
