package com.alex.adminapi.util;

import com.alex.adminapi.annotation.RequiresPermissionsDesc;
import org.apache.shiro.authz.annotation.RequiresPermissions;

/**
 * @Description:
 * @Author:     alex
 * @CreateDate: 2019/8/5 14:36
 * @Version:    1.0
 *
*/
public class Permission {

    private RequiresPermissions requiresPermissions;

    private RequiresPermissionsDesc requiresPermissionsDesc;

    private String api;

    public RequiresPermissions getRequiresPermissions() {
        return requiresPermissions;
    }

    public void setRequiresPermissions(RequiresPermissions requiresPermissions) {
        this.requiresPermissions = requiresPermissions;
    }

    public RequiresPermissionsDesc getRequiresPermissionsDesc() {
        return requiresPermissionsDesc;
    }

    public void setRequiresPermissionsDesc(RequiresPermissionsDesc requiresPermissionsDesc) {
        this.requiresPermissionsDesc = requiresPermissionsDesc;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
