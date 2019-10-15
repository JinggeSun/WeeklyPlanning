package com.sun.uploads.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import java.time.LocalDate;
import java.util.Date;

/**
 * @ClassName LogUtil
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-13
 * @Version V1.0
 **/
@Slf4j
public class LogUtil {

    /**
     * 异常
     * @param ex
     */
    public static void logToFile(Exception ex){
        StackTraceElement stackTraceElement = ex.getStackTrace()[0];

        //出错的行数
        int lineNumber = stackTraceElement.getLineNumber();
        //类名
        String className = stackTraceElement.getClassName();
        //方法名
        String methodName = stackTraceElement.getMethodName();

        //调用日志
        log.error("方法:" + className + "." + methodName + " | " +
                "参数:" + stackTraceElement + " | " + "错误行：" + lineNumber + " | " +
                "时间:" + " | " + new Date() + " | " + "异常内容:" + ex.toString()
        );
    }

    public static void logToFile(JoinPoint joinPoint,Throwable throwable){
        int number = throwable.getStackTrace()[0].getLineNumber();
        Signature signature = joinPoint.getSignature();
        //参数
        Object[] args = joinPoint.getArgs();
        StringBuilder builder = new StringBuilder();
        if (args.length > 0){
            for (Object o : args){
                builder.append(o);
            }
        }

        log.error("方法:" + signature + " | " + "参数:" + builder.toString() +
                " | " + "错误行：" + number + " | " + "时间:" + new Date() +
                " | " + "异常内容:" + throwable.toString()
        );

    }

}
