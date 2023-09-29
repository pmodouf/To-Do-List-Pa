package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

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

  @GetMapping("/edit/{id}")
  public String editTaskForm(@PathVariable Long id, Model model) {
    Optional<Task> taskOptional = taskRepository.findById(id);
    taskOptional.ifPresent(task -> model.addAttribute("task", task));
    return "edit";
  }

  @PostMapping("/update")
  public String updateTask(@ModelAttribute Task task) {
    taskRepository.save(task);
    return "redirect:/";
  }

  @PostMapping("/delete/{id}")
  public String deleteTask(@PathVariable Long id) {
    taskRepository.deleteById(id);
    return "redirect:/";
  }

  @PostMapping("/add")
  public String addTask(@ModelAttribute Task task) {
    taskRepository.save(task);
    return "redirect:/";
  }
}

