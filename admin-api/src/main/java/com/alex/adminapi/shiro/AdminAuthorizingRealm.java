package com.alex.adminapi.shiro;

import com.alex.core.util.bcrypt.BCryptPasswordEncoder;
import com.alex.db.domain.LitemallAdmin;
import com.alex.db.service.LitemallAdminService;
import com.alex.db.service.LitemallPermissionService;
import com.alex.db.service.LitemallRoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;

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

    @Autowired
    private LitemallRoleService roleService;

    @Autowired
    private LitemallPermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if (principalCollection == null)
            throw new AuthorizationException("PrincipalCollection method argument cannot be null");
        LitemallAdmin admin = (LitemallAdmin) getAvailablePrincipal(principalCollection);
        Integer[] roleIds = admin.getRoleIds();
        Set<String> roles = roleService.queryByIds(roleIds);
        Set<String> permissions = permissionService.queryByRoleIds(roleIds);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = new String(token.getPassword());
        if (StringUtils.isEmpty(username))
            throw new AccountException("用户名不能为空");
        if (StringUtils.isEmpty(password))
            throw new AccountException("密码不能为空");
        List<LitemallAdmin> adminList = adminService.findAdmin(username);
        Assert.state(adminList.size() < 2, "同一个用户名存在两个账户");
        if (adminList.size() == 0)
            throw new UnknownAccountException("找不到用户（" + username + "）的账号信息");
        LitemallAdmin admin = adminList.get(0);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, admin.getPassword()))
            throw new UnknownAccountException("找不到用户（" + username + ")的账号信息");
        return new SimpleAuthenticationInfo(admin, password, getName());
    }
}
