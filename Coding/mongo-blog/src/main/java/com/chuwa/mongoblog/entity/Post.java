//package com.chuwa.mongoblog.entity;
//
//
//import jakarta.persistence.*;
//
//
//@Entity
//@Table(
//        name = "Posts",
//        /** 确保列中的每个值在表中是唯一的。与主键不同，唯一约束允许列值为空，但每个非空值必须是唯一的。*/
//        uniqueConstraints = {
//                @UniqueConstraint(columnNames = {"title"})
//        }
//)
//public class Post {
//
//    /**
//     * @GeneratedValue primary key
//     * GenerationType.IDENTITY: auto-increment id
//     * GenerationType.SEQUENCE: 使用数据库序列来生成主键值。通常用于支持序列的数据库，如Oracle。
//     * GenerationType.TABLE: 使用一个特定的数据库表生成主键值。
//     * GenerationType.AUTO: 根据底层数据库的能力自动选择合适的生成策略。
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    // unique = true 和 uniqueConstraints 一个作用
//    @Column(name= "title", unique = true, nullable = false)
//    private String title;
//
//    @Column(name= "content",nullable = false)
//    private String content;
//
//    @Column(name= "description",nullable = false)
//    private String description;
//
////    @CreatedDate
////    private LocalDateTime createDateTime;
////
////    @UpdateTimestamp
////    private LocalDateTime updateDateTime;
//
//    public Post() {
//    }
//
//    public Post(Long id, String title, String content, String description) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//        this.description = description;
////        this.createDateTime = createDateTime;
////        this.updateDateTime = updateDateTime;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
////    public LocalDateTime getCreateDateTime() {
////        return createDateTime;
////    }
////
////    public void setCreateDateTime(LocalDateTime createDateTime) {
////        this.createDateTime = createDateTime;
////    }
////
////    public LocalDateTime getUpdateDateTime() {
////        return updateDateTime;
////    }
////
////    public void setUpdateDateTime(LocalDateTime updateDateTime) {
////        this.updateDateTime = updateDateTime;
////    }
//}
//
///**
// * auto_increment 必须是INT或BIGINT
// create table Posts (
// id BIGINT NOT NULL AUTO_INCREMENT,
// title varchar(255) UNIQUE,
// content varchar(255),
// description varchar(255),
// primary key(id)
// );
//
// insert into Posts
// values(1, "hello", "the first post", "hh");
//
// insert into Posts
// values(2, "my post", "the second post", "hh");
//
// insert into Posts
// values(3, "say hi", "the third post", "hh");
// */