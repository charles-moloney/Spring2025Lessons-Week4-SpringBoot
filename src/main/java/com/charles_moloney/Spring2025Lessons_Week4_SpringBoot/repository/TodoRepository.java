package com.charles_moloney.Spring2025Lessons_Week4_SpringBoot.repository;

import org.springframework.data.repository.CrudRepository;

import com.charles_moloney.Spring2025Lessons_Week4_SpringBoot.model.Todo;


public interface TodoRepository extends CrudRepository<Todo, Long> {}
