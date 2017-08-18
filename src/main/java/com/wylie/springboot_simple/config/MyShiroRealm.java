package com.wylie.springboot_simple.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.wylie.springboot_simple.entity.Role;
import com.wylie.springboot_simple.entity.User;
import com.wylie.springboot_simple.services.UserService;
import com.wylie.springboot_simple.mapper.RoleMapper;

import java.util.List;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    
    @Resource
    private RoleMapper RoleMapper;
    
    /**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     * 至于doGetAuthorizationInfo()是权限控制，当访问到页面的时候，使用了相应的注解或者shiro标签才会执行此方法否则不会执行，所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可
     *
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*
         * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
         * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
         * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了，
         * 缓存过期之后会再次执行。
         */
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo  = (User)principals.getPrimaryPrincipal();
        //User userInfo = userService.findByUsername(username);
        List<Role> list = this.RoleMapper.getRoleList(userInfo.getId());
        for(Role role:list){
            authorizationInfo.addRole(role.getRolename());
            authorizationInfo.addStringPermissions(this.RoleMapper.getAuthorityList(role.getId()));
        }
        return authorizationInfo;
    }

    //主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User userInfo = userService.findByUsername(username);
        System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo.getUsername(), //用户名
                userInfo.getPassword(), //密码
                //ByteSource.Util.bytes(userInfo.getUsername()+userInfo.getSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

}