package com.example.demo;

import org.junit.jupiter.api.Test;

public class TestTask {

  @Test
  public void testGetId(){
    Task task = new Task();
    task.setId(1L);
    assert(task.getId() == 1L);
  }

  @Test
  public void testGetDescription(){
    Task task = new Task();
    task.setDescription("description");
    assert(task.getDescription().equals("description"));
  }

  @Test
  public void testGetDeadline(){
    Task task = new Task();
    task.setDeadline("deadline");
    assert(task.getDeadline().equals("deadline"));
  }
}
