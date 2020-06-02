package com.example.demo.controller;

import com.example.demo.model.admin;
import com.example.demo.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Z
 */
@Controller
@RequestMapping("/")
public class AdminLoginController {
    @Resource
    private AdminService adminService;
    @GetMapping("main.html")
    public String main(){
        return "main";
    }
    @RequestMapping("login")
    public  String  login_show(){
        return "login";
    }

    @RequestMapping("login_submit")
    public String login_submit(admin admin, HttpSession session, Model model){
        com.example.demo.model.admin u = adminService.adminLogin(admin);
        if(u==null){
            model.addAttribute("err","用户名或密码错误");
            return "login";
        }
        session.setAttribute("adminUser",u);
        return "index";
    }
}
