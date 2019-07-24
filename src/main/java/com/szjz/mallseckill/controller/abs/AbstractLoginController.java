package com.szjz.mallseckill.controller.abs;

import com.szjz.mallseckill.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.io.IOException;

/**
 * author:szjz
 * date:2019/7/24
 * The parent of all controllers about login
 */
@Slf4j
public abstract class AbstractLoginController<T> extends AbstractController<T> {

    protected Result logout() throws IOException {
        // 退出后session, 获取国际化文本会导致org.apache.shiro.session.UnknownSessionException异常
        // 所以提前获取result. 这是个Bug
        Result result = super.success();

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
        } catch (Exception e) {
            log.debug("Encountered session exception during logout.  This can generally safely be ignored.", e);
        }
        return result;
    }
}
