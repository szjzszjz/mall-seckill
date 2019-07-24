package com.szjz.mallseckill.context.exception;

import com.szjz.mallseckill.result.Result;
import com.szjz.mallseckill.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
@ResponseBody
public class DefaultExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result exception(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        Result result = null;
        if (ex instanceof BusinessException) {
            // 业务类型异常
//            BusinessException businessException = (BusinessException) ex;
//            Result result = businessException.getResult();
//            if (result == null) {
//                Object[] args = businessException.getArgs();
//                String errorMsg = BenmaI18NUtil.getMessage(businessException.getMessage(), args);
//                result = Result.fail(errorMsg);
//                if (configProperties.getApp().getIsDebug()) {
//                }
//            }
            result.setExMsg(CommonUtil.getStackTrace(ex));
            return result;
        } else if (ex instanceof IllegalArgumentException) {
            //Assert
            result = Result.error(ex.getMessage());
            result.setExMsg(CommonUtil.getStackTrace(ex));
            return result;
        } else {
            log.error("系统异常: " + ex.getMessage(), ex);
            result.setExMsg(CommonUtil.getStackTrace(ex));
            return Result.error();
        }
    }

}
