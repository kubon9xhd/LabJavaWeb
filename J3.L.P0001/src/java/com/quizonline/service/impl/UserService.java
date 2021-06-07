/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.service.impl;

import com.quizonline.dao.IUserDAO;
import com.quizonline.dao.impl.UserDAO;
import com.quizonline.model.UserModel;
import com.quizonline.service.IUserService;
import java.sql.Timestamp;

/**
 *
 * @author asus
 */
public class UserService implements IUserService {

    private IUserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    @Override
    public UserModel findByUsernameAndPassword(String username, String password) {
        return userDAO.findByUsernameAndPassword(username, password);
    }

    @Override
    public UserModel findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public UserModel save(UserModel userModel) {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        userModel.setCreateDate(time);
        userModel.setCratedBy("");
        Long id = userDAO.save(userModel);
        return userDAO.findByUsernameAndPassword(userModel.getUsername(), userModel.getPassword());
    }


}
