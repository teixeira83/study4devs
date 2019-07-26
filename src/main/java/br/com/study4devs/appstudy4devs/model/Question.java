package br.com.study4devs.appstudy4devs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=500)
    private String title;
    private int rightAnswer;
    @Column(length=200)
    private String firstAnswer;
    @Column(length=200)
    private String secondAnswer;
    @Column(length=200)
    private String thirdAnswer;
    @Column(length=200)
    private String fourthAnswer;

    public boolean isTheRightAnswer(){
        return true;
    }

    public void markAnswer(){
    }

}
