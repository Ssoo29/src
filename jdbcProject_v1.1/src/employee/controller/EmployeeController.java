package employee.controller;

import java.util.ArrayList;

import employee.model.vo.Employee;
import employee.view.EmployeeMenu;
import employee.model.dao.*;

public class EmployeeController {
	private EmplayeeDao edao = new EmplayeeDao();
	
	public EmployeeController(){}
	
	//직원 전체 조회 처리용 메소드
	public ArrayList<Employee> selectAll(){
		
		ArrayList<Employee> empList = edao.selcetList();
		
		if(empList.size() == 0) {
			System.out.println("\n직원 정보가 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();
		}
		return empList;
		
	}

	public Employee selectEmployee(String empId) {
		Employee emp = edao.selectOne(empId);
		
		if(emp == null) {
			System.out.println(empId + "사번 직원이 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();
		}
		
		
		return emp;
	}

	public ArrayList<Employee> selectJobId(String JobId) {
		
		ArrayList<Employee> empList = edao.selcetList(JobId);
		
		if(empList.size() == 0) {
			System.out.println("\n직원 정보가 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();
		}
		
		return empList;
	}

	public ArrayList<Employee> selectDeptId(String DeptId) {
		
		ArrayList<Employee> empList = edao.selectList(DeptId);
		
		if(empList.size() == 0) {
			System.out.println("\n직원 정보가 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();
		}	
		

		return empList;
	}

	public void insertEmployee(Employee emp) {
		int result = edao.insert(emp);
		
		if(result > 0) {
			System.out.println("\n직원정보 등록 성공!");
		}else
		{
			System.out.println("\n새 직원 등록 실패");
			System.out.println("확인하고 다시 시도하십시오.");
		}
		
		return;
		
	}

	public void updatePhone(Employee emp) {
		int result = edao.updatePhone(emp);
		
		if(result > 0) {
			System.out.println("\n직원의 전화번호 변경 성공!");
		}else {
			System.out.println("\n전화번호 변경 실패!");
			System.out.println("확인하고 다시 시도하십시오.");
		}
	}

	public void updateBonusPct(Employee emp) {
		int result = edao.updateBonusPct(emp);
		
		if(result > 0) {
			System.out.println("\n직원의 보너스포인트 변경 성공!");
		}else {
			System.out.println("\n보너스포인트 변경 실패!");
			System.out.println("확인하고 다시 시도하십시오.");
		}
		
	}

	public void deleteEmpId(String empid) {
		int result = edao.delete(empid);
		
		if(result > 0) {//1개의 행이 삭제되었으므로 return값이 1
			System.out.println("\n직원 정보 삭제 성공!");
		}else {
			System.out.println("\n직원 정보 삭제 실패!");
			System.out.println("확인하고 다시 시도하십시오.");
		}
		
	}
	

	}
