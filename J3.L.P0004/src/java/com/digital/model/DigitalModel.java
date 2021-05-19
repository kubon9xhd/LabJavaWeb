/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digital.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author asus
 */
public class DigitalModel {

    private int id;
    private String title;
    private String content;
    private String image;
    private String description;
    private String createdBy;
    private Date createdDate;
    private String dateConvert;
    private int totalPage;

    public DigitalModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDateConvert() {
        return dateConvert;
    }

    public void setDateConvert(String dateConvert) {
        this.dateConvert = dateConvert;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getDateConvertToString() {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMM dd yyyy - hh:mm:",Locale.ENGLISH);
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("a",Locale.ENGLISH); // get am or pm
        String date = dateFormat1.format(this.createdDate) + dateFormat2.format(this.createdDate).toLowerCase();
        return date;
    }
}
