package com.lening.mapper;

import com.lening.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: FenHu
 * Date: 2021/12/27
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
public interface StudentMapper {
    List<Student> selectAll(String name);

    List<Student> findGame();

    List<Student> findMajor(Integer mid);

    void insertStudent(Student student);
    void insertMajor(Student student);
    void insertGame(@Param("id") Integer id,@Param("list") List<String> list);

    void deleteStu(Integer id);
    void deleteGame(Integer id);
    void deleteMajor(Integer id);
    String findUrl(Integer id);

    Student findStudentById(Integer id);
    Student findMajorById(Integer id);
    List<Student> findGameById(Integer id);

    void updateStudentById(Student student);
    void updateMajorById(Student student);

}
