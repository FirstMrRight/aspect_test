package org.liutx.aspect_demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Liutx
 * @date 2021/8/3 21:32
 * @Description
 */
@Aspect
@Component
public class SysLogAspect {
    @Pointcut("@annotation(org.liutx.aspect_demo.anno.SysLog)")
    public void logPointCut(){}

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        return result;
    }
}
