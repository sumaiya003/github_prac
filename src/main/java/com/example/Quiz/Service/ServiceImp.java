package com.example.Quiz.Service;

import com.example.Quiz.Model.Questions;
import com.example.Quiz.Repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImp implements com.example.Quiz.Service.Service {

    @Autowired
    QuestionRepo questionRepo;

    @Override
    public void create(Questions questions) {
        questionRepo.save(questions);
    }

    @Override
    public Optional<Questions> getQuesById(int id) {
        return questionRepo.findById(id);
    }

    @Override
    public List<Questions> getAll(){
        return questionRepo.findAll();
    }

}
