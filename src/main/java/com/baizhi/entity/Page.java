package com.baizhi.entity;

public class Page {
    //传参的页数
    private int pageIndex;
    //可更改的每页行数
    private int pageSize;
    //总条数
    private int totalCount;
    //总页数
    private int pageCount;

    public Page() {
        this.pageSize = pageSize;
    }

    public Page(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getFirstResult() {
        //根据页数与每页行数计算出其中某一页在表中的起始行数下标
        return (pageIndex - 1) * pageSize + 1;
    }

    public int getLastResult() {
        //根据页数与没页行数计算出其中某一页在表中的末尾行数下标
        return pageIndex * pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.pageCount = (totalCount / pageSize == 0) ? totalCount / pageSize : totalCount / pageSize + 1;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


}
