package com.example.pitchproject.controller;

import com.example.pitchproject.bean.Booking;
import com.example.pitchproject.bean.Pitch;
import com.example.pitchproject.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    IBaseService<Pitch> pitchService;
    @GetMapping("/create/{id}")
    public String showFormBooking(Model model, @PathVariable int id) {
        model.addAttribute("pitch", pitchService.getById(id));
        model.addAttribute("booking", new Booking());
        return "booking/create";
    }
}
