package com.example.Quiz.Controller;

import com.example.Quiz.Model.QuestionWrapper;
import com.example.Quiz.Model.Quiz;
import com.example.Quiz.Model.Response;
import com.example.Quiz.Service.ServiceQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {

    @Autowired
    ServiceQuiz serviceQuiz;
    @PostMapping("create")
    public ResponseEntity<String> PostQuiz(@RequestParam String category , @RequestParam String title , @RequestParam int num){
     return  serviceQuiz.createQuiz(category,title,num);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
      //List<QuestionWrapper> list = (List<QuestionWrapper>) serviceQuiz.getquizQues(id);
      //return new ResponseEntity<>(list,HttpStatus.OK);
     return serviceQuiz.getquizQues(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id , @RequestBody List<Response> response){
      return serviceQuiz.calculateResult(id , response);
    }


}
