/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.mapper;

import com.quizonline.model.QuizModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class QuizMapper implements RowMapper<QuizModel> {

    @Override
    public QuizModel mapRow(ResultSet rs) {
        QuizModel quizModel = new QuizModel();
        try {
            quizModel.setId(rs.getInt("id"));
            quizModel.setQuestion(rs.getString("question"));
            List<String> listOption = new ArrayList<>();
            listOption.add(rs.getString("option1"));
            listOption.add(rs.getString("option2"));
            listOption.add(rs.getString("option3"));
            listOption.add(rs.getString("option4"));
            quizModel.setOption(listOption);
            String[] arrAnswer = rs.getString("answers").split(",");
            quizModel.setAnswers(arrAnswer);
            quizModel.setCreateDate(new Timestamp(rs.getDate("created_date").getTime()));
            quizModel.setCratedBy(rs.getString("created_by"));
            return quizModel;
        } catch (SQLException ex) {
            Logger.getLogger(QuizMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
