package com.sys.thread.synchron.demo2;

public class StaticSyncTest {

	/**
	 * 该程序首先定义了一个对象引用demoC1，然后启动线程c1，该线程会执行被synchronized修饰的print1函数，
	 * 进入print1函数前，会首先判断是否持有对象引用demoC1的锁，由于该锁尚未被其他线程所占用，为此该线程会被执行；
	 * 接着demoC1会调用print2函数，该函数同时被synchronized与static关键字修饰，按照我们上文所提及的方法，要进入该函数，
	 * 需要持有DemoC.class对象所关联lock，由于该对象尚未被其他线程所持有，为此该函数也将被执行。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DemoC demoC = new DemoC("C1");
		Thread thread = new Thread(demoC);
		thread.start();
		
		
//		demoC.print2("C2");
		DemoC.print2("C2");

	}

}
