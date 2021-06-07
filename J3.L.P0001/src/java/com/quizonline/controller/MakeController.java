/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.controller;

import com.quizonline.model.QuizModel;
import com.quizonline.model.UserModel;
import com.quizonline.service.IQuizService;
import com.quizonline.service.impl.QuizService;
import com.quizonline.utils.FormUltil;
import com.quizonline.utils.MessageUltil;
import com.quizonline.utils.SessionUltil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
@WebServlet(urlPatterns = "/makequiz")
public class MakeController extends HttpServlet {

    private IQuizService quizService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserModel model = (UserModel) SessionUltil.getInstance().getValue(request, "USERMODEL");
        if (model == null) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }
        if (model.getRoleId() != 1) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }
        MessageUltil.showMessage(request);
        RequestDispatcher rd = request.getRequestDispatcher("views/makequiz.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserModel model = (UserModel) SessionUltil.getInstance().getValue(request, "USERMODEL");
        if (model == null) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }
        if (FormUltil.checkData(request, "question")) {
            String question = request.getParameter("question").trim();
            if (!FormUltil.checkData(request, "option1") || !FormUltil.checkData(request, "option2")
                    || !FormUltil.checkData(request, "option3") || !FormUltil.checkData(request, "option4")) {
                response.sendRedirect(request.getContextPath() + "/makequiz?message=error_option&alert=danger");
                return;
            }
            String option1 = request.getParameter("option1").trim();
            String option2 = request.getParameter("option2").trim();
            String option3 = request.getParameter("option3").trim();
            String option4 = request.getParameter("option4").trim();
            List<String> opList = new ArrayList<>();
            opList.add(option1);
            opList.add(option2);
            opList.add(option3);
            opList.add(option4);
            if (!FormUltil.checkData(request, "answers")) {
                response.sendRedirect(request.getContextPath() + "/makequiz?message=error_answers&alert=danger");
                return;
            }
            String[] answers = request.getParameterValues("answers");
            if (answers.length > 4 || answers.length <= 0) {
                response.sendRedirect(request.getContextPath() + "/makequiz?message=error_answers&alert=danger");
                return;
            }
            if (!FormUltil.isRightOptions(answers)) {
                response.sendRedirect(request.getContextPath() + "/makequiz?message=error_answers_f12&alert=danger");
                return;
            }
            QuizModel modelQuiz = new QuizModel();
            modelQuiz.setQuestion(question);
            modelQuiz.setOption(opList);
            modelQuiz.setAnswers(answers);
            modelQuiz.setCratedBy(model.getUsername());
            modelQuiz.setIdUserCreated(model.getId());
            quizService = new QuizService();
            modelQuiz = quizService.save(modelQuiz);
            if (modelQuiz != null) {
                response.sendRedirect(request.getContextPath() + "/makequiz?message=insert_question_done&alert=success");
            } else {
                response.sendRedirect(request.getContextPath() + "/makequiz?message=insert_question_fail&alert=danger");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/makequiz?message=error_question&alert=danger");

        }
    }
}
