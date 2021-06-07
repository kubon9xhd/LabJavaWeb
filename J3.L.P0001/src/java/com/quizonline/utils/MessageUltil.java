/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.utils;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author asus
 */
public class MessageUltil {

    public static void showMessage(HttpServletRequest request) {
        String message = "";
        String alert = "";
        String messageResponse = "";
        if (request.getParameter("message") != null) {
            message = request.getParameter("message");
            if (message.equalsIgnoreCase("register_sucess")) {
                messageResponse = "Register done";
                alert = "success";
            } else if (message.equalsIgnoreCase("register_fail")) {
                messageResponse = "Register fail, Please check fields data";
                alert = "danger";
            } else if (message.equalsIgnoreCase("username_password_exist")) {
                messageResponse = "Register fail, Account exist";
                alert = "success";
            } else if (message.equalsIgnoreCase("login_fail")) {
                messageResponse = "Login fail, Please check fields data";
                alert = "danger";
            } else if (message.equalsIgnoreCase("login_sucess")) {
                messageResponse = "Login done";
                alert = "success";
            } else if (message.equalsIgnoreCase("username_password_not_exist")) {
                messageResponse = "Login fail, Account does not exist";
                alert = "danger";
            } else if (message.equalsIgnoreCase("logout")) {
                messageResponse = "Logout done";
                alert = "success";
            } else if (message.equalsIgnoreCase("error_option")) {
                messageResponse = "Please, enter input option is not empty";
                alert = "danger";
            } else if (message.equalsIgnoreCase("error_answers")) {
                messageResponse = "Please, chose least one answer";
                alert = "danger";
            } else if (message.equalsIgnoreCase("error_question")) {
                messageResponse = "Please, enter input question is not empty";
                alert = "danger";
            } else if (message.equalsIgnoreCase("error_answers_f12")) {
                messageResponse = "Please, don't edit value of options answer";
                alert = "danger";
            }else if (message.equalsIgnoreCase("insert_question_done")) {
                messageResponse = "Create new question done";
                alert = "success";
            }else if (message.equalsIgnoreCase("insert_question_fail")) {
                messageResponse = "Create new question fail";
                alert = "danger";
            }else if (message.equalsIgnoreCase("number_quiz_not_right")) {
                messageResponse = "Please, Enter number is positive number and more 0";
                alert = "danger";
            }else if (message.equalsIgnoreCase("number_out_quiz")) {
                messageResponse = "Please, Enter number less than amount quiz exist in system.";
                alert = "danger";
            }
            request.setAttribute("message", messageResponse);
            request.setAttribute("alert", alert);
        }
    }
}
