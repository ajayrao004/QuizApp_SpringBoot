package com.questions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questions.model.Questions;

import com.questions.service.QuestionService;

@RestController
@RequestMapping("questions")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Questions>> getAllQuestions()
	{
		return questionService.getAllQuestion();
	}
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable String category)
	{
		return questionService.getQuestionsByCategory(category);
	}
    @PostMapping("/add")
    public ResponseEntity<List<Questions>> addQuestions(@RequestBody List<Questions> questions)
    {
    	return questionService.addQuestions(questions);
    }
    
    @PutMapping("/update")
    public ResponseEntity<String> updateQuestions(@RequestBody Questions questions)
    {
    	return questionService.updateQuestions(questions);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteQuestion(@PathVariable Integer id)
    {
    	 return questionService.deleteQuestion(id);
 
    }
    

}
