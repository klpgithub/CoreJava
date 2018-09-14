package com.sys.http;

import cn.hutool.http.HttpUtil;

public class HttpUtilTest {

	public static void main(String[] args) {

		String string = HttpUtil
				.get("http://localhost/page/main/mainFrame.html?loginName=su&pwd=c4ca4238a0b923820dcc509a6f75849b");
		System.out.println(string);

	}

}
