package com.devsuperior.sam.dto;

import java.util.List;

public class DtoEcomp {
	private String curricular_unit;
	private Integer workload;
	private List<String> prerequisites;
	private List<Integer> position;
	private Integer credit;
	
	public String getCurricular_unit() {
		return curricular_unit;
	}
	public void setCurricular_unit(String curricular_unit) {
		this.curricular_unit = curricular_unit;
	}
	public int getWorkload() {
		return workload;
	}
	public void setWorkload(int workload) {
		this.workload = workload;
	}
	public List<String> getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(List<String> prerequisites) {
		this.prerequisites = prerequisites;
	}
	public List<Integer> getPosition() {
		return position;
	}
	public void setPosition(List<Integer> position) {
		this.position = position;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}


}