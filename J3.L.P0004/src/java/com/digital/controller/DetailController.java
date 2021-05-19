package com.digital.controller;

import com.digital.model.DigitalModel;
import com.digital.service.DigitalService;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/Detail"})
public class DetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Integer id = null;
            String view = "";
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (Exception ex) {
                view = "/view/Error.jsp";
            }
            DigitalModel topOne;
            List<DigitalModel> listTop5 = new ArrayList<>();
            DigitalService service = new DigitalService();

            topOne = service.findTopOne();
            listTop5 = service.findTopFive();
            if (topOne != null) {
                topOne.setDateConvert(topOne.getDateConvertToString());
                request.setAttribute("topOne", topOne);
                request.setAttribute("topFive", listTop5);
            }
            if (id != null) {
                DigitalModel model = service.findById(id);
                if (model != null) {
                    model.setDateConvert(model.getDateConvertToString());
                    view = "/view/Detail.jsp";
                    request.setAttribute("model",model);
                }
            }
            RequestDispatcher rq = request.getRequestDispatcher(view);
            rq.forward(request, response);

        } catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
