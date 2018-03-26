package com.example.aop;

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
@Order(1)
@Aspect
@Component
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
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + String.valueOf(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("方法的返回值 : " + JSONArray.fromObject(ret));
    }

    //后置异常通知
    @AfterThrowing(throwing = "e", pointcut = "webLog()")
    public void throwss(JoinPoint jp,Exception e) {
        System.out.println("方法异常时执行.....");
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("webLog()")
    public void after(JoinPoint jp) {
        System.out.println("方法最后执行.....");
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        System.out.println("方法环绕start.....");
        Object o = null;
        try {
            o = pjp.proceed();
            JSONObject jsonObject = JSONObject.fromObject(o);
            System.out.println("方法环绕proceed2，结果是 :" + jsonObject);
            return o;
        } catch (JSONException e) {
            JSONArray jsonArray = JSONArray.fromObject(o);
            System.out.println("方法环绕proceed1，结果是 :" + jsonArray);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
