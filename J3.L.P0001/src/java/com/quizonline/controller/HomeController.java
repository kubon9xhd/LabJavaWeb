/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.controller;

import com.quizonline.model.UserModel;
import com.quizonline.service.IUserService;
import com.quizonline.service.impl.UserService;
import com.quizonline.utils.FormUltil;
import com.quizonline.utils.MessageUltil;
import com.quizonline.utils.SessionUltil;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/home", "/register", "/logout"})
public class HomeController extends HttpServlet {

    private IUserService userService;

    public HomeController() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserModel userModel = (UserModel) SessionUltil.getInstance().getValue(request, "USERMODEL");
        
        // get servlet path
        String url = request.getServletPath();
        String view = "views/home.jsp";
        if (url.equals("/register")) {
            view = "views/register.jsp";
        } else if (url.equals("/logout")) {
            SessionUltil.getInstance().removeValue(request, "USERMODEL");
            response.sendRedirect(request.getContextPath() + "/home?message=logout&alert=success");
            return;
        }else{
            if (userModel != null) {
            response.sendRedirect(request.getContextPath() + "/takequiz");
            return;
        }
        }
        MessageUltil.showMessage(request);
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = request.getServletPath();
        // map data with object
        UserModel userModel = FormUltil.toModel(request);
        if (url.equals("/register")) {
            String urlSend = "";
            if (userModel.getUsername().trim().isEmpty() || Character.isDigit(userModel.getUsername().charAt(0))) {
                urlSend = request.getContextPath() + "/register?message=register_fail&alert=danger";
            } else if (userModel.getPassword().trim().isEmpty() || userModel.getPassword().length() < 6) {
                urlSend = request.getContextPath() + "/register?message=register_fail&alert=danger";
            } else if (userModel.getRoleId() == null) {
                urlSend = request.getContextPath() + "/register?message=register_fail&alert=danger";
            } else if (userModel.getEmail() == null) {
                urlSend = request.getContextPath() + "/register?message=register_fail&alert=danger";
            } else {
                UserModel model = userService.findByUsername(userModel.getUsername());
                if (model == null) {
                    model = userService.save(userModel);
                    if (model != null) {
                        urlSend = request.getContextPath() + "/register?message=register_sucess&alert=success";
                    } else {
                        urlSend = request.getContextPath() + "/register?message=register_fail&alert=danger";
                    }
                } else {
                    urlSend = request.getContextPath() + "/register?message=username_password_exist&alert=danger";
                }
            }
            response.sendRedirect(urlSend);
        } else {
            String urlSend = "";
            if (userModel.getUsername().trim().isEmpty() || Character.isDigit(userModel.getUsername().charAt(0))) {
                urlSend = request.getContextPath() + "/home?message=login_fail&alert=danger";
            } else if (userModel.getPassword().trim().isEmpty() || userModel.getPassword().length() < 6) {
                urlSend = request.getContextPath() + "/home?message=login_fail&alert=danger";
            } else {
                UserModel model = userService.findByUsernameAndPassword(userModel.getUsername(), userModel.getPassword());
                if (model != null) {
                    SessionUltil.getInstance().pushValue(request, "USERMODEL", model);
                    urlSend = request.getContextPath() + "/home?message=login_sucess&alert=success";
                } else {
                    urlSend = request.getContextPath() + "/home?message=username_password_not_exist&alert=danger";
                }
            }
            response.sendRedirect(urlSend);
        }
    }
}
