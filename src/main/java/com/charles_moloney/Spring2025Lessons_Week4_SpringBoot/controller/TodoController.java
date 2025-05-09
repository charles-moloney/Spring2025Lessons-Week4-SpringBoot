package com.charles_moloney.Spring2025Lessons_Week4_SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.charles_moloney.Spring2025Lessons_Week4_SpringBoot.model.Todo;
import com.charles_moloney.Spring2025Lessons_Week4_SpringBoot.service.TodoService;

@Controller
public class TodoController {
    
    @Autowired
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("todos", service.findAll());
        return "todos"; // renders todos.html
    }

    @PostMapping("/add")
    public String add(@RequestParam String title) {
        service.save(new Todo(title));
        return "redirect:/";
    }
    
    @PostMapping("/complete")
    public String complete(@RequestParam Long id) {
      service.markComplete(id);
      return "redirect:/";
    }
}
