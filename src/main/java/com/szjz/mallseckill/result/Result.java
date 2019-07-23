package com.szjz.mallseckill.result;

import org.springframework.data.domain.Page;

/**
 * author:szjz
 * date:2019/7/23
 */
public class Result {

    /**
     * code
     */
    private Integer code;

    /**
     * msg
     */
    private String msg;

    /**
     * data
     */
    private Object data;


    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 操作成功
     */
    public static Result success() {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg());
    }

    /**
     * 操作成功
     */
    public static Result success(Object data) {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 成功分页
     *
     * @return
     */
    public static Result success(Page page) {
        PageModel pageModel = PageModel.buildPage(page);
        return Result.success(pageModel);
    }

    /**
     * 操作失败
     */
    public static Result fail() {
        return new Result(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg());
    }

    /**
     * 操作失败
     */
    public static Result fail(Object data) {
        return new Result(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg(), data);
    }
    /**
     * 系统错误
     */
    public static Result error() {
        return new Result(ResultEnum.SYSTEM_ERROR.getCode(), ResultEnum.SYSTEM_ERROR.getMsg());
    }


}
