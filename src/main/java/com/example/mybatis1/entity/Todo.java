package com.example.mybatis1.entity;

import lombok.*;

import java.time.*;

// Value Object : 값을 저장한 클래스
// Entity : DB 테이블과 동일하게 작성한 클래스

@Getter
@AllArgsConstructor
public class Todo {
  private int tno;
  private String title;
  private LocalDate regDate;
  private boolean finish;
}
