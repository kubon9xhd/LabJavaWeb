/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.dao;

import com.photo.model.ContactModel;

/**
 *
 * @author asus
 */
public interface IContactDAO extends GenericDAO<ContactModel>{
    ContactModel findContactModel();
}
