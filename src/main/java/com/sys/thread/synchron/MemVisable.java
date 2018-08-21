package com.sys.thread.synchron;

/**
 * 测试内存可见性的例子 线程C的执行体会不断测试执行状态位（isRunning），如果状态位一直为true，
 * 则线程C会一直执行下去；线程D就只做了一件事：设置线程执行状态位为停止。
 * 该代码的意图是：线程C启动后，通过线程D去终止线程C。但是该代码是存在问题隐患的， 即存在不一定能终止线程D的情况。究其底层原因就是因为内存不可见造成的，
 * 因为存在线程D将bRunning设置为false后，其修改的值不能被线程C“感知”到，造成线程C会无法被中断。 Created by klp on
 * 2018年8月21日下午3:22:16.
 */
public class MemVisable extends Thread {

	// 线程能否继续执行的标识
	private boolean isRunning = true;

	@Override
	public void run() {
		// 测试isRunning是否为真
		// 如果为真，则循环执行
		// 如果为假，则退出执行
		while (isRunning) {
			System.out.println("System is running ...");
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 控制线程是否继续执行
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public static void main(String[] args) {
		// 线程C
		final MemVisable mem = new MemVisable();
		mem.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 线程D
		new Thread(new Runnable() {

			public void run() {
				mem.setRunning(false);
			}
		}).start();
	}

}
