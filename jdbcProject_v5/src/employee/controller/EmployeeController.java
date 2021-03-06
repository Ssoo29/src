package employee.controller;

import java.util.HashMap;
import java.util.HashMap;

import employee.exception.EmployeeException;
import employee.model.service.EmployeeService;
import employee.model.vo.Employee;
import employee.view.EmployeeMenu;

public class EmployeeController {
	//DI 선언
	private EmployeeService eservice = 
			new EmployeeService();	
	
	public EmployeeController() {}

	public HashMap<String, Employee> selectAll() {
		HashMap<String, Employee> empMap = null;
		
		
		try {
			empMap = eservice.selectMap();
			if(empMap.size() > 0) 
				System.out.println("전체조회 성공!");
			}catch (EmployeeException e) {
			new EmployeeMenu().printError(e.getMessage());
			new EmployeeMenu().displayMenu();
		}		
		
		return empMap;
	}

	public Employee selectEmployee(String empId) {
		Employee emp = null;
				
			try {
				emp = eservice.selectOne(empId);
			} catch (EmployeeException e) {
				new EmployeeMenu().printError(e.getMessage());
				new EmployeeMenu().displayMenu();
			}
			
		
		
		
		return emp;
	}

	public HashMap<String, Employee> selectJobId(String jobId) {
		HashMap<String, Employee> empMap = null;
		
		try {
			empMap = eservice.selectJobMap(jobId);
		} catch (EmployeeException e) {
			new EmployeeMenu().printError(e.getMessage());
			new EmployeeMenu().displayMenu();
		}
		return empMap;
	}

	public HashMap<String, Employee> selectDeptId(
			String deptId) {
		HashMap<String, Employee> empMap = null;
		
		try {
			empMap = eservice.selectDeptMap(deptId);
		} catch (EmployeeException e) {
			new EmployeeMenu().printError(e.getMessage());
			new EmployeeMenu().displayMenu();
		}

		
		if(empMap.size() == 0) {
			System.out.println("\n해당 부서에 근무하는 직원정보가 없습니다.");
			new EmployeeMenu().displayMenu();
		}
		
		return empMap;
	}

	public void insertEmployee(Employee emp) {

		
		try {
			int result = eservice.insert(emp);
			
			if(result > 0)
				System.out.println("직원 등록 성공");
			
		} catch (EmployeeException e) {
			new EmployeeMenu().printError(e.getMessage());
			new EmployeeMenu().displayMenu();
		}
	
		
		return;
	}

	public void updatePhone(Employee emp) {
		
		
		int result;
		try {
			result = eservice.updatePhone(emp);
			if(result > 0) 
				System.out.println("\n직원의 전화번호 변경 성공!");
			
		} catch (EmployeeException e) {
			new EmployeeMenu().printError(e.getMessage());
			new EmployeeMenu().displayMenu();
		}
		
		return;		
	}

	public void updateBonusPct(Employee emp) {
		

		try {
			int result = eservice.updateBonusPct(emp);
			if(result > 0) 
				System.out.println("\n직원의 보너스포인트 변경 성공!");
				
		} catch (EmployeeException e) {
			new EmployeeMenu().printError(e.getMessage());
			new EmployeeMenu().displayMenu();
		}
	
		
		return;
	}

	public void deleteEmployee(String empId) {

		try {
			int result = eservice.delete(empId);
			if(result > 0)
				System.out.println("직원 삭제 성공");
			
		} catch (EmployeeException e) {
			new EmployeeMenu().printError(e.getMessage());
			new EmployeeMenu().displayMenu();
		}
		
		return;
	}

}










