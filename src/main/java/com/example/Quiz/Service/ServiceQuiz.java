package com.example.Quiz.Service;

import com.example.Quiz.Model.QuestionWrapper;
import com.example.Quiz.Model.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceQuiz {

    public ResponseEntity<String> createQuiz(String category, String title , int num);

   public ResponseEntity<List<QuestionWrapper>> getquizQues(Integer id);

    ResponseEntity<Integer> calculateResult(Integer id, java.util.List<com.example.Quiz.Model.Response> response);
}
