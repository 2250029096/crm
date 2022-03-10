package dao;

import domain.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> selectAllStudent();
    public int insertStudent(Student student);
}
