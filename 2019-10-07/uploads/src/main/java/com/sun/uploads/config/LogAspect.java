package com.sun.uploads.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static com.sun.uploads.util.LogUtil.logToFile;

/**
 * @ClassName LogAspect
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-13
 * @Version V1.0
 **/
@Component
@Aspect
@Slf4j
public class LogAspect {

    /**
     * 日志切面
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(throwing = "ex", pointcut = "execution(* com.sun.uploads.*.*.*(..)))")
    public void logPoint(JoinPoint joinPoint, Throwable ex) {
        logToFile(joinPoint,ex);
    }


}
