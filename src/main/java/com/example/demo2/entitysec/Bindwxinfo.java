package com.example.demo2.entitysec;

import javax.persistence.*;

@Entity
@Table(name="bindxwinfo")
public class Bindwxinfo {


    @Id
    private String openid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Long getGzh() {
        return gzh;
    }

    public void setGzh(Long gzh) {
        this.gzh = gzh;
    }

    private Long gzh;
}
