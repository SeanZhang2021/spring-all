package org.sean;

import org.sean.dao.SeanBroDao;
import org.sean.dao.SeanDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 */
public class AppAnno {

    private static final CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final AnnotationConfigApplicationContext ca = new AnnotationConfigApplicationContext("org.sean.dao");

    public static void main(String[] args) {
        Thread thread = new Thread(new Timer());
        //thread.setDaemon(true);
        thread.start();
        try {
            SeanDao dao = (SeanDao) ca.getBean("seanDao");
            dao.getDaoId();
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("class loader:" + Thread.currentThread().getContextClassLoader());
        System.out.println("Main End");
    }

    static class Timer implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " -> Timer start");
            int duration = 3;
            while (duration >= 0) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Timer: " + duration + " s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                duration--;
            }
            //门闩减一
            countDownLatch.countDown();
            //继续执行，后面是为了测试非守护线程不结束，程序不会停止
            try {
                System.out.println("Timer:Extension of time 2s！！！");
                int externalTime = 2;
                while (externalTime >= 0) {
                    Thread.sleep(1000);
                    System.out.println("Timer: " + externalTime + " s");
                    externalTime--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SeanBroDao seanBroDao = ca.getBean(SeanBroDao.class);
            System.out.println(seanBroDao.getDaoId());
            System.out.println(Thread.currentThread().getName() + " -> destroy applicationContext");
            ca.close();
            System.out.println("class loader:" + Thread.currentThread().getContextClassLoader());
            System.out.println(Thread.currentThread().getName() + " -> Timer end");
        }
    }
}
