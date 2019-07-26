package com.szjz.mallseckill.controller;

import com.szjz.mallseckill.controller.abs.AbstractPasswordLoginController;
import com.szjz.mallseckill.entity.User;
import com.szjz.mallseckill.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * author:szjz
 * date:2019/7/24
 * web-end login controller
 */

@RequestMapping("/web")
@RestController
public class WebLoginController extends AbstractPasswordLoginController<User> {

    @RequestMapping(value = "/login")
    @ApiOperation(value = "管理后台登录", notes = "登录失败 data.isEnabledVerifyCode == true; 登录超时 result.code==3;", response = Result.class)
    public Result adminLogin(@RequestParam(required = false) String loginName,
                             @RequestParam(required = false) String phone,
                             @RequestParam String password,
                             @RequestParam(required = false) String verificationCode) {

        return super.login(loginName, password, verificationCode);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiOperation(value = "管理后台登出", notes = "登出时清空import表格", response = Result.class)
    public Result adminLogout() throws IOException {
        return super.logout();
    }

}
