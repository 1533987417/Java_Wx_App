package com.example.demo2.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "forums")
@Table(name = "forums")
/*@NamedStoredProcedureQuery(name = "GetForumInfoById", procedureName = "[yzukjc].[GetForumInfoById]", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "forums", type = Forums.class)

})*/
//@NamedNativeQueries(value = {@NamedNativeQuery(name="find",query= "select [name],parentid,topics,curtopics,posts,todayposts from forums where id =?1")})

@NamedStoredProcedureQuery(name = "GetForumInfoById", procedureName = "GetForumInfoById", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "fid", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "name", type = Forums.class) })

public class Forums {


  @Id
  private Long id;
  private Long parentid;
  private String name;
  private Long status;
  private Long displayorder;
  private Long topics;
  private Long curtopics;
  private Long posts;
  private Long todayposts;
  private Long lasttid;
  private String lasttitle;
  private java.sql.Timestamp lastpost;
  @Id
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getParentid() {
    return parentid;
  }

  public void setParentid(Long parentid) {
    this.parentid = parentid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public Long getDisplayorder() {
    return displayorder;
  }

  public void setDisplayorder(Long displayorder) {
    this.displayorder = displayorder;
  }

  public Long getTopics() {
    return topics;
  }

  public void setTopics(Long topics) {
    this.topics = topics;
  }

  public Long getCurtopics() {
    return curtopics;
  }

  public void setCurtopics(Long curtopics) {
    this.curtopics = curtopics;
  }

  public Long getPosts() {
    return posts;
  }

  public void setPosts(Long posts) {
    this.posts = posts;
  }

  public Long getTodayposts() {
    return todayposts;
  }

  public void setTodayposts(Long todayposts) {
    this.todayposts = todayposts;
  }

  public Long getLasttid() {
    return lasttid;
  }

  public void setLasttid(Long lasttid) {
    this.lasttid = lasttid;
  }

  public String getLasttitle() {
    return lasttitle;
  }

  public void setLasttitle(String lasttitle) {
    this.lasttitle = lasttitle;
  }

  public Timestamp getLastpost() {
    return lastpost;
  }

  public void setLastpost(Timestamp lastpost) {
    this.lastpost = lastpost;
  }

  public String getLastposterid() {
    return lastposterid;
  }

  public void setLastposterid(String lastposterid) {
    this.lastposterid = lastposterid;
  }

  public String getLastposter() {
    return lastposter;
  }

  public void setLastposter(String lastposter) {
    this.lastposter = lastposter;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  private String lastposterid;
  private String lastposter;
  private String icon;
  public Forums(){

  }

}
