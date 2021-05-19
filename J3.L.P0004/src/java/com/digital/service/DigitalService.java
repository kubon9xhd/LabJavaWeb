/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digital.service;

import com.digital.dao.DigitalDAO;
import com.digital.model.DigitalModel;
import com.digital.paging.PageRequest;
import java.util.List;

/**
 *
 * @author asus
 */
public class DigitalService {

    DigitalDAO digitalDAO;

    public DigitalService() {
        digitalDAO = new DigitalDAO();
    }

    public DigitalModel findById(Integer id) {
        return digitalDAO.findById(id);
    }

    public DigitalModel findTopOne() {
        return digitalDAO.findTopOne();
    }
    public List<DigitalModel> findTopFive() {
        return digitalDAO.findTopFive();
    }
    public int countDigitalByTitle(String title){
        return digitalDAO.countByTitle(title);
    }
    public List<DigitalModel> findByTitle(String title,PageRequest page) {
        return digitalDAO.findByTitle(title, page);
    }
}
