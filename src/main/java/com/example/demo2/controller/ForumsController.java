package com.example.demo2.controller;

import com.example.demo2.entity.Forums;
import com.example.demo2.entity.ForumsRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class ForumsController {
    @Autowired
    private ForumsRes forumsRes;


    @GetMapping("/forumList")
    public List<Forums> forumsList(){

        return forumsRes.findAll();
    }
    @GetMapping("/forumById/{id}")
    public void forumById(@PathVariable("id")Long id) throws SQLException {







    }
    @GetMapping("/forumByIdIpm/{id}")
    public Optional<Forums> forumByIdIpm(@PathVariable("id") Long id)
    {
        return forumsRes.findById(id);
    }
}
