package com.example.demo2.entity;

import com.example.demo2.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRes extends JpaRepository<Banner,Long>{

    Banner findByIdOrTitle(long id,String title);

}
