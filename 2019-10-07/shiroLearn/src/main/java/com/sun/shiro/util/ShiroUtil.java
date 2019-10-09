package com.sun.shiro.util;

import com.sun.shiro.entity.system.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.LogoutAware;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisSessionDAO;

import java.util.Collection;
import java.util.Objects;

/**
 * @ClassName ShiroUtil
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-08
 * @Version V1.0
 **/
public class ShiroUtil {

    // 私有构造器
    private ShiroUtil(){};

    private static RedisSessionDAO redisSessionDAO = SpringUtil.getBean(RedisSessionDAO.class);

    /**
     * 获取当前用户的session
     * @return SysUserEntity
     */
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 用户退出
     */
    public static void logout(){
        SecurityUtils.getSubject().logout();
    }

    /**
     * 获取当前用户信息
     * @return
     */
    public static User getUserInfo(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    public static void deleteCache(String username,boolean isRemoveSession){
        Session session = null;
        // 获取当前已登陆的用户session列表
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        // 遍历session，找到该用户名称对应的session
        User sysUserEntity = null;
        Object attribute = null;
        // 遍历Session,找到该用户名称对应的Session
        for(Session sessionInfo : sessions){
            attribute = sessionInfo.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (attribute == null) {
                continue;
            }
            sysUserEntity = (User) ((SimplePrincipalCollection) attribute).getPrimaryPrincipal();
            if (sysUserEntity == null) {
                continue;
            }
            if (Objects.equals(sysUserEntity.getUsername(), username)) {
                session=sessionInfo;
                // 清除该用户以前登录时保存的session，强制退出  -> 单用户登录处理
                if (isRemoveSession) {
                    redisSessionDAO.delete(session);
                }
            }
        }

        if (session == null||attribute == null) {
            return;
        }
        //删除session
        if (isRemoveSession) {
            redisSessionDAO.delete(session);
        }
        //删除Cache，再访问受限接口时会重新授权
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        Authenticator authc = securityManager.getAuthenticator();
        ((LogoutAware) authc).onLogout((SimplePrincipalCollection) attribute);
    }

    /**
     * 从缓存中获取指定用户名的Session
     * @param username
     */
    private static Session getSessionByUsername(String username){
        // 获取当前已登录的用户session列表
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        User user;
        Object attribute;
        // 遍历Session,找到该用户名称对应的Session
        for(Session session : sessions){
            attribute = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (attribute == null) {
                continue;
            }
            user = (User) ((SimplePrincipalCollection) attribute).getPrimaryPrincipal();
            if (user == null) {
                continue;
            }
            if (Objects.equals(user.getUsername(), username)) {
                return session;
            }
        }
        return null;
    }



}
