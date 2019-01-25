package com.example.demo2.controller;

import com.example.demo2.entity.Banner;
import com.example.demo2.entity.BannerRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BannerController {
    @Autowired
    private BannerRes bannerRes;

    private Banner banner;
/*
* 查询所有banber数据*/
    @GetMapping("/bannerlist")
    public List<Banner> bannerList(){
        return bannerRes.findAll();

    }

    /*
    *
    *
    * 添加banner数据*/
//    @GetMapping(value = "/banneradd")
    @PostMapping("/banneradd")
    public Banner bannerAdd(@RequestParam("figure") String figure,@RequestParam("title") String title){
       Banner banner=new Banner();

        banner.setFigure(figure);
        banner.setTitle(title);
        return bannerRes.save(banner);
    }

    @GetMapping(value = "/bannerone/{id}")
    public Optional<Banner> bannerone(@PathVariable("id") Long id){
        return bannerRes.findById(id);

    }

}
