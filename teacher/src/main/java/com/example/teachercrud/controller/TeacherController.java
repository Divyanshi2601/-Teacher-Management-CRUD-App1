package com.example.teachercrud.controller;

import com.example.teachercrud.entity.Teacher;
import com.example.teachercrud.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("teachers", service.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "add-teacher";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Teacher teacher) {
        service.save(teacher);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("teacher", service.findById(id));
        return "edit-teacher";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
