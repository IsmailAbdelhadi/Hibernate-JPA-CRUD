package main.com.myApp.controller.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public User(int id, String username, String password) {
        Id = id;
        this.username = username;
        this.password = password;
    }
}

