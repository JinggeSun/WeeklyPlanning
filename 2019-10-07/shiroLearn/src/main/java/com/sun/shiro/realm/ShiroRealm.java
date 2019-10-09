package com.sun.shiro.realm;

import com.sun.shiro.entity.system.Menu;
import com.sun.shiro.entity.system.Role;
import com.sun.shiro.entity.system.User;
import com.sun.shiro.mapper.system.UserMapper;
import com.sun.shiro.util.ShiroUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName ShiroRealm
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-07
 * @Version V1.0
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;



    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //1. 获取前台传递过来的用户名和密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        String passWord = String.valueOf(token.getPassword());

        //2. 根据用户名查找数据库
        // 根据用户名从redis中取
        //实际项目中,这里可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        User user = userMapper.selectUserByUsername(userName);

        // 判断账号是否存在
        if (user == null) {
            //返回null -> shiro就会知道这是用户不存在的异常
            return null;
        }
        // 验证密码 【注：这里不采用shiro自身密码验证 ， 采用的话会导致用户登录密码错误时，已登录的账号也会自动下线！  如果采用，移除下面的清除缓存到登录处 处理】
        if ( !passWord.equals( user.getPwd() ) ){
            throw new IncorrectCredentialsException("用户名或者密码错误");
        }

        // 判断账号是否被冻结
        if (user.getFlag()==null|| "0".equals(user.getFlag())){
            throw new LockedAccountException();
        }

        /**
         * 进行验证 -> 注：shiro会自动验证密码
         * 参数1：principal -> 放对象就可以在页面任意地方拿到该对象里面的值
         * 参数2：hashedCredentials -> 密码
         * 参数3：credentialsSalt -> 设置盐值
         * 参数4：realmName -> 自定义的Realm
         */
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        // 验证成功开始踢人(清除缓存和Session)
        ShiroUtil.deleteCache(userName,true);

        // 认证成功后更新token
        String tokenStr = ShiroUtil.getSession().getId().toString();
        user.setToken( tokenStr );
        userMapper.updateById(user);
        return authenticationInfo;
    }


    /**
     * 赋予角色和权限:用户进行权限验证时 Shiro会去缓存中找,如果查不到数据,会执行这个方法去查权限,并放入缓存中
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        // 拿到用户信息
        User user = (User) principalCollection.getPrimaryPrincipal();
        Integer userId = user.getId();

        Set<String> roleSet = new HashSet<String>();
        Set<String> menuSet = new HashSet<String>();

        // 根据用户ID查找用户角色
        List<Role> roleList = roleMapper.selectRoleByUserId( userId );

        // 遍历角色，添加菜单
        for (Role role : roleList){
            roleSet.add(role.getCode());
            List<Menu> menuList = menuMapper.selectMenuByRoleId( role.getId() );
            for (Menu menu :menuList) {
                menuSet.add( menu.getResources() );
            }
        }

        authorizationInfo.setStringPermissions(menuSet);
        authorizationInfo.setRoles(roleSet);
        return authorizationInfo;
    }


}
