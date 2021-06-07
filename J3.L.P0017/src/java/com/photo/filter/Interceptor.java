/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.filter;

import com.photo.model.ContactModel;
import com.photo.model.GalleryModel;
import com.photo.service.IContactService;
import com.photo.service.IGalleryService;
import com.photo.service.impl.ContactService;
import com.photo.service.impl.GalleryService;
import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author asus
 */
public class Interceptor implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        IContactService contactService = new ContactService();
        ContactModel contactModel = contactService.findContactModel();
        IGalleryService galleryService = new GalleryService();
        List<GalleryModel> galleryModels = galleryService.findTop3Random();
        if(!galleryModels.isEmpty()){
            request.setAttribute("galleryHeader", galleryModels);
        }
        if (contactModel != null) {
            request.setAttribute("contact", contactModel);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
