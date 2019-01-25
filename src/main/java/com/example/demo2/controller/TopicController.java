package com.example.demo2.controller;



import com.example.demo2.entity.TopicRes;
import com.example.demo2.entity.Topics;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@RestController

@EntityScan(basePackages = "com.example.demo2.entity")
public class TopicController {

    @Autowired
    private TopicRes topicRes;


    @Autowired
    @Qualifier("entityManagerPrimary")
    @PersistenceContext(name = "primaryPersistenceUnit")///引入这个持久化单元
    private EntityManager entityManager;

/*
* Create Dynamic stored procedure
* 执行存储过程之一
* 问题，返回不是对象，是数组
*
*
* */
    @GetMapping("/pageTopic")
    public List<Topics> page1(@RequestParam("fid") Long fid,
                             @RequestParam(name="PageIndex",required=false,defaultValue="1") Long PageIndex,
                             @RequestParam(name="classify",required=false,defaultValue="") String classify,
                             @RequestParam(name="category",required=false,defaultValue="") String category,
                             @RequestParam(name="poster",required=false,defaultValue="") String poster,
                              @RequestParam(name="content",required=false,defaultValue="") String content){
        List<Topics> list=new ArrayList();
        Long PageSize= Long.valueOf(10);
        Long days = Long.valueOf(1000);
       //Session session= entityManager.unwrap(Session.class);

        StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery("PageTopics");
        storedProcedureQuery.registerStoredProcedureParameter(0,Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(1,Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2,Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(3,Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(4,String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(5,String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(6,String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(7,String.class, ParameterMode.IN);


        storedProcedureQuery.setParameter(0,fid);
        storedProcedureQuery.setParameter(1,PageSize);
        storedProcedureQuery.setParameter(2,PageIndex);
        storedProcedureQuery.setParameter(3,days);
        storedProcedureQuery.setParameter(4,classify);
        storedProcedureQuery.setParameter(5,category);
        storedProcedureQuery.setParameter(6,poster);
        storedProcedureQuery.setParameter(7,content);
        storedProcedureQuery.execute();
        list=storedProcedureQuery.getResultList();

        return  list;
    }

//查看帖子详细
    @GetMapping("/topicdetail")
     public List<Topics> topicdetail(@RequestParam("tid") Long tid){

        System.out.println(topicRes.topicdetail(tid));
        return topicRes.topicdetail(tid);
    }

//    查看个人帖子

    @GetMapping("/pageMyTopic")
    public List<Topics> page4(@RequestParam("gzh") String gzh,
                              @RequestParam(name="PageIndex",required=false,defaultValue="1") Long PageIndex)
    {
        List<Topics> list=new ArrayList();
        Long PageSize= Long.valueOf(10);

        StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery("PageMyTopics");
        storedProcedureQuery.registerStoredProcedureParameter(0,String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(1,Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2,Long.class, ParameterMode.IN);

        storedProcedureQuery.setParameter(0,gzh);
        storedProcedureQuery.setParameter(1,PageSize);
        storedProcedureQuery.setParameter(2,PageIndex);

        storedProcedureQuery.execute();
        list=storedProcedureQuery.getResultList();

        return  list;
    }
    @PostMapping("/addTopics")
    public Long addtopics(@RequestBody Topics topics,@RequestParam("ip") String ip)
    {
        System.out.println(topics.getSummary()+"kskadaskld");
        System.out.println(topics.getPoster()+"kskadaskld");
        System.out.println(topics.getTitle()+"kskadaskld");
        System.out.println(ip);
        StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery("InsertTopic");
        storedProcedureQuery.registerStoredProcedureParameter(0,Long.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(8,Long.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(9,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(10,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(11,Long.class,ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter(12,String.class,ParameterMode.IN);

        storedProcedureQuery.setParameter(0,topics.getFid());
        storedProcedureQuery.setParameter(1,topics.getPoster());
        storedProcedureQuery.setParameter(2,topics.getPosterid());
        storedProcedureQuery.setParameter(3,topics.getTitle());
        storedProcedureQuery.setParameter(4,topics.getSummary());
        storedProcedureQuery.setParameter(5,topics.getFigure());
        storedProcedureQuery.setParameter(6,topics.getBmdm());
        storedProcedureQuery.setParameter(7,topics.getBmmc());
        storedProcedureQuery.setParameter(8,topics.getRole());
        storedProcedureQuery.setParameter(9,topics.getCategory());
        storedProcedureQuery.setParameter(10,topics.getClassify());
        storedProcedureQuery.setParameter(12,ip);
        //storedProcedureQuery.registerStoredProcedureParameter(11,Long.class,ParameterMode.OUT);
        storedProcedureQuery.execute();


        return (Long) storedProcedureQuery.getOutputParameterValue(11);
    }
    @GetMapping("/Topten")
    public List<Topics> Topten(@RequestParam("fid")Long fid)
    {
        //List<Topics> list=new ArrayList();
        Long PageSize= Long.valueOf(10);

        StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery("TopicTopTen");
        storedProcedureQuery.registerStoredProcedureParameter(0,Long.class, ParameterMode.IN);
        storedProcedureQuery.setParameter(0,fid);
        storedProcedureQuery.execute();
        //list=;

        return  storedProcedureQuery.getResultList();
    }
    @GetMapping("/getMyCount")
    public Long getMyCount(@RequestParam("gzh")Long gzh){
        StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery("GetMyTopicCount");
        storedProcedureQuery.registerStoredProcedureParameter(0,Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(1,Long.class,ParameterMode.OUT);



        storedProcedureQuery.setParameter(0,gzh);
        storedProcedureQuery.execute();
        System.out.println(storedProcedureQuery.getOutputParameterValue(1));
        return (Long) storedProcedureQuery.getOutputParameterValue(1);


    }
    @GetMapping("/DeleteTopic")
    @Transactional(value = "transactionManagerPrimary")
    public Integer deleteTopic(@RequestParam("fid")Long fid,@RequestParam("tid")Long tid){

        StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery("DeleteTopic");
        storedProcedureQuery.registerStoredProcedureParameter(0,Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(1,Long.class,ParameterMode.IN);
        storedProcedureQuery.setParameter(0,tid);
        storedProcedureQuery.setParameter(1,fid);
        storedProcedureQuery.execute();
        System.out.println(storedProcedureQuery.getUpdateCount());

        return  storedProcedureQuery.getUpdateCount();
    }

    @GetMapping("/searchTopic")
    public List<Topics> searchTopic(@RequestParam(name="gzh",required=false,defaultValue="")String gzh,
                                    @RequestParam(name="bmdm",required=false,defaultValue="")String bmdm,
                                    @RequestParam(name="role")Long role,
                                    @RequestParam(name="PageIndex" ,required=false,defaultValue="")Long PageIndex,
                                    @RequestParam(name="orderfield")Long orderfield){
        Long PageSize= Long.valueOf(10);
        Long days= Long.valueOf(0);
        Long orderiction= Long.valueOf(0);
        StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery("SearchTopics");
        storedProcedureQuery.registerStoredProcedureParameter(0,String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(1,String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2,Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(3,Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(4,Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(5,Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(6,Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(7,Long.class, ParameterMode.IN);

        storedProcedureQuery.setParameter(0,gzh);
        storedProcedureQuery.setParameter(1,bmdm);
        storedProcedureQuery.setParameter(2,role);
        storedProcedureQuery.setParameter(3,PageSize);
        storedProcedureQuery.setParameter(4,PageIndex);
        storedProcedureQuery.setParameter(5,days);
        storedProcedureQuery.setParameter(6,orderfield);
        storedProcedureQuery.setParameter(7,orderiction);
        storedProcedureQuery.execute();
        return storedProcedureQuery.getResultList();
}
@GetMapping("/getCollegeTopics")
    public List getCollegeTopics(@RequestParam("bmdm")String bmdm,@RequestParam(name="PageIndex",required=false,defaultValue="1")Long PageIndex){
       Long PageSize= Long.valueOf(10);
       StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery("PageDepartmentTopics");
       storedProcedureQuery.registerStoredProcedureParameter(0,String.class,ParameterMode.IN);
       storedProcedureQuery.registerStoredProcedureParameter(1,Long.class,ParameterMode.IN);
       storedProcedureQuery.registerStoredProcedureParameter(2,Long.class,ParameterMode.IN);
       storedProcedureQuery.setParameter(0,bmdm);
       storedProcedureQuery.setParameter(1,PageSize);
       storedProcedureQuery.setParameter(2,PageIndex);
       storedProcedureQuery.execute();
       return storedProcedureQuery.getResultList();
}
@GetMapping("/getcollegeTopicsCount")
    public Long getCount(@RequestParam("bmdm")String bmdm){
        Long display= Long.valueOf(0);
       return topicRes.countTopicsByBmdmAndDisplay(bmdm,display);
}






}
