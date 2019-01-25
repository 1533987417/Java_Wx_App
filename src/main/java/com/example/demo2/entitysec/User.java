package com.example.demo2.entitysec;


import javax.persistence.*;

@Entity
@Table(name ="人员" )
public class User {

    @Id
    @Column(name = "工资号")
    private   Integer gzh ; //工资号
    @Column(name = "姓名")
    private    String xm ;//姓名
    @Column(name = "学院码")
    private   String bmdm ;//学院码
    @Column(name = "学院名")
    private   String bmmc ;//学院名称
    @Column(name = "bxy")
    private   int role ;//权限
    @Column(name = "头像")
    private   String headimg ;//头像


    public Integer getGzh() {
    return gzh;
}

    public void setGzh(Integer gzh) {
        this.gzh = gzh;
    }
    public User(){}



    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getBmdm() {
        return bmdm;
    }

    public void setBmdm(String bmdm) {
        this.bmdm = bmdm;
    }

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }
}
