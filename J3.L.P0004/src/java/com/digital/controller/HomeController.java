/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author asus
 */
@WebServlet(urlPatterns = {"/Home"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // call to service do work logic
            DigitalService service = new DigitalService();
            // select top 5 recent news
            List<DigitalModel> topFive = service.findTopFive();
            // select top 1 recent news
            DigitalModel topOne = service.findTopOne();
            // check if has top one news
            if (topOne != null) {
                request.setAttribute("topOne", topOne);
                request.setAttribute("topFive", topFive);
                RequestDispatcher rd = request.getRequestDispatcher("view/Home.jsp");
                rd.forward(request, response);
            }
        } catch (Exception ex) {

        }
    }

}
