package com.sys.thread.synchron.demo1;

public class DemoTest {

	/**
	 * 线程A1通过对象demoA1启动，并调用了被synchronized修饰的print成员函数，按照我们上文（NO.25
	 * synchronized关键字画像：开胃菜）所提到的，线程要进入并执行该成员函数，需要先获取demoA1所关联锁，
	 * 由于该锁当前并没有被任何线程使用，所以线程A1顺利的获取了demoA1的所关联的lock，并开始执行print函数。
	 * 
	 * 紧接着，线程B通过对象demoB启动，并通过传入的demoA1对象引用，调用了被synchronized修饰的print成员函数；
	 * 同理，要执行该函数，需要获取调用该函数的对象demoA1所持有的锁，由于该锁已经被线程A1执行过程所持有，
	 * 为此线程B只能等待线程A1执行完成释放demoA1所持有的锁以后，才能得到执行的机会；但是，print函数是一个“死”循环，
	 * 为此线程B会一直被阻塞着，直到JVM退出而终止。
	 * 
	 * 最后，线程A2通过对象demoA2启动，并调用了被synchronized修饰的print成员函数；同理，线程要进入并执行该成员函数，
	 * 需要先获取demoA2所关联锁，由于该锁（由于每个对象都会有一个与之关联的lock，即使属于同一类型的对象所持有的锁也是不同的，
	 * 因此该锁不同于demoA1所关联的锁）当前并没有被任何线程使用，所以线程A2顺利的获取了demoA2的所关联的lock，并开始执行print函数。
	 * 
	 * 通过以上分析，线程A1与线程A2会交替执行，线程B会因为一直不能获取到demoA1所关联的锁而被永久阻塞
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		DemoA demoA1 = new DemoA("A1");
		demoA1.start();

		DemoB demoB = new DemoB(demoA1);
		demoB.start();

		DemoA demoA2 = new DemoA("A2");
		demoA2.start();

	}

}
