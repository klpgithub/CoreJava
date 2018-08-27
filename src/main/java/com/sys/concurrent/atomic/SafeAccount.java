package com.sys.concurrent.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 模拟解决ABA问题
 * 
 * 演员：游戏VIP会员，游戏管理员
道具：VIP会员充值卡
剧情：某款游戏的管理员发现最近日活数有下降趋势，为了吸引流量，回馈VIP会员，决定为当前VIP会员充值卡中少于10比特币的，充值10比特币一次（想想睡觉都会笑醒）。
 * 
 * Created by klp on 2018年8月27日下午2:36:34.
 */
public class SafeAccount {

	static AtomicStampedReference<Integer> account = new AtomicStampedReference<Integer>(6, 1);

	public static void main(String[] args) {
		// 充值
		recharge();
		// 消费
		consume();
	}

	// 模拟充值
	public static void recharge() {
		final int stamp = account.getStamp();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					for (;;) {
						// 获取账户当前余额
						Integer btc = account.getReference();
						// 如果余额少于10BTC,则进行充值
						if (btc < 10) {
							if (account.compareAndSet(btc, btc + 10, stamp, stamp + 1)) {
								System.out
										.println("充值成功! 充值前:" + btc + " BTC , 充值后: " + account.getReference() + " BTC");
								break;
							} else {
								System.out.println("充值失败...");
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						} else {
							break;
						}
					}
				}
			}
		}).start();
	}

	// 模拟消费
	public static void consume() {
		new Thread() {
			public void run() {
				while (true) {
					int stamp = account.getStamp();
					Integer btc = account.getReference();
					// 当账户余额大于5btc时就模拟消费
					if (btc > 5) {
						System.out.println("当前余额大于5btc");
						if (account.compareAndSet(btc, btc - 5, stamp, stamp + 1)) {
							System.out.println("消费5btc,余额:" + account.getReference());
						}
					} else {
						System.out.println("没有足够的余额");
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
	}

}