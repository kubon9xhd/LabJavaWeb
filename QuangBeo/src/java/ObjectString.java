/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
public class ObjectString extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String text = "";
            if (request.getParameterMap().containsKey("text")) {
                text = request.getParameter("text");
                request.setAttribute("text", text);
                int totalString = text.length();
                request.setAttribute("total", totalString);
                int index;
                if (request.getParameterMap().containsKey("index")) {
                    try {
                        index = Integer.parseInt(request.getParameter("index"));
                        request.setAttribute("index", index);
                        request.setAttribute("charIndex", text.charAt(index));
                    } catch (Exception ex) {
                    }
                }
                if (request.getParameterMap().containsKey("string")) {
                    String str = request.getParameter("string");
                    request.setAttribute("string", str);
                    if (text.indexOf(str) >= 0) {
                        request.setAttribute("strIndex", text.indexOf(str));
                    }
                }
                if (request.getParameterMap().containsKey("indexFrom") && request.getParameterMap().containsKey("indexTo")) {
                    try {
                        int indexFr = Integer.parseInt(request.getParameter("indexFrom"));
                        int indexTo = Integer.parseInt(request.getParameter("indexTo"));
                        request.setAttribute("indexFr", indexFr);
                        request.setAttribute("indexTo", indexTo);
                        request.setAttribute("result", text.subSequence(indexFr, indexTo));
                    } catch (Exception ex) {
                    }
                }
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
