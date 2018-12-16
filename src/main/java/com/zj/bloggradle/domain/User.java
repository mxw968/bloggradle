package com.zj.bloggradle.domain;

import javax.persistence.*;

/**
 * User实体类
 *
 * @author 周杰
 * @date 2018/11/30
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 实体唯一标识

    @Column(nullable = false)
    private String name; // 用户名称

    @Column(nullable = false)
    private String email; // 邮箱

    protected User() { // 无参构造函数；设为protected防止直接使用

    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, name='%s', email='%s']", id, name, email);
    }
}
