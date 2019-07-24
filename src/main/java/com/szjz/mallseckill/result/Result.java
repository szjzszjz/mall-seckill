package com.szjz.mallseckill.result;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.io.Serializable;

/**
 * author:szjz
 * date:2019/7/23
 */
@Data
public class Result implements Serializable {


    private static final long serialVersionUID = 715229965091701393L;
    /**
     * code
     */
    private Integer code;

    /**
     * msg
     */
    private String msg;

    /**
     * debug模式下, 同时返回错误堆栈
     */
    private String exMsg;

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
    public static Result error(String errorMsg) {
        return new Result(ResultEnum.SYSTEM_ERROR.getCode(), errorMsg);
    }
    /**
     * 系统错误
     */
    public static Result error() {
        return new Result(ResultEnum.SYSTEM_ERROR.getCode(), ResultEnum.SYSTEM_ERROR.getMsg());
    }


}
