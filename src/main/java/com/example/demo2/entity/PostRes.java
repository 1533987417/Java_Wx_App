package com.example.demo2.entity;

import com.example.demo2.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRes extends JpaRepository<Posts,Long> {


    @Query(nativeQuery = true,value = "SELECT top 1 * from posts where tid=?1 order by layer DESC")
    List oneMore(Long tid);

    Long countPostsByPosteridAndLayerNotAndDisplay(String gzh,Long layer,Long display);

}
