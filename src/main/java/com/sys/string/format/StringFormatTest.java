package com.sys.string.format;

import org.junit.Test;

public class StringFormatTest {

	/**
	 * 常规类型的格式化
	 */
	@Test
	public void testConventionType() {
		String str = String.format("Hi,%s", "张三");
		System.out.println(str);
		System.out.printf("字母a的大写是:%c %n", 'A');
		System.out.printf("3>7的结果是:%b %n", 3 > 7);
		System.out.printf("3*10的结果是: %d %n", 3 * 10);
		System.out.printf("100的16进制表示为:%x %n", 100);
		System.out.printf("100的8进制数是:%o  %n", 100);
		System.out.printf("50元的书打8.5折是:%f %n", 50 * 0.85);
		System.out.printf("50*0.85的十六进制浮点数为:%a %n", 50 * 0.85);
		System.out.printf("50*0.85的指数表示法为:%e %n", 50 * 0.85);
		System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50 * 0.85);
		System.out.printf("8.5折表示为: %d%% %n", 85);
		System.out.printf("字母A的散列码:%h  %n", 'A');
	}

}
