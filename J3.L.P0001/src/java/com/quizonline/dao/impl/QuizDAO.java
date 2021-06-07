/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.dao.impl;

import com.quizonline.dao.IQuizDAO;
import com.quizonline.mapper.QuizMapper;
import com.quizonline.model.QuizModel;
import com.quizonline.paging.PageRequest;
import java.util.List;
import org.apache.catalina.tribes.util.Arrays;

/**
 *
 * @author asus
 */
public class QuizDAO extends AbstractDAO<QuizModel> implements IQuizDAO {

//    public static void main(String[] args) {
////        String sql = "insert into [Question](question,option1,option2,option3,option4,answers,user_id) values (?,?,?,?,?,?,?)";
////        QuizDAO quizDAO = new QuizDAO();
////        String[] answer = {"1","2","3"};
////        Integer id = 1;
////        System.out.println(quizDAO.insert(sql, "123","456","789","12345","45678",Arrays.toString(answer),id));
//        // get and convert
//        //SELECT TOP 1 * FROM Question ORDER BY CHECKSUM(NEWID())
////        String sql = "Select * from [Question]";
////        QuizDAO quizDAO = new QuizDAO();
////        List<QuizModel> list = quizDAO.query(sql, new QuizMapper());
////        System.out.println(list.get(0).getAnswers()[1]);
//    }
    @Override
    public Long save(QuizModel modelQuiz) {
        String sql = "insert into [Question](question,option1,option2,option3,option4,answers,user_id,created_date,created_by) values (?,?,?,?,?,?,?,?,?)";
        String answers = Arrays.toString(modelQuiz.getAnswers());
        answers = answers.substring(1, answers.length() - 1);
        Long id = insert(sql, modelQuiz.getQuestion(), modelQuiz.getOption().get(0),
                modelQuiz.getOption().get(1), modelQuiz.getOption().get(2),
                modelQuiz.getOption().get(3), answers,
                modelQuiz.getIdUserCreated(), modelQuiz.getCreateDate(),
                modelQuiz.getCratedBy()
        );
        return (id != null) ? id : null;
    }

    @Override
    public List<QuizModel> findByLimit(Integer number) {
        String sql = "SELECT TOP " + number + " * FROM Question ORDER BY CHECKSUM(NEWID())";
        List<QuizModel> list = query(sql, new QuizMapper());
        return list.isEmpty() ? null : list;
    }

    @Override
    public QuizModel findById(Long id) {
        String sql = "Select * from [Question] where id = ?";
        List<QuizModel> list = query(sql, new QuizMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<QuizModel> findByOffset(String username, PageRequest page) {
        String sql = "Select * from [Question] where created_by = ? order by id desc offset ? rows fetch next ? rows only";
        List<QuizModel> list = query(sql, new QuizMapper(), username, page.getOffset(), page.getLimit());
        return list.isEmpty() ? null : list;
    }

    @Override
    public int countByCreatedBy(String username) {
        String sql = "Select COUNT(*) from [Question] where created_by = ?";
        int count = count(sql, username);
        return count;
    }

    @Override
    public int countAllQuiz() {
        String sql = "Select COUNT(*) from [Question]";
        int count = count(sql);
        return count;
    }
}
