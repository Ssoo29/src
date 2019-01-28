package employee.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import employee.controller.EmployeeController;
import employee.model.vo.Employee;

public class EmployeeMenu {
	//DI (의존성 주입 : Dependancy Injection)
	private Scanner sc = new Scanner(System.in);
	private EmployeeController econtroll = new EmployeeController();
	
	
	public EmployeeMenu() {}
	
	public void displayMenu() {
		int no;
		
	do {
	System.out.println("-------------------------");
	System.out.println("\n**** 직원 정보 관리 프로그램 ****");
	System.out.println();
	System.out.println("1. 전체 직원 조회");
	System.out.println("2. 사번으로 직원 한 사람 조회");
	System.out.println("3. 직급별로 조회");
	System.out.println("4. 부서별로 조회");
	System.out.println("5. 새 직원 등록");
	System.out.println("6. 직원 전화번호 수정");
	System.out.println("7. 직원 보너스포인트 수정");
	System.out.println("8. 사번으로 직원 삭제");
	System.out.println("9. 끝내기");
	System.out.print("번호선택 : ");
	no = sc.nextInt();
	//crud(create, insert, update, delete)
		
	switch(no) {
	case 1:	/*ArrayList<Employee> list = econtroll.selectAll(); break;
			printList(ArrayList<Employee> list = econtroll.selectAll());
			break;*/
			printList(econtroll.selectAll()); break;
	case 2: String empid = inputEmpid();
		/*	Employee emp = econtroll.selectEmployee(empid);
			printEmployee(emp);*/
			printEmployee(econtroll.selectEmployee(empid));
			break;
			
	case 3: printList(econtroll.selectJobId(inputJobId())); break;
	case 4: printList(econtroll.selectDeptId(inputDeptId())); break;
	case 5: econtroll.insertEmployee(inputEmployee()); break;
	case 6: econtroll.updatePhone(inputPhone()); break;
	case 7: econtroll.updateBonusPct(inputBonusPct()); break;
	case 8: econtroll.deleteEmpId(inputEmpid()); break;
	case 9:   System.out.print("\n종료(y), 취소(n) : ");
	          if(sc.next().toUpperCase().charAt(0) == 'Y') {
	        	  return; //main()으로 돌아감
	          }else {
	        	  break; //메뉴 다시 반복
	          }
	default : System.out.println("없는 번호입니다.");
	          System.out.println("다시 입력하세요 \n");		
	}
	}while(true);
	}
	

	//수정할 보너스포인트와 해당 사번 입력용
	public Employee inputBonusPct() {
		Employee emp = new Employee();
		
		System.out.print("\n변경할 직원의 사번 : ");
		emp.setEmpid(sc.next());
		System.out.print("변경할 보너스포인트 : ");
		emp.setBonusPct(sc.nextDouble());
		return emp;
	}
	
	
	
	//수정할 전화번호와 사번 입력용
	public Employee inputPhone() {
		Employee emp = new Employee();
		System.out.print("\n변경할 직원의 사번 : ");
		emp.setEmpid(sc.next());
		System.out.print("변경할 전화번호[-빼고 입력] : ");
		emp.setPhone(sc.next());
		return emp;
	}

	//새로 등록할 직원 정보 입력용
	public Employee inputEmployee() {
		Employee emp = new Employee();
		
		System.out.print("이름 : ");
		emp.setEmpName(sc.next());
		System.out.print("주민번호 : ");
		emp.setEmpNO(sc.next());
		System.out.print("이메일 : ");
		emp.setEmail(sc.next());
		System.out.print("전화번호[-빼고 입력] : ");
		emp.setPhone(sc.next());
		System.out.print("입사일[yyyy-MM-dd] : ");
		emp.setHireDate(Date.valueOf(sc.next()));
		System.out.print("직급코드 : ");
		emp.setJobid(sc.next().toUpperCase());
		System.out.print("급여 : ");
		emp.setSalary(sc.nextInt());
		System.out.print("보너스포인트 : ");
		emp.setBonusPct(sc.nextDouble());
		System.out.print("결혼여부[기혼:Y, 미혼:N] : ");
		emp.setMarriage(sc.next().toUpperCase());
		System.out.print("관리자사번 : ");
		emp.setMgrId(sc.next());
		System.out.print("부서번호 : ");
		emp.setDeptId(sc.next());
		
		return emp;
	}
	
	
	//부서코드 입력용
	public String inputDeptId() {
		System.out.print("\n부서코드 : ");
		return sc.next();
	}

	//직급코드 입력용
	public String inputJobId() {
		System.out.print("\n직급코드 : ");
		return sc.next().toUpperCase();
	}

	//직원 한 사람 정보 출력용
	public void printEmployee(Employee emp) {
		System.out.println("\n조회한 직원의 정보는 다음과 같습니다.");
		System.out.println(emp);
	}
	
	//사번 입력받아 리턴
	public String inputEmpid() {
		System.out.print("\n사번 입력 : ");
		return sc.next();
	}
	
	public void printList(ArrayList<Employee> empList){
		System.out.println("\n현재 조회된 직원 수는 " + empList.size() + "명입니다.");
		
		for(Employee emp : empList) {
			System.out.println(emp);
		}
		
		
	}
	}

