/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.controller;

import com.quizonline.model.QuizModel;
import com.quizonline.model.UserModel;
import com.quizonline.paging.PageRequest;
import com.quizonline.service.IQuizService;
import com.quizonline.service.impl.QuizService;
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
@WebServlet(urlPatterns = "/managequiz")
public class ManageController extends HttpServlet {

    IQuizService quizService;

    public ManageController() {
        quizService = new QuizService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserModel model = (UserModel) SessionUltil.getInstance().getValue(request, "USERMODEL");
            if (model == null) {
                response.sendRedirect(request.getContextPath() + "/home");
                return;
            }
            if (model.getRoleId() != 1) {
                response.sendRedirect(request.getContextPath() + "/home");
                return;
            }
            int index;
            if (!request.getParameterMap().containsKey("index")) {
                index = 1;
            } else {
                try {
                    index = Integer.parseInt(request.getParameter("index"));
                } catch (NumberFormatException ex) {
                    index = 1;
                }
            }
            int maxPage = 4;
            int totalItem = quizService.countByCreatedBy(model.getUsername());
            PageRequest page = new PageRequest(index, maxPage);
            int totalPage = (int) Math.ceil((double) totalItem / maxPage);
            List<QuizModel> listModel = quizService.findByOffset(model.getUsername(), page);
//            if (index > totalPage) {
//                response.sendRedirect(request.getContextPath() + "/managequiz");
//                return;
//            }
            request.setAttribute("totalItems", totalItem);
            request.setAttribute("listQuestion", listModel);
            request.setAttribute("totalPage", totalPage);
            RequestDispatcher rq = request.getRequestDispatcher("/views/managequiz.jsp");
            rq.forward(request, response);
        } catch (Exception e) {

        }
    }
}
