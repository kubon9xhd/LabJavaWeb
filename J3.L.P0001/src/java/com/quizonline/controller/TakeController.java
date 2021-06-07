package com.quizonline.controller;

import com.oracle.webservices.internal.api.databinding.DatabindingModeFeature;
import com.quizonline.model.QuizModel;
import com.quizonline.model.UserModel;
import com.quizonline.service.IQuizService;
import com.quizonline.service.impl.QuizService;
import com.quizonline.utils.FormUltil;
import com.quizonline.utils.MessageUltil;
import com.quizonline.utils.SessionUltil;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asus
 */
@WebServlet(urlPatterns = {"/takequiz"})
public class TakeController extends HttpServlet {

    IQuizService quizService;

    public TakeController() {
        quizService = new QuizService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserModel userModel = (UserModel) SessionUltil.getInstance().getValue(request, "USERMODEL");
        String view = "";
        if (userModel != null) {
            QuizModel quizModel = (QuizModel) SessionUltil.getInstance().getValue(request, "QUIZMODEL");
            if (quizModel != null) {
                Integer id = (Integer) SessionUltil.getInstance().getValue(request, "IDQUIZRUN");
                if (quizModel.getEndTime() < System.currentTimeMillis() || quizModel.getList().size() < id + 1) {
//                    SessionUltil.getInstance().pushValue(request, "SCORE", getScore(quizModel.getList()));
                    double score = (double) Math.round(getScore(quizModel.getList())*100)/100;
                    request.setAttribute("SCORE", score);
                    SessionUltil.getInstance().removeValue(request, "QUIZMODEL");
                    SessionUltil.getInstance().removeValue(request, "IDQUIZRUN");
                    SessionUltil.getInstance().removeValue(request, "QUIZRUN");
                    SessionUltil.getInstance().removeValue(request, "SCORE");
                } else if (id != null && quizModel.getList().size() >= id + 1) {
                    QuizModel quizRunning = quizModel.getList().get(id);
                    request.setAttribute("QUIZRUN", quizRunning);
                }
            }
            view = "views/takequiz.jsp";

        } else {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }
        MessageUltil.showMessage(request);
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserModel userModel = (UserModel) SessionUltil.getInstance().getValue(request, "USERMODEL");
        if (userModel != null) {
            List<QuizModel> listQuiz = (List<QuizModel>) SessionUltil.getInstance().getValue(request, "QUIZ");
            if (request.getParameterMap().containsKey("number") && listQuiz == null) {
                int numbers;
                try {
                    // select number question
                    numbers = Integer.parseInt(request.getParameter("number"));
                    if (numbers <= 0) {
                        throw new Exception();
                    }
                    if (numbers > quizService.countAllQuiz()) {
                        response.sendRedirect(request.getContextPath() + "/takequiz?message=number_out_quiz&alert=danger");
                        return;
                    }
                } catch (Exception ex) {
                    response.sendRedirect(request.getContextPath() + "/takequiz?message=number_quiz_not_right&alert=danger");
                    return;
                }
                List<QuizModel> list = quizService.findByLimit(numbers);
                if (list != null) {
                    QuizModel quizModel = new QuizModel();
                    quizModel.setEndTime(System.currentTimeMillis() + numbers * 60000);
                    quizModel.setList(list);
                    SessionUltil.getInstance().pushValue(request, "QUIZMODEL", quizModel);
                    SessionUltil.getInstance().pushValue(request, "IDQUIZRUN", 0);
                }
            } else if (request.getParameterMap().containsKey("nextQuiz")) {
                Integer id = (Integer) SessionUltil.getInstance().getValue(request, "IDQUIZRUN");
                QuizModel quizModel = (QuizModel) SessionUltil.getInstance().getValue(request, "QUIZMODEL");
                if (id != null) {
                    QuizModel quizRunning = quizModel.getList().get(id);
                    if (quizRunning != null) {
                        if (!FormUltil.checkData(request, "answers")) {
                            response.sendRedirect(request.getContextPath() + "/takequiz?message=error_answers&alert=danger");
                            return;
                        }
                        String[] answers = request.getParameterValues("answers");
                        if (answers.length > 4 || answers.length <= 0) {
                            response.sendRedirect(request.getContextPath() + "/takequiz?message=error_answers&alert=danger");
                            return;
                        }
                        if (!FormUltil.isRightOptions(answers)) {
                            response.sendRedirect(request.getContextPath() + "/takequiz?message=error_answers_f12&alert=danger");
                            return;
                        }
                        String[] answerRight = quizModel.getList().get(id).getAnswers();
                        int rightExpect = 0;
                        // calculate sore
                        double rate = (double)10 / quizModel.getList().size();
                        System.out.println(quizModel.getList().size());
                        for (int i = 0; i < answerRight.length; i++) {
                            for (int j = 0; j < answers.length; j++) {
                                if (answerRight[i].trim().equalsIgnoreCase(answers[j].trim())) {
                                    rightExpect = rightExpect + 1;
                                }
                            }
                        }
                        double score = 0;
                        if (rightExpect == answers.length) {
                            score = rate;
                        } else {
                            score = (rate / 4) * rightExpect;
                        }
                        System.out.println(score);
                        quizModel.getList().get(id).setScore(score);
                    }
                    SessionUltil.getInstance().pushValue(request, "IDQUIZRUN", (id + 1));
                }

            }
            response.sendRedirect(request.getContextPath() + "/takequiz");
        } else {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }
    }

    public double getScore(List<QuizModel> list) {
        double score = 0;
        for (QuizModel quizModel : list) {
            score += quizModel.getScore();
        }
        return score;
    }
}
