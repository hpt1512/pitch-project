package com.example.pitchproject.controller;

import com.example.pitchproject.bean.Company;
import com.example.pitchproject.bean.Location;
import com.example.pitchproject.bean.Pitch;
import com.example.pitchproject.bean.User;
import com.example.pitchproject.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    IBaseService<Company> companyService;
    @Autowired
    IBaseService<Location> locationService;
    @Autowired
    IBaseService<Pitch> pitchService;
    @Autowired
    IBaseService<User> userService;
    @GetMapping("/company")
    public String displayPage(Model model) {
        model.addAttribute("locationList", locationService.findAll());
        model.addAttribute("companyList", companyService.findAll());
        return "company/list";
    }
}
