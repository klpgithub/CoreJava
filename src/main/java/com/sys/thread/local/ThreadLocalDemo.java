package com.sys.thread.local;

/**
 * ThreadLocal典型应用示例
 * 
 * @author Administrator
 *
 */
public class ThreadLocalDemo {

	// 入职的第一天，单位给新员工办了一张ICBC卡
	// 为了保证办卡成功，预充值了10RMB
	private static ThreadLocal<Integer> ICBCCard = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			System.out.println("ThreadLocal initialValue ");
			return 10;
		}
	};

	// 模拟发一笔工资
	public int transfer(int income) {
		ICBCCard.set(ICBCCard.get() + income);
		return ICBCCard.get();
	}

	/**
	 * 模拟发工资的场景
	 * 
	 * @author Administrator
	 *
	 */
	private static class PayOff extends Thread {
		private ThreadLocalDemo demo;

		public PayOff(ThreadLocalDemo t) {
			this.demo = t;
		}

		// 将工资发放后的余额变化情况进行打印
		public void report(int total) {
			System.out.println(Thread.currentThread().getName() + "=> ICBC余额： " + total + " RMB");
		}

		// 模拟发多笔工资
		@Override
		public void run() {
			int total = demo.transfer(1000);
			report(total);
			total = demo.transfer(9999);
			report(total);
			total = demo.transfer(6666);
			report(total);
			ICBCCard.remove();
			System.out.println(ICBCCard.get());
		}
	}

	public static void main(String[] args) throws InterruptedException {

		ThreadLocalDemo demo = new ThreadLocalDemo();

		PayOff p1 = new PayOff(demo);
		p1.setName("员工1");

		PayOff p2 = new PayOff(demo);
		p2.setName("员工2");

		p1.start();
		p2.start();

		Thread.sleep(2000);

	}
}
