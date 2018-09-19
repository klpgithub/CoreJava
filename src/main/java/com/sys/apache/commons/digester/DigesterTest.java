package com.sys.apache.commons.digester;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

public class DigesterTest {

	private List<Bus> buses = new ArrayList<Bus>();

	public void addBus(Bus bus) {
		this.buses.add(bus);
	}

	public void run() throws IOException, SAXException {
		Digester digester = new Digester();
		digester.push(this);

		digester.addObjectCreate("buses/bus", Bus.class);
		digester.addSetNestedProperties("buses/bus", new String[] { "foot_dist", "last_foot_dist" },
				new String[] { "footDist", "lastFootDist" });
//        digester.addBeanPropertySetter("buses/bus/dist");

		digester.addObjectCreate("buses/bus/segments/segment", Segment.class);
		digester.addSetProperties("buses/bus/segments/segment");
		digester.addSetNestedProperties("buses/bus/segments/segment",
				new String[] { "start_stat", "end_stat", "line_dist", "foot_dist" },
				new String[] { "startStat", "endStat", "lineDist", "footDist" });
		digester.addCallMethod("buses/bus/segments/segment/stats", "setStats", 0);

		digester.addSetNext("buses/bus/segments/segment", "addSegment");

		digester.addSetNext("buses/bus", "addBus");

		digester.parse(new File(getRootPath() + File.separator + "digester-test.xml"));
		System.out.println(this.buses.size());
		System.out.println(this.buses);
	}

	public static void main(String[] args) throws IOException, SAXException {
		new DigesterTest().run();
		String path = getRootPath();
		System.out.println(path);
	}

	public static String getRootPath() {
		URL url = DigesterTest.class.getResource("");
		String path = url.getPath();
		path = path.substring(0, path.indexOf("classes") + 7);
		return path;
	}

}
