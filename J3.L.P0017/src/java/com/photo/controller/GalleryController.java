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
@WebServlet(urlPatterns = {"/gallery"})
public class GalleryController extends HttpServlet {

    private IGalleryService galleryService;
    private IImageService imageService;

    public GalleryController() {
        galleryService = new GalleryService();
        imageService = new ImageService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = null;
        if (request.getParameterMap().containsKey("id")) {
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException ex) {
                id = null;
            }
        }
        Integer index = 1;
        if (request.getParameterMap().containsKey("index")) {
            try {
                index = Integer.parseInt(request.getParameter("index"));
            } catch (NumberFormatException ex) {
                index = 1;
            }
        }
        Integer view = null;
        if (request.getParameterMap().containsKey("view")) {
            try {
                view = Integer.parseInt(request.getParameter("view"));
            } catch (Exception ex) {
                view = null;
            }
        }
        if (id == null) {
            response.sendRedirect("home");
            return;
        }
        GalleryModel galleryModel = galleryService.findById(id);
        if (galleryModel == null) {
            response.sendRedirect("home");
            return;
        }
        int maxPage = 8;
        int totalItem = imageService.countByIdGallery(id);
        PageRequest page = new PageRequest(index, maxPage);
        int totalPage = (int) Math.ceil((double) totalItem / maxPage);
        if (totalPage > 0) {
            if (index > totalPage) {
                response.sendRedirect("gallery?id=" + id);
                return;
            }
        }
        List<ImageModel> listImg = imageService.findOffSetByIdGallery(id, page);
        List<ImageModel> listImage = imageService.finfByIdGallery(id);
        if (listImage == null || listImg == null) {
            request.setAttribute("error", "Can not found image");
        } else {
            galleryModel.setListImages(listImage);
            request.setAttribute("modelGallery", galleryModel);
            request.setAttribute("modelPaging", listImg);
            request.setAttribute("idGallerry", id);
            request.setAttribute("totalPage", totalPage);
            if (view != null) {
                ImageModel modelView = new ImageModel();
                boolean check = false;
                Integer idBefore = null;
                Integer idAfter = null;
                for (int i = 0; i < listImage.size(); i++) {
                    if (view == listImage.get(i).getId()) {
                        modelView = listImage.get(i);
                        if (i > 0 && i < listImage.size() - 1) {
                            idBefore = listImage.get(i - 1).getId();
                            idAfter = listImage.get(i + 1).getId();
                        }
                        if (i == 0) {
                            idAfter = listImage.get(i + 1).getId();
                        }
                        if (i == listImage.size() - 1) {
                            idBefore = listImage.get(i - 1).getId();
                        }
                        check = true;
                        break;
                    }
                }
                if (check) {
                    request.setAttribute("viewImageModel", modelView);
                    request.setAttribute("idBefore", idBefore);
                    request.setAttribute("idAfter", idAfter);
                } else {
                    response.sendRedirect("gallery?id=" + id);
                    return;
                }
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("views/gallery.jsp");
        rd.forward(request, response);
    }
}
