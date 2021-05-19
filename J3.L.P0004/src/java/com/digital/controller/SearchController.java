/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digital.controller;

import com.digital.model.DigitalModel;
import com.digital.paging.PageRequest;
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
@WebServlet(urlPatterns = {"/Search"})
public class SearchController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String txt = "";
            txt = request.getParameter("txtSearch");

            int index = 1;
            try {
                index = Integer.parseInt(request.getParameter("index"));
            } catch (Exception ex) {
//                ex.printStackTrace();
                index = 1;
            }
            DigitalService service = new DigitalService();
            int maxPage = 3;
            int totalItem = service.countDigitalByTitle(txt);
            PageRequest page = new PageRequest(index, maxPage);
            int totalPage = (int) Math.ceil((double) totalItem / maxPage);
            List<DigitalModel> listModel = service.findByTitle(txt, page);
            if (index > totalPage) {
                request.setAttribute("errorPage", "Can not found page");
            }
            request.setAttribute("list", listModel);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("txtSearch", txt);
            DigitalModel topOne;
            List<DigitalModel> listTop5 = new ArrayList<>();
            topOne = service.findTopOne();
            listTop5 = service.findTopFive();
            if (topOne != null) {
                topOne.setDateConvert(topOne.getDateConvertToString());
                request.setAttribute("topOne", topOne);
                request.setAttribute("topFive", listTop5);
            }
            RequestDispatcher rq = request.getRequestDispatcher("/view/Search.jsp");
            rq.forward(request, response);
        } catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
