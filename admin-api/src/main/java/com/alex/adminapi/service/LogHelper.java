package com.alex.adminapi.service;

import com.alex.core.util.IpUtil;
import com.alex.db.domain.LitemallAdmin;
import com.alex.db.domain.LitemallLog;
import com.alex.db.service.LitemallLogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * 这里的日志设计成四种类型
 * 一般日志：用户觉得需要查看的一般操作日志，建议是默认级别
 * 安全日志：用户安全相关的操作日志，例如登录、删除管理员
 * 订单日志：用户交易相关的操作日志，例如订单发货、退款
 * 其他日志：如果以上日志不合适，可以选择其他日志，建议是优先级别最低的日志级别
 * @Author:     alex
 * @CreateDate: 2019/8/5 11:38
 * @Version:    1.0
 *
*/
@Component
public class LogHelper {

    public static final Integer LOG_TYPE_CENERAL = 0;

    public static final Integer LOG_TYPE_AUTH = 1;

    public static final Integer LOG_TYPE_ORDER = 2;

    public static final Integer LOG_TYPE_OTHER = 3;

    @Autowired
    private LitemallLogService logService;

    public void logGeneralSucceed(String action) {
        logAdmin(LOG_TYPE_CENERAL, action, true, "", "");
    }

    public void logGeneralSucceed(String action, String result) {
        logAdmin(LOG_TYPE_CENERAL, action, true, result, "");
    }

    public void logGeneralFail(String action, String error) {
        logAdmin(LOG_TYPE_CENERAL, action, false, error, "");
    }

    public void logAuthSucceed(String action) {
        logAdmin(LOG_TYPE_AUTH, action, true, "", "");
    }

    public void logAuthSucceed(String action, String result) {
        logAdmin(LOG_TYPE_AUTH, action, true, result, "");
    }

    public void logAuthFail(String action, String error) {
        logAdmin(LOG_TYPE_AUTH, action, false, error, "");
    }

    public void logOrderSucceed(String action) {
        logAdmin(LOG_TYPE_ORDER, action, true, "", "");
    }

    public void logOrderSucceed(String action, String result) {
        logAdmin(LOG_TYPE_ORDER, action, true, result, "");
    }

    public void logOrderFaul(String action, String error) {
        logAdmin(LOG_TYPE_ORDER, action, false, error, "");
    }

    public void logOtherSucceed(String action) {
        logAdmin(LOG_TYPE_OTHER, action, true, "", "");
    }

    public void logOtherSucceed(String action, String result) {
        logAdmin(LOG_TYPE_OTHER, action, true, result, "");
    }

    public void logOtherFail(String action, String error) {
        logAdmin(LOG_TYPE_OTHER, action, false, error, "");
    }

    public void logAdmin(Integer type, String action, Boolean succeed, String result, String comment) {
        LitemallLog log = new LitemallLog();
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser != null) {
            LitemallAdmin admin = (LitemallAdmin) currentUser.getPrincipal();
            if (admin != null)
                log.setAdmin(admin.getUsername());
            else
                log.setAdmin("匿名用户");
        } else
            log.setAdmin("匿名用户");
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        if (request != null)
            log.setIp(IpUtil.getIpAddr(request));
        log.setType(type);
        log.setAction(action);
        log.setStatus(succeed);
        log.setResult(result);
        log.setComment(comment);
        logService.add(log);
    }
}
