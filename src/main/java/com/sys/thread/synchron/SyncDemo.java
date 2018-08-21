package com.sys.thread.synchron;

/**
 * 
 * Created by klp on 2018年8月21日下午2:48:42.
 * 三种利用synchronized方法实现线程同步的方法：为了适应高并发性能以及快速响应的要求，
 * synchronized不同的写法对程序响应的快慢和对CPU等资源利用率是不同的；对比以上方式， 从程序运行性能与执行效率来看，从高到低依次排序为：
 * 第三种方式 > 第二种方式 > 第一种方式。
 */
public class SyncDemo {

	/**
	 * 第一种：修饰方法
	 */
	// synchronized修饰成员函数
	// 该函数能被执行，则意味则持有了调用
	// 该函数的对象引用所持有的lock
	// 多个函数如果存在同步关系，则可以在这
	// 些函数前面都增加synchronize修饰
	public synchronized void subroutine1() {

	}

	/**
	 * 第二种：修饰一般对象或this对象
	 */
	// 多个函数如果存在同步关系，则可以
	// 用synchronize修饰this对象
	public synchronized void subroutine2() {
		synchronized (this) {

		}
	}

	private SyncDemo syncDemo = new SyncDemo();

	// 多个函数如果存在同步关系，则可以
	// 用synchronize修饰demoA对象
	public synchronized void subroutine3() {
		synchronized (syncDemo) {

		}
	}

	/**
	 * 第三种，修饰轻量级对象
	 */
	private byte[] lock = new byte[1];

	// 多个函数如果存在同步关系，则可以
	// 用synchronize修饰lock对象
	// lock是一个轻量级对象
	public void subroutine4() {
		synchronized (lock) {

		}
	}

}
