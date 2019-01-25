package com.example.demo2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name="topics")
/*@NamedStoredProcedureQuery(name="PageTopics",procedureName = "PageTopics",parameters = {
        @StoredProcedureParameter(mode=ParameterMode.IN,type=Long.class,name ="fid"),
          },resultSetMappings = "mapping")
@SqlResultSetMapping(name = "mapping",classes = {
        @ConstructorResult(targetClass = Topics.class,columns = {
                @ColumnResult(name="rowId",type = Long.class),
                @ColumnResult(name="tid",type = Long.class),
                @ColumnResult(name="poster",type = String.class),
                @ColumnResult(name="posterid",type = Long.class),
                @ColumnResult(name="title",type = String.class),
                @ColumnResult(name="postdatetime",type = Date.class),
                @ColumnResult(name="lastpost",type = Date.class),
                @ColumnResult(name="lastpostid",type = Long.class),
                @ColumnResult(name="lastposter",type = String.class),
                @ColumnResult(name="lastposterid",type = Long.class),
                @ColumnResult(name="views",type = Long.class),
                @ColumnResult(name="replies",type = Long.class),
                @ColumnResult(name="category",type = String.class),
                @ColumnResult(name="classify",type = String.class),
        })
})
*/
/*@NamedStoredProcedureQuery(name = "PageTopics", procedureName = "PageTopics", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "fid", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "name", type = Topics.class) })/*/
public class Topics {


  @Id
  private Long tid;
  private Long fid;
  private String poster;
  private String posterid;
  private String title;

  //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
  //@JsonFormat(timezone = "yyyy-MM-dd HH:mm:ss")
  private String postdatetime;
  //@DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")
  private String lastpost;
  private Long lastpostid;
  private String lastposter;
  private String lastposterid;
  private Long views;
  private Long replies;
  private Long display;
  private String summary;
  private String figure;
  private String bmdm;
  private String bmmc;
  private Long role;
  private String category;
  private String classify;

  public Topics(){}
  public Long getTid() {
    return tid;
  }

  public void setTid(Long tid) {
    this.tid = tid;
  }

  public Long getFid() {
    return fid;
  }

  public void setFid(Long fid) {
    this.fid = fid;
  }

  public String getPoster() {
    return poster;
  }

  public void setPoster(String poster) {
    this.poster = poster;
  }

  public String getPosterid() {
    return posterid;
  }

  public void setPosterid(String posterid) {
    this.posterid = posterid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPostdatetime() {
    return postdatetime;
  }

  public void setPostdatetime(String postdatetime) {
    this.postdatetime = postdatetime;
  }

  public String getLastpost() {
    return lastpost;
  }

  public void setLastpost(String lastpost) {
    this.lastpost = lastpost;
  }

  public Long getLastpostid() {
    return lastpostid;
  }

  public void setLastpostid(Long lastpostid) {
    this.lastpostid = lastpostid;
  }

  public String getLastposter() {
    return lastposter;
  }

  public void setLastposter(String lastposter) {
    this.lastposter = lastposter;
  }

  public String getLastposterid() {
    return lastposterid;
  }

  public void setLastposterid(String lastposterid) {
    this.lastposterid = lastposterid;
  }

  public Long getViews() {
    return views;
  }

  public void setViews(Long views) {
    this.views = views;
  }

  public Long getReplies() {
    return replies;
  }

  public void setReplies(Long replies) {
    this.replies = replies;
  }

  public Long getDisplay() {
    return display;
  }

  public void setDisplay(Long display) {
    this.display = display;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getFigure() {
    return figure;
  }

  public void setFigure(String figure) {
    this.figure = figure;
  }

  public String getBmdm() {
    return bmdm;
  }

  public void setBmdm(String bmdm) {
    this.bmdm = bmdm;
  }

  public String getBmmc() {
    return bmmc;
  }

  public void setBmmc(String bmmc) {
    this.bmmc = bmmc;
  }

  public Long getRole() {
    return role;
  }

  public void setRole(Long role) {
    this.role = role;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getClassify() {
    return classify;
  }

  public void setClassify(String classify) {
    this.classify = classify;
  }
}
