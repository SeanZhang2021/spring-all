package org.sean;


import org.sean.service.CuoService;
import org.sean.service.ICuoService;
import org.sean.service.SeanBroService;
import org.sean.service.SpecialService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class AppAop {

    private static final AnnotationConfigApplicationContext ca = new AnnotationConfigApplicationContext("org.sean");

    public static void main(String[] args) {
        SeanBroService bro = (SeanBroService) ca.getBean("seanBroService");
        System.out.println("bro class:" + bro.getClass());
        //cglib动态代理可以通过接口和本类获取bean
        //jdk动态代理只能通过接口类型获取bean，Spring不会给本类创建bean，拿到的是动态代理对象bean
        ICuoService cuo = ca.getBean(ICuoService.class);
        CuoService cuo2 = ca.getBean(CuoService.class);
        SpecialService specialService = ca.getBean(SpecialService.class);
        System.out.println("cuo class:" + cuo.getClass());
        System.out.println("cuo2 class:" + cuo2.getClass());
        System.out.println("special class:" + specialService.getClass());

        try {
            bro.doBroServiceAndReturn("rockman");
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }

        try {
            System.out.println("结果：" + bro.doBroServiceAndReturn("zhangzhang"));
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());

        }

        System.out.println("cuo result:" + cuo.cuo(20));
    }
}
