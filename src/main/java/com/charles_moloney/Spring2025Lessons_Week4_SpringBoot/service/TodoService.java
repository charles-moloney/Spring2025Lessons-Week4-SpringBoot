package com.charles_moloney.Spring2025Lessons_Week4_SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charles_moloney.Spring2025Lessons_Week4_SpringBoot.repository.TodoRepository;
import com.charles_moloney.Spring2025Lessons_Week4_SpringBoot.model.Todo;

@Service
public class TodoService {
    
    @Autowired
    private final TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    public List<Todo> findAll() {
        return (List<Todo>) repo.findAll();
    }

    public Todo save(Todo t) {
        return repo.save(t);
    }
    
    public Todo markComplete(Long id) {
        return repo.findById(id)
                   .map(todo -> {
                     todo.setCompleted(true);
                     return repo.save(todo);
                   })
                   .orElseThrow(() -> new IllegalArgumentException("Invalid todo id: " + id));
    }
}
