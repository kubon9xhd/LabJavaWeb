/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.model;

import java.util.List;

/**
 *
 * @author asus
 */
public class UserModel extends AbstractModel<UserModel> {

    private String username;
    private String password;
    private Integer roleId;
    private RoleModel roleModel;
    private List<QuizModel> quiz;
    private String email;

    public UserModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<QuizModel> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<QuizModel> quiz) {
        this.quiz = quiz;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    
}
