package com.example.mybatis1.dao;

import com.example.mybatis1.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface DeptDao {
  @Select("select * from dept")
  public List<Dept> findAll();
}
