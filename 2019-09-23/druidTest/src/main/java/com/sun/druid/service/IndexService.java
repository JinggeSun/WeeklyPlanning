package com.sun.druid.service;

import com.sun.druid.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IndexService {

    @Autowired
    IndexMapper indexMapper;

    public List<Map<String,Object>> getAllData(){
        return indexMapper.getAllData();
    }

}
