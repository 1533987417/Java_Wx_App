package com.example.demo2.entity;


import com.example.demo2.entity.Topics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;


import java.util.List;

public interface TopicRes extends JpaRepository<Topics,Long> {
  @Query(nativeQuery = true,value = "select * from topics where tid=?1")
  List<Topics> topicdetail(Long tid);
  Long countTopicsByBmdmAndDisplay(String bmdm,Long display);


}
