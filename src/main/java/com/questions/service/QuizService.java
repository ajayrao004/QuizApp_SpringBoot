package com.questions.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.questions.dao.QuestionDao;
import com.questions.dao.QuizDao;
import com.questions.model.QuestionWrapper;
import com.questions.model.Questions;
import com.questions.model.Quiz;
import com.questions.model.Response;

@Service
public class QuizService {
	 @Autowired
     QuizDao quizDao;
	 @Autowired
	 QuestionDao questionDao;
	public ResponseEntity<String> createQuiz(String category, int num_of_questions, String title) 
	{
		List<Questions> questions=questionDao.findQuestionByCategory(category,num_of_questions);
		
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Quiz Created",HttpStatus.CREATED);
		
	}
	public ResponseEntity<List<QuestionWrapper>> getQuizByID(Integer id) {
		Optional<Quiz> quiz=quizDao.findById(id);
		List<Questions> questions=quiz.get().getQuestions();
		List<QuestionWrapper> questionWrapper=new ArrayList<>();
		for(Questions q:questions)
		{
			QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionCol(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionWrapper.add(qw);
		}
		
		return new ResponseEntity<>(questionWrapper,HttpStatus.OK);
	}
	public ResponseEntity<Integer> getResult(Integer id, List<Response> response) {
		int result=0;
		Quiz quiz=quizDao.findById(id).get();
		List<Questions> questions=quiz.getQuestions();
		int i=0;
		for(Response q: response)
		{
			if(q.getResponse().equals(questions.get(i).getRightAnswer()))
				result++;
		         
			i++;
		}
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

	
    
}
