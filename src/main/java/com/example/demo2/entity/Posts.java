package com.example.demo2.entity;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Posts {


  @Id
  private Long pid;
  private Long fid;
  private Long tid;
  private Long layer;
  private String poster;
  private String posterid;
  private String title;
  private java.sql.Timestamp postdatetime;
  private String message;
  private String ip;
  private String bmdm;
  private String bmmc;
  private Long role;
  private Long display;
  private String category;
  private String classify;
 public Posts(){}
  public Long getPid() {
    return pid;
  }

  public void setPid(Long pid) {
    this.pid = pid;
  }

  public Long getFid() {
    return fid;
  }

  public void setFid(Long fid) {
    this.fid = fid;
  }

  public Long getTid() {
    return tid;
  }

  public void setTid(Long tid) {
    this.tid = tid;
  }

  public Long getLayer() {
    return layer;
  }

  public void setLayer(Long layer) {
    this.layer = layer;
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

  public java.sql.Timestamp getPostdatetime() {
    return postdatetime;
  }

  public void setPostdatetime(java.sql.Timestamp postdatetime) {
    this.postdatetime = postdatetime;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
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

  public Long getDisplay() {
    return display;
  }

  public void setDisplay(Long display) {
    this.display = display;
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
