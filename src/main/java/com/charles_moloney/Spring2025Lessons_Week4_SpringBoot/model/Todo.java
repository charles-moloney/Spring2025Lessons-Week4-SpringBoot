package com.charles_moloney.Spring2025Lessons_Week4_SpringBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private boolean completed;

  // Constructors
  public Todo() {}
  public Todo(String title) { this.title = title; }

  // Getters + Setters
  public Long getId() { return id; }
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public boolean isCompleted() { return completed; }
  public void setCompleted(boolean completed) { this.completed = completed; }
}
