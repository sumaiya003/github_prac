package com.example.Quiz.Repo;

import com.example.Quiz.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Questions, Integer> {



    @Query(value = "select * from Questions q where q.category =:category order by RAND() LIMIT :num" , nativeQuery = true)
    List<Questions> findQuestionsByCategory(String category , int num);

    List<Questions> getQuestionsByCategory(String category);
}
