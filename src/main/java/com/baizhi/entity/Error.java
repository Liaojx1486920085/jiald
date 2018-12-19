package com.baizhi.entity;


import java.util.Objects;

//错误页提示信息类
public class Error {

    private String errorid;//错误ID

    private String text;//错误信息

    public Error() {
    }

    public Error(String errorid, String text) {
        this.errorid = errorid;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Error{" +
                "errorid='" + errorid + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Error error = (Error) o;
        return Objects.equals(errorid, error.errorid) &&
                Objects.equals(text, error.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorid, text);
    }

    public String getErrorid() {
        return errorid;
    }

    public void setErrorid(String errorid) {
        this.errorid = errorid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
