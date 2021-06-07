/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.controller;

import com.photo.model.GalleryModel;
import com.photo.model.ImageModel;
import com.photo.paging.PageRequest;
import com.photo.service.IGalleryService;
import com.photo.service.IImageService;
import com.photo.service.impl.GalleryService;
import com.photo.service.impl.ImageService;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    public IGalleryService galleryService;
    public IImageService imageService;

    public HomeController() {
        galleryService = new GalleryService();
        imageService = new ImageService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int index = 1;
        if (request.getParameterMap().containsKey("index")) {
            try {
                index = Integer.parseInt(request.getParameter("index"));
            } catch (NumberFormatException ex) {
                index = 1;
            }
        }
        int maxPage = 3;
        int totalItem = galleryService.countAll();
        PageRequest page = new PageRequest(index, maxPage);
        int totalPage = (int) Math.ceil((double) totalItem / maxPage);
        if (totalPage > 0) {
            if (index > totalPage) {
                response.sendRedirect("home");
                return;
            }
        }
        List<GalleryModel> list = galleryService.findByOffset(page);
        request.setAttribute("list", list);
        for (GalleryModel galleryModel : list) {
            ImageModel imageModel =  imageService.findRandomImageByIdGallery(galleryModel.getId());
            if(imageModel != null){
                galleryModel.setUrl(imageModel.getUrl());
            }
        }
        request.setAttribute("totalPage", totalPage);
        RequestDispatcher rd = request.getRequestDispatcher("views/index.jsp");
        rd.forward(request, response);
    }
}
