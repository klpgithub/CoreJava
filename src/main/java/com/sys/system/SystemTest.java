package com.sys.system;

import org.junit.Test;

public class SystemTest {

	/**
	 * System.arraycopy:复制一维数组为属性值复制,修改副本不会改变原数组
	 */
	@Test
	public void testArrayCopy() {
		int[] src = { 1, 2, 3, 4, 5 };
		int[] dest = new int[src.length];
		System.arraycopy(src, 0, dest, 0, src.length);
		// 修改目标数组
		dest[0] = 999;
		System.out.print("源数组:");
		for (int i = 0; i < src.length; i++) {
			System.out.print(src[i] + ",");
		}
		System.out.println();
		System.out.print("目标数组:");
		for (int i = 0; i < dest.length; i++) {
			System.out.print(dest[i] + ",");
		}
	}

	/**
	 * System.arraycopy:复制对象数组为引用传递,修改目标对象,原对象改变
	 */
	@Test
	public void testArrayCopyForObj() {
		User[] users = new User[] { new User("zhangsan", 25), new User("lisi", 26), new User("wangwu", 29) };
		User[] target = new User[users.length];
		System.arraycopy(users, 0, target, 0, users.length);

		users[1].setName("lisi_update");

		target[0].setName("zhangsan_update");
		target[0].setAge(20);

		System.out.println("源数组:");
		for (int i = 0; i < users.length; i++) {
			System.out.println("\t" + users[i].toString());
		}
		System.out.println("目标数组");
		for (int i = 0; i < target.length; i++) {
			System.out.println("\t" + target[i].toString());
		}
	}

}
