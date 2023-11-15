package com.example.Quiz.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "questionTitle")
    private String questionTitle;
    @Column(name = "option1")
    private String option1;
    @Column(name = "option2")
    private String option2;
    @Column(name = "option3")
    private String option3;
    @Column(name = "option4")
    private String option4;
    @Column(name = "rightAns")
    private String rightAns;
    @Column(name = "difficultyLevel")
    private String difficultyLevel;
    @Column(name = "Category")
    private String category;

}
