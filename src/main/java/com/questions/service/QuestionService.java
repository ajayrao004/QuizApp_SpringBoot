package com.questions.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.questions.model.Questions;

import com.questions.dao.QuestionDao;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	public ResponseEntity<List<Questions>> getAllQuestion()
	{
		try
		{
		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
		try
		{
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<List<Questions>> addQuestions(List<Questions> questions) {
		try
		{
			return new ResponseEntity<>(questionDao.saveAll(questions),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}
	public ResponseEntity<String> updateQuestions(Questions questions) {
		 questionDao.save(questions);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
	public ResponseEntity<String> deleteQuestion(Integer id) {
	     questionDao.deleteById(id);
	     return new ResponseEntity<>("Row was deleted",HttpStatus.OK);
	}
	
	

}
