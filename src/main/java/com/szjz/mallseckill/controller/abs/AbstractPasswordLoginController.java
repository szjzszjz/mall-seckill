package com.szjz.mallseckill.controller.abs;

import com.szjz.mallseckill.constant.ConstantI18NKey;
import com.szjz.mallseckill.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

/**
 * author:szjz
 * date:2019/7/24
 *
 * The parent class of use account and password to login
 */
public abstract class AbstractPasswordLoginController<T> extends AbstractLoginController<T>{

    protected Result login(String username,String password ,String verificationCode){
        Assert.isTrue(StringUtils.isBlank(username), ConstantI18NKey.auth_account_is_null);
        Assert.isTrue(StringUtils.isBlank(password), ConstantI18NKey.auth_password_is_null);


        return super.success();
    }
}
