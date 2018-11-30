package com.zj.bloggradle.domain;

/**
 * User实体类
 *
 * @author 周杰
 * @date 2018/11/30
 */
public class User {
    private Long id; // 实体唯一标识
    private String name; // 用户名称
    private String email; // 邮箱

    public User() {

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
}
