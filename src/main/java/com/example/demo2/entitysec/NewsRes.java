package com.example.demo2.entitysec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRes extends JpaRepository<News,Long>{
    //@Query(nativeQuery = true,value = "select top:PageSize*  from News where  ID not in (select top:des ID  from News  order by date desc) order by date desc")
    //List<News> PageNews(@Param("PageSize")Long PageSize,@Param("des")Long des);


}
