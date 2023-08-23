package com.questions.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.questions.model.Questions;
@Repository
public interface QuestionDao extends JpaRepository<Questions,Integer> {

	List<Questions> findByCategory(String category);
   @Query(value="SELECT * FROM questions q Where q.category=:category ORDER BY RANDOM() LIMIT :num_of_questions", nativeQuery = true)
	List<Questions> findQuestionByCategory(String category, int num_of_questions);

}
