package org.sean.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.sean.anno.Logger;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 此处描述一下AOP的具体含义：就是增强方法增强了哪些对象中的哪些方法，即动态代理。
 * 当然，aop的增强对象必须放在spring容器中才能使用，它帮我们实现了动态代理的自动选择，也可以维护到ioc中。
 * 相当于一个高级的动态代理工具。
 * <p>
 * 遇到Aop大家都会提一句OOP，只是字比较像而已，OOP是面向对象，在此基础上用动态代理可以面向切面，仅此而已。
 * <p>
 * 用法：1导入aspectj的weaver的包，导入aop-spring的，2然后开启aspectj注解配置，3在切面中写切面类即可。
 * <p>
 * Aop一共有以下几个概念：
 * 切面：Aspect->这个概念代表这个切面类要对一系列方法进行增强，所以要在切面类中定义切面方法（通知，增强方法），切面类可被定义为
 * AspectJ
 * <p>
 * 切点：PointCut->指的是需要切哪些连接点，表示切点方法的pattern，灵活的控制切哪里
 * <p>
 * <p>
 * 连接点：JointPoint->切面与普通顺序执行的方法通过解读切点实际切到的点叫连接点，连接点中有所有被切方法的反射参数。
 * ps：spring维护了以连接点为中心的拦截器链。这是连接点的实现方式。
 * <p>
 * <p>
 * 通知：Advice，增强方法，其实就是代理方法中代理处理的部分，也就是那些动作，before，after，after exception。
 * 比如抛出异常了，告诉你，你要怎么办，这就是通知。
 * <p>
 * ----------------------------------------------------------------------------------------
 * 以下属于运行时概念：
 * <p>
 * 织入：weaving->运行时对切面处理逻辑，将切面切中的被通知类的代理给创建出来。
 * 代理类是在内存中生成的，直接到了元空间
 * <p>
 * 目标对象：targetObject->被一个或多个切面通知的对象，也就是adviced对象，它是被代理的对象。
 * <p>
 * 引入：Introduction。声明额外的方法或字段，spring支持将新的接口以及其方法引入到被通知的对象上。
 */
@Aspect
//必须将切面放到ioc容器当中
@Component
//启动aop
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
public class SeanAspect {
    /**
     * 注意此处的用法，下面列举一些，具体看spring-doc的aop.md
     * 带？可不写， * 代表可以是所有， ..代表所有子孙包
     * execution(<访问修饰符>？<返回类型*，jdk的String不用写完整限定名，自定义的得写> <包名 ..* >？<类名 *></><方法名 *> (<参数 ..>)<异常 throw?>?)
     * execution(* com.sample.service.impl..*.*(..))
     * <p>
     * example:
     * 通过方法名定义切点:
     * execution(public * *(..)) 匹配所有目标类的public方法，第一个代表方法返回值类型，第二个代表方法名，而".."代表任意入参的方法；
     * execution(* *To(..)) 匹配目标类所有以To为后缀的方法。第一个“*”代表任意方法返回类型，而“*To”代表任意以To结尾的方法名。
     * <p>
     * 通过类定义切点:
     * execution(* com.taotao.Waiter.*(..)) 匹配Waiter接口的所有方法，第一个“*”代表任意返回类型，“com.taotao.Waiter.”代表Waiter接口中的所有方法。
     * execution(* com.taotao.Waiter+.*(..)) 匹配Waiter接口及其所有实现类的方法
     * <p>
     * 通过包名定义切点:
     * 注意：在包名模式串中，"."表示包下的所有类，而“..**”表示包、子孙包下的所有类。
     * <p>
     * execution(* com.taotao.*(..)) 匹配com.taotao包下所有类的所有方法
     * execution(* com.taotao..*(..)) 匹配com.taotao包及其子孙包下所有类的所有方法，如com.taotao.user.dao,com.taotao.user.service等包下的所有类的所有方法。
     * execution(* com..*.*Dao.find*(..)) 匹配以com开头的任何包名下后缀为Dao的类，并且方法名以find为前缀，如com.taotao.UserDao#findByUserId()、com.taotao.dao.ForumDao#findById()的方法都是匹配切点。
     * <p>
     * 通过方法入参定义切点,(..)即可，有些细节了 execution(* joke(String, ..))
     * <p>
     * // 匹配指定包中的所有方法
     * execution(* com.xys.service.*(..))
     * <p>
     * // 匹配当前包中的所有public方法
     * execution(public * UserService.*(..))
     * <p>
     * // 匹配指定包中的所有public方法，并且返回值是int类型的方法
     * execution(public int com.xys.service.*(..))
     * <p>
     * // 匹配指定包中的所有public方法，并且第一个参数是String，返回值是int类型的方法
     * execution(public int com.xys.service.*(String name, ..))
     * <p>
     * 1:访问修饰符* /public void /public static void/
     * 2:包路径 org.sean..表示当前包及子包
     * 3:类名 org.sean..*表示包下的类名
     * 4:方法 org.sean..*.* 最后一个.*表示方法名
     * 5:参数 org.sean..*.*(..) ()代表参数 ..表示参数类型
     */

    ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Pointcut("execution(* org.sean.service.SeanBroService.*(..)) ")
    public void pointcut() {
        //相当于一个专门写切面表达式的地方
    }

    /**
     * 使用注解做before,pointcut方法，普通表达式
     * 这里要注意注解的生效范围：
     *
     * @param joinPoint
     * @Retention(RetentionPolicy.RUNTIME) 该注解的意思是保留到什么阶段
     * @Target 的意思是标注在什么类型的类中属性上面
     * 只有runtime的才能在运行时生效，而我们的aop恰恰是在运行时生成的对象以及内存中的Class对象
     * <p>
     * 也可以将参数与注解绑定，参数不能随便绑定，要看有效情况
     */
    //前置通知
    @Before("pointcut()&& @annotation(name)")
    public void before1(JoinPoint joinPoint, Logger name) {
        System.out.println("Logger:name:" + name.name());
        Signature signature = joinPoint.getSignature();
        System.out.println(signature);
        System.out.println("getDeclaringType->" + signature.getDeclaringType());
        System.out.println("getModifiers->" + signature.getModifiers());
        System.out.println("getDeclaringTypeName->" + signature.getDeclaringTypeName());
        System.out.println("getName->" + signature.getName());
        long startTime = System.nanoTime();
        threadLocal.set(startTime);
        System.out.println("开始计时,pointcut(),anno before");
    }

    //前置通知
    @Before("execution(* org.sean.service.CuoService.*(..))")
    public void before2(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature);
        System.out.println("getDeclaringType->" + signature.getDeclaringType());
        System.out.println("getModifiers->" + signature.getModifiers());
        System.out.println("getDeclaringTypeName->" + signature.getDeclaringTypeName());
        System.out.println("getName->" + signature.getName());
        long startTime = System.nanoTime();
        threadLocal.set(startTime);
        System.out.println("开始计时");
    }

    //后置通知

    /**
     * 在后置通知中，如何获取返回值：
     */
    @After("execution(* org.sean.service.SeanBroService.*(..))")
    public void after() {
        System.out.println("后置通知：" + (System.nanoTime() - threadLocal.get()) / 1000000 + "ms");
        threadLocal.remove();
    }

    /**
     * 可获取异常
     *
     * @param ex
     */
    //后置异常通知
    @AfterThrowing(value = "execution(* org.sean.service.SeanBroService.*(..))", throwing = "ex")
    public void afterThrowing(Exception ex) {
        System.out.println("抛出了异常！" + ex.getMessage());
        //这里是如何打印栈
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw, true));
        System.out.println("异常栈：" + sw.getBuffer().toString());
    }

    /**
     * 可获取返回值
     *
     * @param result
     */
    //后置返回
    @AfterReturning(value = "execution(* org.sean.service.SeanBroService.*(..))", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("记录返回的对象:" + result);
    }

    //环绕通知(会覆盖其他的通知)
//    @Around("pointcut()&& @annotation(name)")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint, Logger name) {
//        System.out.println("LoggerName:----->" + name.name());
//        System.out.println(proceedingJoinPoint.getSignature().toString());
//        Object proceed = null;
//        try {
//            System.out.println("环绕前置通知:" + proceedingJoinPoint.getSignature().getName());
//            proceed = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
//            System.out.println("环绕返回通知:" + proceed);
//        } catch (Throwable throwable) {
//            System.out.println("环绕异常通知:" + "异常信息是" + throwable.getMessage());
//        } finally {
//            System.out.println("环绕后置通知:" + name + "方法结束");
//        }
//        return proceed;
//    }

}
