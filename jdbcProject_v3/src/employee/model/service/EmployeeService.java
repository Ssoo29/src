package employee.model.service;

import java.sql.*;
import java.util.ArrayList;

import employee.model.dao.EmployeeDao;
import employee.model.vo.Employee;
import common.JDBCTemplate;
//Connection 관리와 트랜잭션 처리가 주목적임
import static common.JDBCTemplate.*;


public class EmployeeService {
	//DI
	private EmployeeDao edao = new EmployeeDao();
	
	public EmployeeService() {}

	public ArrayList<Employee> selectList() {
		/*Connection conn = JDBCTemplate.getConnection();
		ArrayList<Employee> empList = edao.selectList(conn);
		JDBCTemplate.close(conn);*/
		
		Connection conn = getConnection();
		ArrayList<Employee> empList = edao.selectList(conn);
		close(conn);
		
		return empList;
	}

	public Employee selectOne(String empId) {
		/*Connection conn = JDBCTemplate.getConnection();
		Employee emp = edao.selectOne(conn, empId);
		JDBCTemplate.close(conn);
		*/
		
		Connection conn = getConnection();
		Employee emp = edao.selectOne(conn, empId);
		close(conn);
		
		return emp;
	}

	public ArrayList<Employee> selectJobList(String jobId) {
		/*Connection conn = JDBCTemplate.getConnection();
		ArrayList<Employee> empList = edao.selectJobList(conn, jobId);
		JDBCTemplate.close(conn);*/
		
		Connection conn = getConnection();
		ArrayList<Employee> empList = edao.selectJobList(conn, jobId);
		close(conn);
		
		return empList;
	}

	public ArrayList<Employee> selectDeptList(String deptId) {		
		/*Connection conn = JDBCTemplate.getConnection();
		ArrayList<Employee> empList = edao.selectDeptList(conn, deptId);*/
		
		Connection conn = getConnection();
		ArrayList<Employee> empList = edao.selectDeptList(conn, deptId);
		close(conn);

		return empList;
		
	}

	public int insert(Employee emp) {
		Connection conn = getConnection();
		int result = edao.insert(conn, emp);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		
		return result;
	}

	public int updatePhone(Employee emp) {
		Connection conn = getConnection();
		int result = edao.updatePhone(conn, emp);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
			close(conn);
		return result;
	}

	public int updateBonusPct(Employee emp) {
		Connection conn = getConnection();
		int result = edao.updateBonusPct(conn, emp);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
			close(conn);
		return result;
	}

	public int delete(String empId) {
		Connection conn = getConnection();
		int result = edao.delete(conn, empId);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		
		return result;
	}
}
