package br.com.study4devs.appstudy4devs.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDTO {

    private Long id;

    private String name;

    private String login;

    private String email;

    private int points;

    private int questionsAnswered;

    private int rightAnswers;

    private List<Category> category;

    public StudentDTO(Long id, String name, String login, String email, int points, int questionsAnswered, int rightAnswers, List<Category> category) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.points = points;
        this.questionsAnswered = questionsAnswered;
        this.rightAnswers = rightAnswers;
        this.category = category;
    }

}
