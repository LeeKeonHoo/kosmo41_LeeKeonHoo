package com.study.spring;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hello {
	private List<String> names;
	private Set<Integer> nums;
	private Map<String, Integer> args;
	
	
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	public Set<Integer> getNums() {
		return nums;
	}
	public void setNums(Set<Integer> nums) {
		this.nums = nums;
	}
	public Map<String, Integer> getArgs() {
		return args;
	}
	public void setArgs(Map<String, Integer> args) {
		this.args = args;
	}

}
