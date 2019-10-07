package com.sun.swagger.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IndexService
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-07
 * @Version V1.0
 **/
@Service
public class IndexService {

    static List<String> strList = new ArrayList<>();

    static {
        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");
        strList.add("e");
    }

    public List<String> list(){
        return strList;
    }

    public String getStr(int index){
        return strList.get(index);
    }

    public int addStr(String str){
        strList.add(str);
        return strList.size()-1;
    }

    public void delete(int index){
        strList.remove(index);
    }

    public void update(int index,String msg){
        strList.remove(index);
        strList.add(index,msg);
    }
}
