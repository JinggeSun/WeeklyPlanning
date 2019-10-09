package com.sun.shiro.shiro;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;


/**
 * @ClassName ShiroSessionManager
 * @Description: 自定义获取Token
 * @Author zcm
 * @Date 2019-10-08
 * @Version V1.0
 **/
public class ShiroSessionManager extends DefaultWebSessionManager {

    public ShiroSessionManager (){
        super();
        this.setDeleteInvalidSessions(true);
    }

    /**
     * 重写方法实现从请求头获取Token便于接口统一
     * 每次请求进来,Shiro会去从请求头找REQUEST_HEADER这个key对应的Value(Token)
     */
    @Override
    public Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String token = WebUtils.toHttp(request).getHeader(Constants.REQUEST_HEADER);

        // 如果请求头中存在token 则从请求头中获取token
        if ( StringUtils.isNotBlank( token ) ) {
            return token;

        } else {
            // 否则按默认规则从cookie取token
            return super.getSessionId(request, response);
        }
    }
}
