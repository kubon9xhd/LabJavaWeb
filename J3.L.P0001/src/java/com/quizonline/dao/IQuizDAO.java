/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.dao;

import com.quizonline.model.QuizModel;
import com.quizonline.paging.PageRequest;
import java.util.List;

/**
 *
 * @author asus
 */
public interface IQuizDAO {
    Long save(QuizModel modelQuiz);
    QuizModel findById(Long id);
    List<QuizModel> findByLimit(Integer number);
    List<QuizModel> findByOffset(String username,PageRequest page);
    int countByCreatedBy(String username);
    int countAllQuiz();
}
