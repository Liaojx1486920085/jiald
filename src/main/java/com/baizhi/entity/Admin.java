package com.baizhi.entity;

import java.io.Serializable;
import java.util.Objects;

public class Admin implements Serializable {

    private String id;//管理员ID

    private String name;//账号

    private String password;//密码

    private String level;//权限

    private String logErroe;//d

    public Admin() {
    }

    public Admin(String id, String name, String password, String level, String logErroe) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.level = level;
        this.logErroe = logErroe;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", level='" + level + '\'' +
                ", logErroe='" + logErroe + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) &&
                Objects.equals(name, admin.name) &&
                Objects.equals(password, admin.password) &&
                Objects.equals(level, admin.level) &&
                Objects.equals(logErroe, admin.logErroe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, level, logErroe);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogErroe() {
        return logErroe;
    }

    public void setLogErroe(String logErroe) {
        this.logErroe = logErroe;
    }
}
