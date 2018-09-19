package com.sys.crypto;

import org.junit.Test;

import cn.hutool.crypto.SecureUtil;

public class SecureUtilTest {
	
	@Test
	public void testMD5() {
		String pwd = SecureUtil.md5("1");
		System.out.println(pwd);
	}
	
}
