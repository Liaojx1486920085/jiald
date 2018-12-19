package com.baizhi.asprects;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;


//SpringBootAOP(动态代理)配置类
@Aspect  //标注本类是一个切面类
@Configuration//自动装配以上注解
@Order(1)//该注释加在切面类上会改变切面类上3种通知的执行优先级，1最先执行，9最后执行,也可以加在方法上
public class MyAspect {
//
//    //前置通知注解
//    //前置通知与后置通知都有一个列表参数 JoinPoint :代表连接点，获得当前执行的方法对象，当前执行方法的参数
//    @Before("execution(* com.baizhi.ServiceImpl.*.*(..))")
//    public void before(JoinPoint joinPoint){
//        System.out.println("前置通知");
//        System.out.println("方法名称："+joinPoint.getSignature().getName());
//        Object[] args = joinPoint.getArgs();
//        for (Object arg : args) {
//            System.out.println(arg);
//        }
//        System.out.println("方法参数："+args);
//        System.out.println("目标对象："+joinPoint.getTarget());
//    }
//
//    //环绕通知注解
//    //ProceedingJoinPoint: 放行执行方法   获取当前方法的对象   方法的参数   目标方法的返回值   目标对象
//    @Around("execution(* com.baizhi.action.MenuAction.selectMenu(..))")
//    public Object arount (ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
//        System.out.println("环绕后通知");
//        Object proceed = proceedingJoinPoint.proceed();//方法放行
//        System.out.println("环绕后通知");
//        return proceed;
//
//    }
//    /*后置通知注意事项:
//    *  1.@After无论目标方法发生什么情况 ，@After后置通知都会执行，所以建议使用@AfterReturning”
//    * @AfterReturning，在目标方法发生异常的情况下不会进入该后置通知
//    * */
//    //后置通知注解
//    //@After
//    @AfterReturning("execution(* com.baizhi.ServiceImpl.*.*(..))")
//    public void afterll0(){
//        System.out.println("后置通知");
//    }
//
//    //3种通知执行完后执行
//    @AfterReturning(returning = "result" , pointcut = "execution(* com.baizhi.ServiceImpl.*.*(..))")
//    public void doAfterReturning(Object result){
//        System.out.println("该方法在在三种通知执行完之后才执行");
//    }
//
//    //这是在切入时，也就是在（动态代理）执行增加的切面（辅助功能）时报错时执行
//    @AfterThrowing(throwing = "e" ,pointcut = "execution(* com.baizhi.ServiceImpl.*.*(..))")
//    public void doAfterThrowing(Throwable e){
//        System.out.println("这是在切入时，也就是在AOP（动态代理）执行增加的切面（辅助功能）时报错时执行");
//        }
}
