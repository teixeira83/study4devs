package br.com.study4devs.appstudy4devs.model;

import lombok.Getter;
import lombok.Setter;

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

    public StudentDTO(Long id, String name, String login, String email, int points, int questionsAnswered, int rightAnswers) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.points = points;
        this.questionsAnswered = questionsAnswered;
        this.rightAnswers = rightAnswers;
    }

}
