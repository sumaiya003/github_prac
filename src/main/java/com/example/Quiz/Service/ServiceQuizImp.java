package com.example.Quiz.Service;

import com.example.Quiz.Model.QuestionWrapper;
import com.example.Quiz.Model.Questions;
import com.example.Quiz.Model.Response;
import com.example.Quiz.Repo.QuestionRepo;
import com.example.Quiz.Repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Quiz.Model.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceQuizImp implements ServiceQuiz {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;

    @Override
    public ResponseEntity<String> createQuiz(String category,String title , int num){

        List<Questions> questions = questionRepo.findQuestionsByCategory(category , num);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return  new ResponseEntity<>("Success" , HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getquizQues(Integer id) {
        // here id is the quiz-id
        Optional<Quiz> quiz = quizRepo.findById(id);
        //Quiz quiz1 =quizRepo.findById(id);
        List<Questions> quesfromDB= quiz.get().getQuestions();
        List<QuestionWrapper>  quesForUser = new ArrayList<>();
        for(Questions q :quesfromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            quesForUser.add(qw);
        }
        return new ResponseEntity<>(quesForUser,HttpStatus.OK);
    }
   @Override
   public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses){
        Quiz quiz = quizRepo.findById(id).get();
        List<Questions> questions = quiz.getQuestions();
        int right =0;
        int i=0;
        for(Response response : responses){
          if(response.getResponse().equals(questions.get(i).getRightAns()))
              right++;

          i++;
        }
       return new ResponseEntity<>(right, HttpStatus.OK);
   }

}
