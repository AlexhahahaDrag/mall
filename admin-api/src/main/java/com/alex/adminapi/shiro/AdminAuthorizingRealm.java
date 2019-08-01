package com.alex.adminapi.shiro;

import com.alex.db.service.LitemallAdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author:     alex
 * @CreateDate: 2019/7/31 16:48
 * @Version:    1.0
 *
*/
public class AdminAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private LitemallAdminService adminService;



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
