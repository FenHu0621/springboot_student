package com.lening.service;

import com.github.pagehelper.PageInfo;
import com.lening.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: FenHu
 * Date: 2021/12/27
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */
public interface StudentService {
    PageInfo<Student> selectAll(String name,Integer pageNum,Integer pageSize);

    List<Student> findGame();

    List<Student> findMajor(Integer mid);

    void uploadFile(MultipartFile file, String realPath, HttpServletRequest request);

    void insertStudent(Student student,HttpServletRequest request,List<String> list);

    void deleteStu(Integer id, String realPath);

    Student findStudentById(Integer id);
    Student findMajorById(Integer id);
    List<Student> findGameById(Integer id);

    void updateStudentById(Student student,List<String> list);
}
