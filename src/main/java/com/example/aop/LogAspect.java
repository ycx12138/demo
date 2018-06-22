package com.example.aop;

import com.example.model.message.MessageServer;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: ycx
 * @date: 2018/3/19 10:38
 * @description：
 */
@Slf4j
@Order(1)
//@Aspect
//@Component
public class LogAspect {
//    @Pointcut("execution(public * com.example.controller.*.*(..))")
//    @Pointcut("execution(public * com.example.controller.UserController+.*(..))")
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) ")
    public void webLog() {
    }

    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + String.valueOf(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("方法的返回值 : " + JSONArray.fromObject(ret));
    }

    //后置异常通知
    @AfterThrowing(throwing = "e", pointcut = "webLog()")
    public void throwss(JoinPoint joinPoint,Exception e,HttpServletRequest request) {
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + String.valueOf(joinPoint.getArgs()));
        log.info("方法异常时执行.....");
    }
    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("webLog()")
    public void after(JoinPoint jp) {
        log.info("方法最后执行.....");
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        log.info("方法环绕start.....");
        Object o = null;
        MessageServer messageServer;
        try {
            messageServer = (MessageServer)pjp.proceed();
            o = pjp.proceed();
            JSONObject jsonObject = JSONObject.fromObject(o);
            log.info("方法环绕proceed2，结果是 :" + jsonObject);
        } catch (JSONException e) {
            JSONArray jsonArray = JSONArray.fromObject(o);
            log.info("方法环绕proceed1，结果是 :" + jsonArray);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return o;
    }
}
