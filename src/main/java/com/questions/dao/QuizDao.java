package com.questions.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questions.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
