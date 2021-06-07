/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.service.impl;

import com.photo.dao.IContactDAO;
import com.photo.dao.impl.ContactDAO;
import com.photo.model.ContactModel;
import com.photo.service.IContactService;

/**
 *
 * @author asus
 */
public class ContactService implements IContactService{
    private IContactDAO contactDAO;

    public ContactService() {
        contactDAO = new ContactDAO();
    }
    
    @Override
    public ContactModel findContactModel() {
        return contactDAO.findContactModel();
    }
    
}
