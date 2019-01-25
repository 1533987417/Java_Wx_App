package com.example.demo2.entitysec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface BindRes extends JpaRepository<Bindwxinfo,String> {
    Bindwxinfo findBindwxinfoByOpenid(String openid);
}
