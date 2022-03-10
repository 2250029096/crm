package Service;

import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceImp {
    public static void main(String[] args) throws IOException {
        String config="mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bulider.build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId="dao.UserDao"+"."+"selectAllUser";
        List<User> users = sqlSession.selectList(sqlId);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
