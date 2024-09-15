package com.chuwa.learn.mysqlblog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String body;

    // 外键
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id", nullable = false)
    @Getter
    @Setter
    private Blog blog;

    @CreationTimestamp
    @Getter
    @Setter
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Getter
    @Setter
    private LocalDateTime updateDateTime;

    public Comment(long id, String name, String email, String body){
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }
    public Comment() {}

    @Override
    public String toString(){
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

}
