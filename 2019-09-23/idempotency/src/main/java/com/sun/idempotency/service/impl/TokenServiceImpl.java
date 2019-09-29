package com.sun.idempotency.service.impl;

import com.sun.idempotency.common.Constant;
import com.sun.idempotency.common.ResponseCode;
import com.sun.idempotency.common.ServerResponse;
import com.sun.idempotency.exception.ServiceException;
import com.sun.idempotency.service.TokenService;
import com.sun.idempotency.util.RandomUtil;
import com.sun.idempotency.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TokenServiceImpl
 * @Description: token service 实现类
 * @Author zcm
 * @Date 2019-09-28
 * @Version V1.0
 **/
@Service
public class TokenServiceImpl implements TokenService {

    //key
    private static final String TOKEN = "token";

    @Autowired
    private
    RedisUtil redisUtil;

    @Override
    public ServerResponse createToken() {

        //创建token
        String str = RandomUtil.UUID32();
        //
        StrBuilder token = new StrBuilder();
        token.append(Constant.Redis.TOKEN_PREFIX).append(str);

        redisUtil.set(token.toString(), token.toString(), Constant.Redis.EXPIRE_TIME_MINUTE);

        return ServerResponse.success(token.toString());

    }

    @Override
    public void checkToken(HttpServletRequest request) {
        //获取token
        String token = request.getHeader(TOKEN);
        //判断token
        if (StringUtils.isBlank(token)){
            //从param中获取token
            token = request.getParameter(TOKEN);
            if (StringUtils.isBlank(token)){
                throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getMsg());
            }
        }
        //判断是否存在
        if (!redisUtil.exists(token)) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
        //删除
        Long del = redisUtil.del(token);
        if (del <= 0) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
    }
}
