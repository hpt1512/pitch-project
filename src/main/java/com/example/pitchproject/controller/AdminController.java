package com.example.pitchproject.controller;

import com.example.pitchproject.bean.Company;
import com.example.pitchproject.bean.User;
import com.example.pitchproject.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IBaseService<User> userService;
    @Autowired
    IBaseService<Company> companyService;
    @GetMapping("/user")
    public String listUser(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "admin/user/list";
    }
    @GetMapping("/company")
    public String listCompany(Model model) {
        model.addAttribute("companyList", companyService.findAll());
        return "admin/company/list";
    }
}
