/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.dao.impl;

import com.photo.dao.IContactDAO;
import com.photo.mapper.ContactMapper;
import com.photo.model.ContactModel;
import java.util.List;

/**
 *
 * @author asus
 */
public class ContactDAO extends AbstractDAO<ContactModel>implements IContactDAO{

    @Override
    public ContactModel findContactModel() {
        String sql = "Select * from [Contact]";
        List<ContactModel> listContact = query(sql, new ContactMapper());
        return listContact.isEmpty() ? null : listContact.get(0);
    }
    
}
