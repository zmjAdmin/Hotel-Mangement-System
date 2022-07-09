package com.ccu.server.common.utils.web;

import java.util.List;

public class PageEntity<E>{

    private List<E> list;
    private Long page;
    private Long total;

    public PageEntity() {
    }

    public PageEntity(List<E> data, Long page, Long total) {
        this.list = data;
        this.page = page;
        this.total = total;
    }

    public List<E> getData() {
        return list;
    }

    public void setData(List<E> data) {
        this.list = data;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageEntity{" +
                "list=" + list +
                ", page=" + page +
                ", total=" + total +
                '}';
    }
}
