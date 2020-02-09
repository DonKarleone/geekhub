package com.geekhub.hw10.task2.model;

import java.util.List;

public class Page<T> {

    private List<T> items;
    private int page;
    private int pageSize;
    private int totalCountOfPages;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCountOfPages() {
        return totalCountOfPages;
    }

    public void setTotalCountOfPages(int totalCountOfPages) {
        this.totalCountOfPages = totalCountOfPages;
    }
}
