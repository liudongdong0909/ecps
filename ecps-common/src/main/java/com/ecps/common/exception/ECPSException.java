package com.ecps.common.exception;

import com.ecps.common.bean.ECPSResult;
import com.ecps.common.bean.ValidatorResult;
import com.ecps.common.enums.ECPSStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * ECPS系统全局异常
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-13 上午 10:01
 */
@ControllerAdvice
public class ECPSException {

    public static final Logger logger = LoggerFactory.getLogger(ECPSException.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ECPSResult handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        logger.error("参数验证失败: ", exception);
        BindingResult bindingResult = exception.getBindingResult();

      /*  // 第一种:每次单个字段验证提示
        //String className = bindingResult.getObjectName();
        String field = bindingResult.getFieldError().getField();
        String message = bindingResult.getFieldError().getDefaultMessage();
        ValidatorResult result = new ValidatorResult(field, message);

        return ECPSResult.build(ECPSStatus.BAD_REQUEST_PARAMETER, result);*/

        //第二种: 一次多字段验证提示
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        List<ValidatorResult> results = new ArrayList<>();
        for (ObjectError error : allErrors) {
            //String className = error.getObjectName();
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            results.add(new ValidatorResult(field, message));
        }
        return ECPSResult.build(ECPSStatus.BAD_REQUEST_PARAMETER, results);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ECPSResult handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        logger.error("参数解析失败: ", exception);
        return ECPSResult.build(ECPSStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ECPSResult handleException(Exception exception) {
        logger.error("服务运行异常", exception);
        return ECPSResult.build(ECPSStatus.ERROR);
    }

}
