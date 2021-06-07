/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.service.impl;

import com.quizonline.dao.IQuizDAO;
import com.quizonline.dao.impl.QuizDAO;
import com.quizonline.model.QuizModel;
import com.quizonline.paging.PageRequest;
import com.quizonline.service.IQuizService;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author asus
 */
public class QuizService implements IQuizService {

    public IQuizDAO quizDAO;

    public QuizService() {
        quizDAO = new QuizDAO();
    }

    @Override
    public QuizModel save(QuizModel modelQuiz) {
        modelQuiz.setCreateDate(new Timestamp(System.currentTimeMillis()));
        Long id = quizDAO.save(modelQuiz);
        QuizModel model = quizDAO.findById(id);
        return model != null ? model : null;
    }

    @Override
    public QuizModel findById(Long id) {
        QuizModel model = quizDAO.findById(id);
        return model != null ? model : null;
    }

    @Override
    public List<QuizModel> findByOffset(String username, PageRequest page) {
        return quizDAO.findByOffset(username, page);
    }

    @Override
    public int countByCreatedBy(String username) {
        return quizDAO.countByCreatedBy(username);
    }

    @Override
    public List<QuizModel> findByLimit(Integer number) {
        return quizDAO.findByLimit(number);
    }

    @Override
    public int countAllQuiz() {
        return quizDAO.countAllQuiz();
    }

}
