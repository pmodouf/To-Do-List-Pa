package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

  private final TaskRepository taskRepository;

  public TaskController(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @GetMapping("/")
  public String listTasks(Model model) {
    model.addAttribute("tasks", taskRepository.findAll());
    return "index";
  }

  @PostMapping("/add")
  public String addTask(@ModelAttribute Task task) {
    taskRepository.save(task);
    return "redirect:/";
  }
}
