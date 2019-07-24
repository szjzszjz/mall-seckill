package com.szjz.mallseckill.controller;

import com.szjz.mallseckill.controller.abs.AbstractController;
import com.szjz.mallseckill.controller.abs.AbstractPasswordLoginController;
import com.szjz.mallseckill.entity.User;
import com.szjz.mallseckill.integration.redis.RedisService;
import com.szjz.mallseckill.integration.redis.keys.UserKey;
import com.szjz.mallseckill.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * author:szjz
 * date:2019/7/24
 */
@RequestMapping("/redis")
@RestController
public class RedisTestController extends AbstractController {

    @Autowired
    private RedisService redisService;

    @ApiOperation(value = "测试Redis添加缓存",notes = "",response = Result.class)
    @PostMapping(value = {"/set/{id}/{name}/{expire}", "/set/{id}/{name}"})
    public Result set(@PathVariable Long id,
                      @PathVariable String name,
                      @PathVariable(required = false) Integer expire) {
        User user = new User(id, name);
        Boolean res = redisService.set(UserKey.getById, id + "", user,expire);
        return success(res);
    }

    @ApiOperation(value = "测试Redis获取缓存",notes = "",response = Result.class)
    @GetMapping("/get/{id}")
    public Result get(@PathVariable Long id) {
        User user = redisService.get(UserKey.getById, id + "", User.class);
        return success(user);
    }
}
