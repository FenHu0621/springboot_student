package com.lening.entity;

import io.swagger.models.auth.In;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: FenHu
 * Date: 2021/12/27
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */
public class Student {

    private int id;
    private String name;
    private String url;
    private int age;
    private int sex;
    private String hobby;

    private int sid;
    private int mid;
    private int gid;
    private int cid;

    private String mname;
    private String gname;
    private String cname;
    private List<Integer> huixian;

    public List<Integer> getHuixian() {
        return huixian;
    }

    public void setHuixian(List<Integer> huixian) {
        this.huixian = huixian;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", hobby='" + hobby + '\'' +
                ", sid=" + sid +
                ", mid=" + mid +
                ", gid=" + gid +
                ", cid=" + cid +
                ", mname='" + mname + '\'' +
                ", gname='" + gname + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
