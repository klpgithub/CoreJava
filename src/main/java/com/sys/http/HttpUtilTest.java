package com.sys.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;

public class HttpUtilTest {

	@Test
	public void testLoadData() throws UnsupportedEncodingException {
		StringBuilder url = new StringBuilder(
				"http://192.168.0.107/cpiCalculate/cpiLoadData?loginName=su&pwd=c4ca4238a0b923820dcc509a6f75849b&param=");
		JSONObject loadDataParam = new JSONObject();
		loadDataParam.put("table", "sum_areasum");
		loadDataParam.put("period", "201805");
//		url.append(URLEncoder.encode(loadDataParam.toJSONString(), "utf-8"));
		url.append(loadDataParam.toJSONString());
		Console.log(url.toString());
		String string = HttpUtil.get(url.toString());
		System.out.println(string);
	}

	@Test
	public void testCpiCalculate() throws UnsupportedEncodingException {
		StringBuilder url = new StringBuilder(
				"http://192.168.0.107/cpiCalculate/cpiCalculate?loginName=su&pwd=c4ca4238a0b923820dcc509a6f75849b&param=");
		JSONObject cpiParam = new JSONObject();
		cpiParam.put("AREA_ID", "34D6F9BDF430481895E1267A3CABA4A6");
		cpiParam.put("period", "201705");
		cpiParam.put("PERTYPE_CODE", "1001");
		cpiParam.put("IFDQ", 1);
		cpiParam.put("XUN", 4);
		cpiParam.put("TYPECODE", "11");
		cpiParam.put("IFCY", 2);
		url.append(URLEncoder.encode(cpiParam.toJSONString(), "utf-8"));
		Console.log(url.toString());
		String string = HttpUtil.get(url.toString());
		System.out.println(string);
	}

}
