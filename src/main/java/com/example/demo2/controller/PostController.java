package com.example.demo2.controller;

import com.example.demo2.entity.PostRes;
import com.example.demo2.entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@EntityScan(basePackages = "com.example.demo2.entity")
public class PostController {
    @Autowired
    @Qualifier("entityManagerPrimary")
    @PersistenceContext(name = "primaryPersistenceUnit")///引入这个持久化单元
    private EntityManager entityManager;
    @Autowired
    private PostRes postRes;
   @GetMapping("/pagePost")
   @Transactional(value = "transactionManagerPrimary")
   public List<Posts> pagePost(@RequestParam("tid") Long tid,
                               @RequestParam(name="PageIndex",required=false,defaultValue="1") Long PageIndex)
    {
        List list=new ArrayList();
        Long PageSize= Long.valueOf(8);
        System.out.println("页数"+PageIndex);
        //直接映射成json输出
        //StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery("PagePosts",Posts.class );
        StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery("PagePosts");
        storedProcedureQuery.registerStoredProcedureParameter("tid",Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("PageSize",Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("PageIndex",Long.class, ParameterMode.IN);
        storedProcedureQuery.setParameter("tid",tid);
        storedProcedureQuery.setParameter("PageSize",PageSize);
        storedProcedureQuery.setParameter("PageIndex",PageIndex);
        storedProcedureQuery.execute();
        System.out.println( storedProcedureQuery.getResultList());
        return storedProcedureQuery.getResultList();
    }
    /*@GetMapping("/postslist")
    public List<Posts> postlist(@RequestParam("tid") Long tid,
                                @RequestParam(name="PageIndex",required=false,defaultValue="1") Long PageIndex){
       Long PageSzie= Long.valueOf(5);
        return postRes.PagePosts(tid);
    }*/
    @PostMapping("/addpost")
    @Transactional(value = "transactionManagerPrimary")
    public Integer addPost(@RequestBody Posts posts){
      System.out.println(posts.getTitle()+posts.getTid()+posts.getFid()+posts.getMessage()+posts.getBmdm()+posts.getBmmc());
        StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery("InsertPost");
        storedProcedureQuery.registerStoredProcedureParameter(0,Long.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(1,Long.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(8,String.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(9,Long.class,ParameterMode.IN);

        storedProcedureQuery.setParameter(0,posts.getFid());

        storedProcedureQuery.setParameter(1,posts.getTid());
        storedProcedureQuery.setParameter(2,posts.getPoster());
        storedProcedureQuery.setParameter(3,posts.getPosterid());
        storedProcedureQuery.setParameter(4,posts.getTitle());
        storedProcedureQuery.setParameter(5,posts.getMessage());
        storedProcedureQuery.setParameter(6,posts.getIp());
        storedProcedureQuery.setParameter(7,posts.getBmdm());
        storedProcedureQuery.setParameter(8,posts.getBmmc());
        storedProcedureQuery.setParameter(9,posts.getRole());

        storedProcedureQuery.execute();
         int i= storedProcedureQuery.getUpdateCount();


         return i;
    }

    @GetMapping("/postdelete")
    @Transactional(value = "transactionManagerPrimary")
    public Integer postdelete(@RequestParam("pid") Long pid,@RequestParam("tid") Long tid,@RequestParam("fid") Long fid){
        Long flag= Long.valueOf(0);
        System.out.println(pid);
        System.out.println(tid);
        System.out.println(fid);
        StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery("DeletePost");
        storedProcedureQuery.registerStoredProcedureParameter(0,Long.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(1,Long.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2,Long.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(3,Long.class,ParameterMode.IN);
        //storedProcedureQuery.registerStoredProcedureParameter(4,Long.class,ParameterMode.OUT);
        storedProcedureQuery.setParameter(0,pid);
        storedProcedureQuery.setParameter(1,flag);
        storedProcedureQuery.setParameter(2,tid);
        storedProcedureQuery.setParameter(3,fid);
        storedProcedureQuery.execute();
        //System.out.println(storedProcedureQuery.getParameter("return_value"));
        System.out.println(storedProcedureQuery.getUpdateCount());
        return  storedProcedureQuery.getUpdateCount();
    }
    @GetMapping("/oneMore")

    public List oneMore(@RequestParam("tid") Long tid){
        return postRes.oneMore(tid);
    }


    @GetMapping("/getMyPost")
    public List getMyPost(@RequestParam("gzh") Long gzh,@RequestParam(name="PageIndex",required=false,defaultValue="1") Long PageIndex){
        Long PageSize= Long.valueOf(10);
        StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery("pageMyPosts",Posts.class);
        storedProcedureQuery.registerStoredProcedureParameter(0,Long.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(1,Long.class,ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2,Long.class,ParameterMode.IN);

        storedProcedureQuery.setParameter(0,gzh);
        storedProcedureQuery.setParameter(1,PageSize);
        storedProcedureQuery.setParameter(2,PageIndex);

        storedProcedureQuery.execute();

       return storedProcedureQuery.getResultList();

    }

    @GetMapping("/getPostsCount")
    public Long getPostsCount(@RequestParam("gzh") String gzh){
        Long layer= Long.valueOf(0);
        Long display= Long.valueOf(0);
      return   postRes.countPostsByPosteridAndLayerNotAndDisplay(gzh,layer,display);
    }
}

