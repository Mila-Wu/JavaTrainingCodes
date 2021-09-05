package loadbyxml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class SchoolAop {

    //前置通知
    public void startTransaction(){
        System.out.println("    ====>2. Before student go to School, need to prepare the class contant for every class... "); //2
    }

    //后置通知
    public void commitTransaction(){
        System.out.println("    ====>4. After student go to School, every class begins as usual ... "); //4
    }

    //环绕通知
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("    ====>1. around begin go to school"); //1
        //调用process()方法才会真正的执行实际被代理的方法
        joinPoint.proceed();

        System.out.println("    ====>3. around finish go to school"); //3
    }
}
