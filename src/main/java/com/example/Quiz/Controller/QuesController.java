package com.example.Quiz.Controller;

import com.example.Quiz.Model.Questions;
import com.example.Quiz.Repo.QuestionRepo;
import com.example.Quiz.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Question")
public class QuesController {

    @Autowired
    Service service;

    @Autowired
    QuestionRepo questionRepo;
    @PostMapping("add")
    public void postdata(@RequestBody Questions questions){
        service.create(questions);
    }
    @GetMapping("allQuestions")
    public List<Questions> getall(){
        return service.getAll();
    }

    @GetMapping("questionNo/{id}")
    public Optional<Questions> getQuestionById(@PathVariable int id){
        return service.getQuesById(id);
    }

    @GetMapping("category/{category}")
    public List<Questions> getQuesByCategory(@PathVariable String category){
         return questionRepo.getQuestionsByCategory(category);

    }
}
