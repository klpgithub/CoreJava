package com.sys.json;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class FastJsonTest {
	
	@Test
	public void testBeanJson() {
		Student student = new Student("1","2","3","4");
		
		String string = JSON.toJSONString(student);
		System.out.println(string);
	}
	
}
