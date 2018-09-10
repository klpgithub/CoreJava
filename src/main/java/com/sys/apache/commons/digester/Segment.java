package com.sys.apache.commons.digester;

import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class Segment {
	private String name;
	private String startStat;
	private String endStat;
	private List<String> stats;
	private int lineDist;
	private int footDist;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartStat() {
		return startStat;
	}

	public void setStartStat(String startStat) {
		this.startStat = startStat;
	}

	public String getEndStat() {
		return endStat;
	}

	public void setEndStat(String endStat) {
		this.endStat = endStat;
	}

	public List<String> getStats() {
		return stats;
	}

	public void setStats(String stats) {
		this.stats = Arrays.asList(stats.split(";"));
	}

	public int getLineDist() {
		return lineDist;
	}

	public void setLineDist(int lineDist) {
		this.lineDist = lineDist;
	}

	public int getFootDist() {
		return footDist;
	}

	public void setFootDist(int footDist) {
		this.footDist = footDist;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
