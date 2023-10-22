package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "firstName", length = 50)
    private String first_name;
    @Column(name = "middleName", length = 50)
    private String middle_name;
    @Column(name = "lastName", length = 50)
    private String last_name;
    @Column(name = "mobile", length = 50)
    private String mobile;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "passwordHash",nullable = false, length = 32)
    private String password_hash;
    @Column(name = "lastLogin")
    private Instant last_login;
    @Column(name = "registeredAt",nullable = false, length = 32)
    private Instant registered_at;
    @Lob
    @Column(name = "intro")
    private String intro;
    @Lob
    @Column(name = "profile")
    private String profile;
    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new LinkedHashSet<>();
    @OneToMany(mappedBy = "user")
    private Set<PostComment> comments = new LinkedHashSet<>();


}
