package com.lening.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: FenHu
 * Date: 2021/12/27
 * Time: 15:25
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("/toindex")
    public String toindex(){
        return "index";
    }

    @RequestMapping("/toadd")
    public String toadd(){
        return "add";
    }

    @RequestMapping("/toupdate")
    public String toupdate(Integer id, HttpServletRequest request){
        request.getSession().setAttribute("id",id);
        return "update";
    }
}
