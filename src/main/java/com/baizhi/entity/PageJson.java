package com.baizhi.entity;

import java.util.List;
import java.util.Objects;

public class PageJson {

    private List<Banner> rows;
    private Integer total;

    @Override
    public String toString() {
        return "PageJson{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageJson pageJson = (PageJson) o;
        return Objects.equals(rows, pageJson.rows) &&
                Objects.equals(total, pageJson.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, total);
    }

    public List<Banner> getRows() {
        return rows;
    }

    public void setRows(List<Banner> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public PageJson(List<Banner> rows, Integer total) {
        this.rows = rows;
        this.total = total;
    }

    public PageJson() {
    }
}
