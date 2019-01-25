package com.example.demo2.controllersec;

import com.example.demo2.entitysec.News;
import com.example.demo2.entitysec.NewsRes;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class NewsController {
    @Autowired
    private NewsRes newsRes;


    /*@GetMapping("/Top5News")
    public List<News> GetTop5News(){
        return newsRes.getTop5();
    }*/
    @GetMapping("/PageNews")
    public Page<News> pageNews(@PageableDefault(value = 10,sort = { "date" }, direction = Sort.Direction.DESC) Pageable pageable){

        return newsRes.findAll(pageable);
    }
    /*@GetMapping("/PageNews")
    public List<News> PageNews(@RequestParam(name="PageIndex",required=false,defaultValue="1")Long PageIndex){
        Long PageSize= Long.valueOf(10);
        Long des=(PageIndex-1)*PageSize;
        System.out.println(des);
        return
    }*/
}
