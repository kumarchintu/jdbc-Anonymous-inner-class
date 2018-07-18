package org.inetsolv.SpringDAO;

public class Employee {
	private Integer eno;
	private String ename;
	private Double salary;

	public Integer getEno() {
		return eno;
	}

	public void setEid(Integer eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
}