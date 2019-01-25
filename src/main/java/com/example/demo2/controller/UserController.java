package com.example.demo2.controller;

import com.example.demo2.entitysec.UserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EntityScan(basePackages = "com.example.demo2.entity")
public class UserController{
    @Autowired
    public UserRes userRes;
    @GetMapping("/getColleges")
    public List GetColleges(){
        Long gzh= Long.valueOf(2);
        return  userRes.GetCollege(gzh);

    }
    @GetMapping("/GetCollegeMember")
    public List GetCollegeMember(@RequestParam("College")String College){
        return userRes.GetCollegeMember(College);

    }
    @GetMapping("/getGetProfile")
    public List getGetProfile(@RequestParam("gzh")String gzh){
        return userRes.getGetProfile(gzh);
    }



}
