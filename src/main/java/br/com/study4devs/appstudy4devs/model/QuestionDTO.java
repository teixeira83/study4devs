package br.com.study4devs.appstudy4devs.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDTO {

    private Long id;

    private String title;

    private int rightAnswer;

    private String firstAnswer;

    private String secondAnswer;

    private String thirdAnswer;

    private String fourthAnswer;

    private Category category;

    public QuestionDTO(Long id, String title, int rightAnswer, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer, Category category) {
        this.id = id;
        this.title = title;
        this.rightAnswer = rightAnswer;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
        this.category = category;
    }
}
