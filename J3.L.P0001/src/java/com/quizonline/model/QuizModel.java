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
public class QuizModel extends AbstractModel<QuizModel> {

    private String question;
    private List<String> option;
    private String[] answers;
    private double score = 0;
    private boolean status = false;
    private List<QuizModel> list;
    private Long endTime;
    private int idUserCreated;

    public QuizModel() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOption() {
        return option;
    }

    public void setOption(List<String> option) {
        this.option = option;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<QuizModel> getList() {
        return list;
    }

    public void setList(List<QuizModel> list) {
        this.list = list;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public int getIdUserCreated() {
        return idUserCreated;
    }

    public void setIdUserCreated(int idUserCreated) {
        this.idUserCreated = idUserCreated;
    }

}
