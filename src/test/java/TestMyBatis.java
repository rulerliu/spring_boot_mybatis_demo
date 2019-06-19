import com.mayikt.mybatis.entity.UserEntity;
import com.mayikt.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: liuwq
 * @date: 2019/6/5 0005 下午 5:26
 * @version: V1.0
 */
public class TestMyBatis {

    // 1.需要引入mybatisjar包
    // 2.配置核心mybatis文件 数据源、mapper接口映射
    // 3.需要sqlmapper文件 sql数据 orm
    // 4.通过mybatis操作../
    // 疑问：你们在mybatis整合springboot之后需要在每个mapper 需要加入注入spring容器注解 这是为什么呢？
    // 疑问：Mapper如何调用的呢
    public static void main(String[] args) throws IOException {
        // 1.获取InputStreamReaderIo流
        InputStream is = Resources.getResourceAsStream("mybatis_config.xml");

        // 2.获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 3.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.操作Mapper接口
        /*UserMapper userMapper = sqlSession.getMapper(UserMapper.class);*/
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

//        UserEntity user = userMapper.getUser(1L);
//        System.out.println(user.getName());

        System.out.println(">>>第一次查询");
        UserEntity user2 = sqlSession.selectOne("com.mayikt.mybatis.mapper.UserMapper.getUser", 1);
        System.out.println(user2.getName());

//        int result = sqlSession.update("com.mayikt.mybatis.mapper.UserMapper.updateUser", 1);
//        System.out.println(">>>result:" + result);

        // 调用close方法，二级缓存才会把数据commit到redis中
        sqlSession.close();

        System.out.println(">>>第二次查询");
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserEntity user3 = sqlSession2.selectOne("com.mayikt.mybatis.mapper.UserMapper.getUser", 1);
        System.out.println(user3.getName());
    }

}
