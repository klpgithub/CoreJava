package com.sys.thread.synchron;

/**
 * Created by klp on 2018/8/21.
 */
public class NoStaticSyncTest {

    //情况1：synchronized修饰了该成员函数
    //该函数能被执行，则意味则持有了调用
    //该函数的对象引用所持有的lock
    public synchronized void subroutine1() {

    }

    //情况2：synchronized修饰了this
    //进入该代码块，获得的锁与情况1相同
    public void subroutine2() {
        synchronized (this) {
            //TODO
        }
    }

    //情况3：synchronized修饰了pt对象
    //进入该代码块，则获得了pt对象所持有的lock
    public void draw(java.awt.Point pt) {
        synchronized (pt) {
            //TODO
        }
    }
}
