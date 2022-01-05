package com.lening.controller;

import com.github.pagehelper.PageInfo;
import com.lening.entity.Student;
import com.lening.service.StudentService;
import com.lening.utils.FileInfo;
import com.lening.utils.ResultInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: FenHu
 * Date: 2021/12/27
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/sc")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/selectAll")
    public PageInfo selectAll(@RequestBody(required = false) Student student,
                              @RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize){
        String name = student.getName();
        return studentService.selectAll(name,pageNum,pageSize);
    }

    @RequestMapping("/findGame")
    public List<Student> findGame(){
       return studentService.findGame();
    }

    @RequestMapping("/findMajor")
    public List<Student> findMajor(Integer mid){
        return studentService.findMajor(mid);
    }

    @RequestMapping("/fileUpload")
    public FileInfo fileUpload(MultipartFile file, HttpServletRequest request){
        try {
            String realPath = request.getServletContext().getRealPath("/");
            studentService.uploadFile(file,realPath,request);
            String imgAddress = (String) request.getSession().getAttribute("imgAddress");
            return new FileInfo(true,"上传成功！",imgAddress);
        }catch (Exception e){
            e.printStackTrace();
            return new FileInfo(false,"上传失败！",null);
        }
    }

    @RequestMapping("/insertStudent")
    public ResultInfo insertStudent(String str,@RequestBody Student student,HttpServletRequest request){
        try {
            String[] split = str.split(",");
            List<String> list = Arrays.asList(split);
            studentService.insertStudent(student,request,list);
            return new ResultInfo(true,"添加成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultInfo(false,"添加失败！");
        }
    }

    @RequestMapping("/deleteStu")
    public ResultInfo deleteStu(Integer id,HttpServletRequest request){
        try {
            String realPath = request.getServletContext().getRealPath("/");
            studentService.deleteStu(id,realPath);
            return new ResultInfo(true,"删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultInfo(false,"删除失败！");
        }
    }

    @RequestMapping("/findStudentById")
    public HashMap findStudentById(HttpServletRequest request){
        int id = (int) request.getSession().getAttribute("id");
        Student student = studentService.findStudentById(id);
        Student major = studentService.findMajorById(id);
        List<Student> gList = studentService.findGameById(id);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("student",student);
        hashMap.put("major",major);
        hashMap.put("gList",gList);
        return hashMap;
    }

    @RequestMapping("/updateStudent")
    public ResultInfo updateStudent(@RequestBody(required = false) Student student, String str, HttpServletRequest request, int backMid, int backCid){
        try {
            student.setMid(backMid);
            student.setCid(backCid);
            int id = (int) request.getSession().getAttribute("id");
            String imgAddress = (String) request.getSession().getAttribute("imgAddress");
            student.setId(id);
            student.setUrl(imgAddress);
            String[] split = str.split(",");
            List<String> list = Arrays.asList(split);
            studentService.updateStudentById(student,list);
            return new ResultInfo(true,"修改成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultInfo(false,"修改失败！");
        }
    }
}
