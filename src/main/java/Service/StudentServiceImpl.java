package Service;

import domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentServiceImpl {
    public static void main(String[] args) throws IOException {
        String config="mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bulider.build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId="dao.StudentDao"+"."+"selectAllStudent";
        List<Student> students = sqlSession.selectList(sqlId);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
