package com.lening.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.entity.Student;
import com.lening.mapper.StudentMapper;
import com.lening.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: FenHu
 * Date: 2021/12/27
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public PageInfo<Student> selectAll(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list = studentMapper.selectAll(name);
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Student> findGame() {
        return studentMapper.findGame();
    }

    @Override
    public List<Student> findMajor(Integer mid) {
        return studentMapper.findMajor(mid);
    }

    @Override
    public void uploadFile(MultipartFile file, String realPath, HttpServletRequest request) {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
            String format = sdf.format(new Date());
            String imgAddress = "/imgs"+format+"/"+file.getOriginalFilename();
            //System.out.println("img.."+imgAddress);
            realPath = realPath+imgAddress;
            //System.out.println("real....."+realPath);
            File file1 = new File(realPath);
            if(!file1.exists()){
                file1.mkdirs();
            }
            file.transferTo(file1);
            Student student = new Student();
            student.setUrl(imgAddress);
            request.getSession().setAttribute("student",student);
            request.getSession().setAttribute("imgAddress",imgAddress);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertStudent(Student student, HttpServletRequest request,List<String> list){
        String imgAddress = (String) request.getSession().getAttribute("imgAddress");
        student.setUrl(imgAddress);
        studentMapper.insertStudent(student);
        int id = student.getId();
        student.setSid(id);
        studentMapper.insertMajor(student);
        studentMapper.insertGame(id,list);
    }

    @Override
    public void deleteStu(Integer id, String realPath) {
        String url = studentMapper.findUrl(id);
        File file = new File(realPath + "/" + url);
        file.delete();
        File parentFile = file.getParentFile();
        File[] files = parentFile.listFiles();
        if(files.length<1){
            parentFile.delete();
            File parentFile2 = parentFile.getParentFile();
            File[] files2 = parentFile2.listFiles();
            if(files2.length<1){
                parentFile2.delete();
            }
        }

        studentMapper.deleteStu(id);
        studentMapper.deleteGame(id);
        studentMapper.deleteMajor(id);
    }

    @Override
    public Student findStudentById(Integer id) {
        Student student = studentMapper.findStudentById(id);
        return student;
    }

    @Override
    public Student findMajorById(Integer id) {
        return studentMapper.findMajorById(id);
    }

    @Override
    public List<Student> findGameById(Integer id) {
        return studentMapper.findGameById(id);
    }

    @Override
    public void updateStudentById(Student student,List<String> list) {
        int id = student.getId();
        studentMapper.deleteGame(id);
        studentMapper.updateStudentById(student);
        studentMapper.updateMajorById(student);
        studentMapper.insertGame(id,list);

    }


}
