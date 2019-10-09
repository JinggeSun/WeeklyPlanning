package com.sun.shiro.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.shiro.entity.system.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UserMapper
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-08
 * @Version V1.0
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过账号查找用户信息
     *
     * @param username:
     * @return: User
     */
    User selectUserByUsername(@Param("username") String username);

}
