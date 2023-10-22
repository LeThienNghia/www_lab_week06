package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "post_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postId", nullable = false)
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private PostComment parent;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    @Column(name = "title", length = 100)
    private String title;
    @Column(name = "published", nullable = false)
    private Boolean published = false;
    @Column(name = "createAt", nullable = false)
    private Instant createAt;
    @Column(name = "pulishedAt")
    private Instant pulishedAt;
    @Lob
    @Column(name = "content")
    private String content;
    @OneToMany(mappedBy = "parent")
    private Set<PostComment> comments = new LinkedHashSet<>();
}
