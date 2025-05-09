package com.charles_moloney.Spring2025Lessons_Week4_SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.charles_moloney.Spring2025Lessons_Week4_SpringBoot.model.Todo;
import com.charles_moloney.Spring2025Lessons_Week4_SpringBoot.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoRestController {
    @Autowired
    private final TodoService service;

    public TodoRestController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable Long id) {
        return service.findAll().stream().filter(t -> t.getId().equals(id)).findFirst().map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return service.save(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id, @RequestBody Todo updated) {
        return service.findAll().stream().filter(t -> t.getId().equals(id)).findFirst().map(existing -> {
            existing.setTitle(updated.getTitle());
            existing.setCompleted(updated.isCompleted());
            return ResponseEntity.ok(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/complete/{id}")
	public ResponseEntity<Todo> markComplete(@PathVariable Long id) {
		return service.findAll().stream().filter(t -> t.getId().equals(id)).findFirst().map(existing -> {
			existing.setCompleted(true);
			return ResponseEntity.ok(service.save(existing));
		}).orElse(ResponseEntity.notFound().build());
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.markComplete(id); // or repo.deleteById(id) if desired
        return ResponseEntity.noContent().build();
    }
}
