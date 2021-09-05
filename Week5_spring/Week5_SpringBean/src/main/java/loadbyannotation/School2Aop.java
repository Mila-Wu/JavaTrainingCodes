package loadbyannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class School2Aop {
    @Pointcut(value="execution(* loadbyannotation.aop.*.*(..))")
    public void point(){

    }

    @Before(value="point()")
    public void before(){
        System.out.println("    ====>22. Before student go to School, need to prepare the class contant for every class... "); //2
    }

    @AfterReturning(value = "point()")
    public void after(){
        System.out.println("    ====>44. After student go to School, every class begins as usual ... "); //4
    }

    @Around("point()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("    ====>11. around begin go to school"); //1
        //调用process()方法才会真正的执行实际被代理的方法
        joinPoint.proceed();

        System.out.println("    ====>33. around finish go to school"); //3

    }
}
