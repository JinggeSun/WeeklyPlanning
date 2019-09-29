package com.sun.idempotency.service;

import com.sun.deploy.net.HttpResponse;
import com.sun.idempotency.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TokenService
 * @Description: token接口，代码样例中使用接口编程，这里也使用接口编程
 * @Author zcm
 * @Date 2019-09-28
 * @Version V1.0
 **/
public interface TokenService {

    /**
     * 创建token
     * @return
     */
    ServerResponse createToken();

    /**
     * 验证token
     * @param request
     */
    void checkToken(HttpServletRequest request);

}
