package com.chuwa.learn.graphqlblog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "posts"
)
public class Post {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String title;

    @Getter
    @Setter
    @Column(nullable = false)
    private  String description;

    @Getter
    @Setter
    @Column(nullable = false)
    private String content;

    @Getter
    @Setter
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Getter
    @Setter
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
