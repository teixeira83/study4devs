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

    @ManyToMany
    @JoinTable(name = "student_question",
               joinColumns = @JoinColumn(name = "student_id"),
               inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Question> question;

    @ElementCollection(targetClass = Category.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "categorys")
    private List<Category> category;



    public int whatsMyRank(){
        int temp = 0;
        return temp;
    }

    public void changeCategory(List<Category> categorys){
        this.category = categorys;
    }

    public StudentDTO transformToDTO(){
        StudentDTO studentDTO = new StudentDTO(this.id,this.name,this.login,this.email,this.points,this.questionsAnswered,this.rightAnswers);
        return studentDTO;
    }

}
