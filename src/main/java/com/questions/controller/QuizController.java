package com.questions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.questions.model.QuestionWrapper;
import com.questions.model.Response;
import com.questions.service.QuizService;

@RestController
@RequestMapping("/quiz") 
public class QuizController {
	@Autowired
	QuizService quizService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int num_of_questions,@RequestParam String title)
	{
		return quizService.createQuiz(category,num_of_questions,title);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizByID(@PathVariable Integer id)
	{
		return quizService.getQuizByID(id);
	}
	@GetMapping("/submit/{id}")
	public ResponseEntity<Integer> getResult(@PathVariable Integer id,@RequestBody List<Response> response)
	{
		return quizService.getResult(id,response);
	}

}
