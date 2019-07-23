package com.szjz.mallseckill.result;

import com.szjz.mallseckill.constant.ConstantI18NKey;
import lombok.Getter;

/**
 * author:szjz
 * date:2019/7/23
 */

@Getter
public enum  ResultEnum {
    /**
     * 操作成功
     */
    SUCCESS(0,ConstantI18NKey.base_action_success),
    /**
     * 操作失败. 不需要特殊处理，把错误显示出来即可。比如下单校验发现商品已下架，会提示"该商品已下架"
     */
    FAIL(1, ConstantI18NKey.base_action_fail),
    /**
     * 系统繁忙，请稍后重试
     */
    SYSTEM_ERROR(2, ConstantI18NKey.system_error),
    /**
     * 未登录/登录超时
     */
    SESSION_TIMEOUT(3, ConstantI18NKey.base_session_timeout),
    /**
     * 用户被禁用
     */
    AUTH_ACCOUNT_DISABLED(4, ConstantI18NKey.auth_account_disabled),
    /**
     * 权限不足
     */
    AUTH_ACCOUNT_FORBIDDEN(5, ConstantI18NKey.auth_account_forbidden),

    SYSTEM_USER_TYPE_ERROR(6, "登录用户类型错误"),

    ;


    /** code */
    private Integer code;
    /** msg */
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
