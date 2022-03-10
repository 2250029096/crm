import domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {
    @Test
    public void testStudent() throws IOException {
        String config= "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bulider.build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId="dao.StudentDao"+"."+"selectAllStudent";
        List<Student> students = sqlSession.selectList(sqlId);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testStudent2() throws IOException {
        String config= "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bulider.build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId="dao.StudentDao"+"."+"insertStudent";
        Student s = new Student();
        s.setId(7);
        s.setName("张飞");
        s.setSex("男");
        s.setBirthday("2000");
        s.setEmail("zhangfei@123.com");
        s.setPhone("18284140187");
        int insert = sqlSession.insert(sqlId, s);
        sqlSession.commit();
        System.out.println(insert);

    }
    @Test
    public void testStudent1() throws IOException {
        String config= "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bulider.build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId="dao.StudentDao"+"."+"select1";
        List<Student> students = sqlSession.selectList(sqlId,"王");
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
