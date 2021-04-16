package com.ligaofei.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
//告诉spring，这个一个切面类，里面可以定义切入点和通知
@Aspect
public class LogAdvice {


    //切入点表达式
    @Pointcut("execution(* com.ligaofei.service.VideoServiceImpl.*(..))")
    public void aspect(){

    }

    //前置通知
    @Before("aspect()")
    public void beforeLog(JoinPoint joinPoint){
        System.out.println("LogAdvice  beforeLog");
    }


    //后置通知
    @After("aspect()")
    public void afterLog(JoinPoint joinPoint){
        System.out.println("LogAdvice  afterLog");
    }

    /**
     * 环绕通知
     * @param joinPoint
     */
    @Around("aspect()")
    public void around(JoinPoint joinPoint){

        Object target = joinPoint.getTarget().getClass().getName();
        System.out.println("调用者="+target);

        //目标方法签名
        System.out.println("调用方法="+joinPoint.getSignature());

        //通过joinPoint获取参数
        Object [] args = joinPoint.getArgs();
        System.out.println("参数="+args[0]);

        long start = System.currentTimeMillis();
        System.out.println("环绕通知 环绕前=========");

        //执行连接点的方法
        try {
            ((ProceedingJoinPoint)joinPoint).proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("环绕通知 环绕后=========");

        System.out.println("调用方法总耗时 time = " + (end - start) +" ms");
    }
}
