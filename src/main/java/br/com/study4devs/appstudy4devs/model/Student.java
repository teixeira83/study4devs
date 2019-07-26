package br.com.study4devs.appstudy4devs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    public int whatsMyRank(){
        int temp = 0;
        return temp;
    }
}
