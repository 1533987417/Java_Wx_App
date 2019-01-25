package com.example.demo2.entity;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Banner")
@Table(name = "Banner")

public class Banner {
  @Id
  private long id;
  private String figure;
  private String title;
  public Banner(){}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getFigure() {
    return figure;
  }

  public void setFigure(String figure) {
    this.figure = figure;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
