package com.sys.apache.commons.digester;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class Bus {

	private int dist;
	private int time;
	private int footDist;
	private int lastFootDist;
	private List<Segment> segments = new ArrayList<Segment>();

	public int getDist() {
		return dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getFootDist() {
		return footDist;
	}

	public void setFootDist(int footDist) {
		this.footDist = footDist;
	}

	public int getLastFootDist() {
		return lastFootDist;
	}

	public void setLastFootDist(int lastFootDist) {
		this.lastFootDist = lastFootDist;
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void addSegment(Segment segment) {
		this.segments.add(segment);
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
