/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.model;

/**
 *
 * @author asus
 */
public class RoleModel extends  AbstractModel<RoleModel>{
    private String name;

    public RoleModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
