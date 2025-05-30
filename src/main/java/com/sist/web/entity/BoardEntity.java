package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "board")
@Data
@DynamicUpdate
public class BoardEntity {

  @Id
  private int no;
  private String name;
  private String subject;
  private String content;
  @Column(insertable = true, updatable = false)
  private String pwd;
  @Column(insertable = true, updatable = false)
  private String regdate;
  private int hit;

  @PrePersist
  public void regdate() {
    this.regdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }
}