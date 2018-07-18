package org.inetsolv.SpringDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class App {
	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext("org.inetsolv.SpringDAO");
		JdbcTemplate jdbcTemplate = container.getBean(JdbcTemplate.class);
		String qry = "SELECT * FROM emp_tbl";

		List<Employee> empList = jdbcTemplate.query(qry,
				new RowMapper<Employee>() {
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					Employee employee = new Employee();
					employee.setEid(rs.getInt("eno"));
					employee.setEname(rs.getString("ename"));
					employee.setSalary(rs.getDouble("salary"));
					return employee;
					}
				});
		for (Employee employee : empList) {
			System.out.println(employee.getEno() + " " + employee.getEname() + " " + employee.getSalary());
		}
		((AbstractApplicationContext) container).close();
	}
}