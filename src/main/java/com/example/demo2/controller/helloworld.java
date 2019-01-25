package com.example.demo2.controller;


import com.example.demo2.entity.Banner;
import com.example.demo2.entity.TopicRes;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@RestController

public class helloworld {

    @Autowired
    private TopicRes topicRes;
    @Autowired
    @Qualifier("entityManagerPrimary")
    @PersistenceContext(name = "primaryPersistenceUnit")
    private   EntityManager entityManager;
    //@GetMapping("/hello")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){

    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
    String timeStr = sdf.format(currentTime);
   /*Session session= entityManager.unwrap(Session.class);

    return  (Banner)session.load("Banner",1);*/
    return  timeStr;
    }







}
