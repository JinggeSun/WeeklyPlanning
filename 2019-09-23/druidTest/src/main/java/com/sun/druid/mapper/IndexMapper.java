package com.sun.druid.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
public interface IndexMapper {

    List<Map<String,Object>> getAllData();
}
