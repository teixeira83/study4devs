package br.com.study4devs.appstudy4devs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=50, nullable = false)
    private String name;

    @Column(length=12, nullable = false)
    private String login;

    @Column(length=12, nullable = false)
    private String password;

    @Column(length=50, nullable = false)
    private String email;

    private int points;

    private boolean admin;

    private int questionsAnswered;

    private int rightAnswers;

    public enum Category {
        JAVA,
        JAVASCRIPT,
        TYPESCRIPT,
        PYTHON,
        PHP;
    }

    public int whatsMyRank(){
        int temp = 0;
        return temp;
    }
}
