package com.sys.thread.synchron;

/**
 * Created by klp on 2018/8/21
 */
public class StaticSyncTest {

    //情况4：synchronized修饰了该成员函数
    //该函数能被执行，则意味则持有StaticSyncTest.class
    //这样class对象所持有的锁
    public static synchronized void subroutine1() {

    }

    //情况5：synchronized修饰了this
    //进入该代码块，获得的锁与情况4相同
    public void subroutine2() {
        synchronized (StaticSyncTest.class) {

        }
    }

}
