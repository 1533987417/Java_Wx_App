package com.example.demo2.entity;

import com.example.demo2.entity.Forums;
import org.hibernate.result.Output;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.mapping.Alias;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.util.List;

@Repository
public interface ForumsRes extends JpaRepository<Forums,Long> {
    @Procedure(name = "GetForumInfoById")
    Forums GetForumInfoById(@Param("fid") Long fid);
   //@Procedure(name = "GetForumInfoById")
   //Forums GetForumInfoById(@Param("fid") Long fid);

    //@Query(value = "call find(?1)" ,nativeQuery = true)
    //Forums Find(Long id);
//    通过原生语句查询
    @Query(nativeQuery = true,value ="select * from Forums where id=?1")
    List<Forums> Find(Long id);

    @Query(nativeQuery = true,value = "exec GetForumInfoById @fid=?1 ")
    Forums Findagain(Long fid);



}
