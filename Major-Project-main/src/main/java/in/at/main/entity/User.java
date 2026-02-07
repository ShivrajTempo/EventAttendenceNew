package in.at.main.entity;

import jakarta.persistence.*;


@Table(name="user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String userId;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
