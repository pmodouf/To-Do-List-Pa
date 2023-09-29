package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;
import java.util.Collections;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
public class TestTaskController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskRepository taskRepository;

    private Task testTask;
    private Long testTaskId = 1L;

    @BeforeEach
    public void setUp() {
        testTask = new Task();
        testTask.setId(testTaskId);
    }

    @Test
    public void testListTasks() throws Exception {
        when(taskRepository.findAll()).thenReturn(Collections.singletonList(testTask));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("tasks"));
    }

    @Test
    public void testEditTaskForm() throws Exception {
        when(taskRepository.findById(testTaskId)).thenReturn(Optional.of(testTask));

        mockMvc.perform(get("/edit/{id}", testTaskId))
                .andExpect(status().isOk())
                .andExpect(view().name("edit"))
                .andExpect(model().attributeExists("task"));
    }

    @Test
    public void testUpdateTask() throws Exception {
        when(taskRepository.save(any(Task.class))).thenReturn(testTask);

        mockMvc.perform(post("/update")
                                .param("id", testTask.getId().toString())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void testAddTask() throws Exception {
        when(taskRepository.save(any(Task.class))).thenReturn(testTask);

        mockMvc.perform(post("/add")
                                .param("id", testTask.getId().toString())
                        // Add other params here depending on your Task's fields
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void testDeleteTask() throws Exception {
        doNothing().when(taskRepository).deleteById(testTaskId);

        mockMvc.perform(post("/delete/{id}", testTaskId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }



}