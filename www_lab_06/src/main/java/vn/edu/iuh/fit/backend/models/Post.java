package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "authorId", nullable = false)
    private User author;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Post parent;
    @Column(name = "title", length = 75)
    private String title;
    @Column(name = "metaTitle", length = 100)
    private String metaTitle;
    @Lob
    @Column(name = "summary")
    private String summary;
    @Column(name = "published", nullable = false)
    private boolean published = false;
    @Column(name = "createAt", nullable = false)
    private Instant createAt;
    @Column(name = "updateAt")
    private Instant updateAt;
    @Column(name = "publishedAt")
    private Instant publishedAt;
    @Lob
    @Column(name = "content")
    private String content;
    @OneToMany(mappedBy = "post")
    private Set<PostComment> comments = new LinkedHashSet<>();
    @OneToMany(mappedBy = "parent")
    private Set<Post> posts = new LinkedHashSet<>();
}
