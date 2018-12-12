package com.chen.exception;

import com.chen.common.JsonResult;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异常处理
 * <p>
 * @Author LeifChen
 * @Date 2018-12-11
 */
@RestControllerAdvice
public class MyExceptionHandler {

    private static final String ERROR_VIEW = "error";

    private final MappingJackson2HttpMessageConverter jsonConverter;

    public MyExceptionHandler(MappingJackson2HttpMessageConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    @ExceptionHandler(Exception.class)
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response,
                               Exception e) throws IOException {

        e.printStackTrace();

        if (isAjax(request)) {
            return JsonResult.error(e.getMessage());
        } else {
            ModelAndView mv = new ModelAndView();
            mv.addObject("url", request.getRequestURL());
            mv.addObject("exception", e);
            mv.setViewName(ERROR_VIEW);
            return mv;
        }
    }

    /**
     * 判断是否Ajax请求
     * @param request
     * @return
     */
    private static boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With")));
    }
}
