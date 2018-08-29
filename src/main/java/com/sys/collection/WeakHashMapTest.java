package com.sys.collection;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * WeakHashMap其实和HashMap用法类似，它们之间唯一的区别就是：
 * 	HashMap中的key保存的是实际对象的强引用，因此只要对象不被销毁，
 * 	即该key所对应的key-value都不会被垃圾回收机制回收。
 * 	但是WeakHashMap保存的实际对象是弱引用，
 * 	这意味着只要该对象没有被强对象引用就有可能会被垃圾回收机制回收对应的Key-value
 * 
 * @author Administrator
 *
 */
public class WeakHashMapTest {

	public static void main(String[] args) {
		Map<String, String> map = new WeakHashMap<String, String>();
		// 三个key-value中的key 都是匿名对象，没有强引用指向该实际对象
		map.put(new String("语文"), "优秀");
		map.put(new String("数学"), "良");
		map.put(new String("英语"), "不及格");

		// 增加一个字符串的强引用
		map.put("java", "0.1");
		System.out.println(map);
		System.gc();
		System.runFinalization();
		System.out.println(map);
	}

}
