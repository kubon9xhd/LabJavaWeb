/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author asus
 * @param <T>
 */
public class AbstractModel<T> {

    private int id;
    private Timestamp createDate;
    private String cratedBy;

    public AbstractModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getCratedBy() {
        return cratedBy;
    }

    public void setCratedBy(String cratedBy) {
        this.cratedBy = cratedBy;
    }

    public String getDateConvertToString() {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String date = dateFormat1.format(this.createDate);
        return date;
    }
}
