/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.paging;

/**
 *
 * @author asus
 */
public class PageRequest {

    private Integer page;
    private Integer maxPageItem;

    public PageRequest(Integer page, Integer maxPageItem) {
        this.page = page;
        this.maxPageItem = maxPageItem;
    }

    public Integer getPage() {
        if (this.page == null) {
            return 1;
        }
        return this.page;
    }

    public Integer getOffset() {
        if (this.page != null && this.maxPageItem != null) {
            return (this.page - 1) * this.maxPageItem;
        } else {
            return 0;
        }
    }

    public Integer getLimit() {
        if (this.maxPageItem == null) {
            return 4;
        }
        return this.maxPageItem;
    }
}
