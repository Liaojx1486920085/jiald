package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Menu implements Serializable {

    private String id;//主键

    private String title;//标题

    private String href;//跳转路径

    private String iconCls;//图标

    private String parentId;//所属父级菜单

    private List<Menu> menus;

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parentId='" + parentId + '\'' +
                ", menus=" + menus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(title, menu.title) &&
                Objects.equals(href, menu.href) &&
                Objects.equals(iconCls, menu.iconCls) &&
                Objects.equals(parentId, menu.parentId) &&
                Objects.equals(menus, menu.menus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, href, iconCls, parentId, menus);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu(String id, String title, String href, String iconCls, String parentId, List<Menu> menus) {
        this.id = id;
        this.title = title;
        this.href = href;
        this.iconCls = iconCls;
        this.parentId = parentId;
        this.menus = menus;
    }
}
