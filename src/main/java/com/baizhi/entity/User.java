package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable {

    private String id;

    private String photo;

    private String dharmaName;

    private String name;

    private Integer sex;

    private String privoince;

    private String city;

    private String sign;

    private String phoneNum;

    private String password;

    private String salt;

    private Date creatTime;

    private Integer status;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", photo='" + photo + '\'' +
                ", dharmaName='" + dharmaName + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", privoince='" + privoince + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", creatTime=" + creatTime +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(photo, user.photo) &&
                Objects.equals(dharmaName, user.dharmaName) &&
                Objects.equals(name, user.name) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(privoince, user.privoince) &&
                Objects.equals(city, user.city) &&
                Objects.equals(sign, user.sign) &&
                Objects.equals(phoneNum, user.phoneNum) &&
                Objects.equals(password, user.password) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(creatTime, user.creatTime) &&
                Objects.equals(status, user.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, photo, dharmaName, name, sex, privoince, city, sign, phoneNum, password, salt, creatTime, status);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDharmaName() {
        return dharmaName;
    }

    public void setDharmaName(String dharmaName) {
        this.dharmaName = dharmaName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPrivoince() {
        return privoince;
    }

    public void setPrivoince(String privoince) {
        this.privoince = privoince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User(String id, String photo, String dharmaName, String name, Integer sex, String privoince, String city, String sign, String phoneNum, String password, String salt, Date creatTime, Integer status) {
        this.id = id;
        this.photo = photo;
        this.dharmaName = dharmaName;
        this.name = name;
        this.sex = sex;
        this.privoince = privoince;
        this.city = city;
        this.sign = sign;
        this.phoneNum = phoneNum;
        this.password = password;
        this.salt = salt;
        this.creatTime = creatTime;
        this.status = status;
    }

    public User() {
    }
}
