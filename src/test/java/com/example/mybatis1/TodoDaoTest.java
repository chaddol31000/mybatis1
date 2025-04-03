package com.example.mybatis1;

import com.example.mybatis1.dao.*;
import com.example.mybatis1.entity.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.transaction.annotation.*;

// assertNotNull 메소드는 jupiter 로 불러와야함
import java.time.*;

import static org.junit.jupiter.api.Assertions.*;


// TodoDao 가 생성되고 동작하는 지를 확인 → 단위 테스트
// JUnit 은 스프링을 몰라 →스프링이 JUnit 을 어노테이션으로 지원
// JUnit 을 이용한 단위 테스트
@SpringBootTest
public class TodoDaoTest {
  @Autowired
  private TodoDao todoDao;

 // @Test
  public void initTest() {
    // assert 문을 사용하지만 junit 의 실행 결과는 무조건 성공으로 출력
    assertNotNull(todoDao);
  }

  // @Test
  public void findAllTest() {
    int size = todoDao.findAll().size();
    assertEquals(0, size);
  }

 @Test
  public void saveTest() {
    Todo todo = new Todo(0, "문학 야구장 가기", LocalDate.of(2025,4,5),false);
    int result = todoDao.save(todo);
    assertEquals(1, result);
  }
  // 실패하는 것도 테스트 하자
  @Test
  public void finishTest() {
    assertEquals(0, todoDao.finish(10));
    assertEquals(1, todoDao.finish(2));
  }
  // 테스트가 끝나고 작업을 취소, 지금같은 삭제가 취소됨
  @Transactional
  @Test
  public void deleteTest() {
    assertEquals(0, todoDao.delete(10));
    assertEquals(1, todoDao.delete(2));
  }
}


