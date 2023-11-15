package com.example.Quiz.Service;
import com.example.Quiz.Model.Questions;

import java.util.List;
import java.util.Optional;

public interface Service {

    public void create(Questions questions);
    public List<Questions> getAll();
    public Optional<Questions> getQuesById(int id);

}
