package com.sun.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.mp.entity.User;
import com.sun.mp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-08
 * @Version V1.0
 **/
@Service
public class UserService {

    @Autowired
    private
    UserMapper userMapper;

    public List<User> list(){
        return userMapper.selectList(null);
    }
}
