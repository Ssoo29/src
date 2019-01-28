package employee.model.dao;

import java.sql.*;
import java.util.ArrayList;

import employee.model.vo.Employee;

//dao : database access object
//jdbc 코드 : 비즈니스 로직
//데이터베이스에 대한 CRUD 소스 구현
//CRUD CREATE:INSERT, READ:SELECT, UPDATE:UPDATE, DELETE:DELETE

public class EmplayeeDao {
	public EmplayeeDao() {}

	public ArrayList<Employee> selcetList() {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		// 컬럼과 행을 객체에 담고 그걸 리스트에 담기.
		
		
		//4. SQL 전송받기 : 쿼리문 string으로 만듬
			String query = "select * from employee";
			
		
		try {
			//1. 드라이버 등록.
			Class.forName( "oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공!");
			
			//2. 데이터베이스 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			System.out.println("conn :" + conn);				
		
			//3. 쿼리문 가지고 db에 가서 실행하고 나서 결과 가지고 돌아오는 객체 생성함.
			stmt = conn.createStatement();
			
			//4. 쿼리문 보내서 실행하고 결과 받기
			rset = stmt.executeQuery(query);
			
			//5. ResultSet에 조회해 온 결과 행들의 컬럼값들을
			//하나씩 꺼내서 변수|필드에 옮겨 담기
			while(rset.next()) {
				Employee emp = new Employee();
				emp.setEmpid(rset.getString("emp_id"));
				emp.setEmpName(rset.getString("emp_name"));
				emp.setEmpNO(rset.getString("emp_no"));
				emp.setEmail(rset.getString("email"));
				emp.setPhone(rset.getString("phone"));
				emp.setHireDate(rset.getDate("hire_date"));
				emp.setJobid(rset.getString("job_id"));
				emp.setSalary(rset.getInt("salary"));
				emp.setBonusPct(rset.getDouble("bonus_pct"));
				emp.setMarriage(rset.getString("marriage"));
				emp.setMgrId(rset.getString("mgr_id"));
				emp.setDeptId(rset.getString("dept_id"));
				
				empList.add(emp);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("1. 프로젝트에 ojdbc6 추가 안했거나(Referenced Librarites 생성)");
			System.out.println("2.class명 오타냇거나");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("url: jdbc ~ 잘못침.");
		}finally {
			try {
				//4. rset 닫기. 이유?
				rset.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return empList;
	}

	public Employee selectOne(String empId) {
		Employee emp = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee where emp_id = '" + empId + "'";
		try {
			//1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			//3.
			stmt = conn.createStatement();
			//4.
			rset = stmt.executeQuery(query);
			//5.
			if(rset.next()) {
				emp = new Employee();
				
				emp.setEmpid(empId);
				emp.setEmpName(rset.getString("emp_name"));
				emp.setEmpNO(rset.getString("emp_no"));
				emp.setEmail(rset.getString("email"));
				emp.setPhone(rset.getString("phone"));
				emp.setHireDate(rset.getDate("hire_date"));
				emp.setJobid(rset.getString("job_id"));
				emp.setSalary(rset.getInt("salary"));
				emp.setBonusPct(rset.getDouble("bonus_pct"));
				emp.setMarriage(rset.getString("marriage"));
				emp.setMgrId(rset.getString("mgr_id"));
				emp.setDeptId(rset.getString("dept_id"));
				
				return emp;
			}
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	public ArrayList<Employee> selcetList(String jobId) {
			
			ArrayList<Employee> empList = new ArrayList<>();		
			Employee emp = null;
			Connection conn = null;
			Statement stmt = null;
			ResultSet rset = null;
			
			String query = "select * from employee where JOB_ID = '" + jobId + "'";
			try {
				//1.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//2.
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
				//3.
				stmt = conn.createStatement();
				//4.
				rset = stmt.executeQuery(query);
				
				while(rset.next()) {
					emp = new Employee();
					
					emp.setEmpid(rset.getString("emp_Id"));
					emp.setEmpName(rset.getString("emp_name"));
					emp.setEmpNO(rset.getString("emp_no"));
					emp.setEmail(rset.getString("email"));
					emp.setPhone(rset.getString("phone"));
					emp.setHireDate(rset.getDate("hire_date"));
					emp.setJobid(jobId);
					emp.setSalary(rset.getInt("salary"));
					emp.setBonusPct(rset.getDouble("bonus_pct"));
					emp.setMarriage(rset.getString("marriage"));
					emp.setMgrId(rset.getString("mgr_id"));
					emp.setDeptId(rset.getString("dept_id"));
					
					empList.add(emp);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					rset.close();
					stmt.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		
		return empList;
	}

	public ArrayList<Employee> selectList(String deptId) {
		ArrayList<Employee> empList = new ArrayList<>();
		
		Employee emp = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee where DEPT_ID = '" + deptId + "'";
		try {
			//1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			//3.
			stmt = conn.createStatement();
			//4.
			rset = stmt.executeQuery(query);
			
			
			while(rset.next()) {
				emp = new Employee();
				
				emp.setEmpid(rset.getString("emp_Id"));
				emp.setEmpName(rset.getString("emp_name"));
				emp.setEmpNO(rset.getString("emp_no"));
				emp.setEmail(rset.getString("email"));
				emp.setPhone(rset.getString("phone"));
				emp.setHireDate(rset.getDate("hire_date"));
				emp.setJobid(rset.getString("job_id"));
				emp.setSalary(rset.getInt("salary"));
				emp.setBonusPct(rset.getDouble("bonus_pct"));
				emp.setMarriage(rset.getString("marriage"));
				emp.setMgrId(rset.getString("mgr_id"));
				emp.setDeptId(deptId);
				
				empList.add(emp);
			}
				
		} catch (Exception e) {
			System.out.println("무언가 잘못되었다.");
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("무언가 잘못되었다.");
			}
		}
		return empList;
		
	}

	public int insert(Employee emp) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		//ResultSet 필요없다. DML이다.
		
		String query = "insert into employee values(empid_seq.nextval, '" + emp.getEmpName() + "', '" +
		emp.getEmpNO() + "', '" +emp.getEmail() + "', '" + emp.getPhone() + "', '" + emp.getHireDate() 
		+ "', '" + emp.getJobid() + "', '" + emp.getSalary() + "', '" + emp.getBonusPct() + "', '"
		+ emp.getMarriage() + "', '" + emp.getMgrId() + "', '" + emp.getDeptId() + "')";
		

		try {
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe"
												, "student", "student");
			conn.setAutoCommit(false);//자동 커밋하면 절대 안됨!!
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(query);
			
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
		
			
		} catch (Exception e) {
		e.printStackTrace();	
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int updatePhone(Employee emp) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		
		String query = "update employee set phone = '"+ emp.getPhone() + "' where emp_id = '"
				+ emp.getEmpid() + "'";
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(query);
			
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		
		return result;
	}

	public int updateBonusPct(Employee emp) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		
		String query = "update employee set bonus_pct = " + emp.getBonusPct() + " where emp_id = '" + emp.getEmpid() + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(query);
			
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int delete(String empid) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		
		String query = "delete from employee where emp_id = '"+ empid  + "'";
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","student", "student");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(query);
			
			if(result > 0) {
				conn.commit();
			}else
				conn.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
