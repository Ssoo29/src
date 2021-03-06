package employee.model.vo;

import java.sql.Date;

public class Employee implements java.io.Serializable{
	private static final long serialVersionUID = 7L;


	private String empid;
	//오라클에서는 문자를 취급하지만 자바에서는 무조건 문자열로 처리 그래서 STRING
	private String empName;
	private String empNO;
	private String email;
	private String phone;
	private Date hireDate;
	private String jobid;
	private int salary;
	private double bonusPct;
	private String marriage;
	private String mgrId;
	private String deptId;
	
	public Employee() {
		
	}
	
	public Employee(String empid, String empName, String empNO, String email, String phone, Date hireDate, String jobid,
			int salary, double bonusPct, String marriage, String mgrId, String deptId) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empNO = empNO;
		this.email = email;
		this.phone = phone;
		this.hireDate = hireDate;
		this.jobid = jobid;
		this.salary = salary;
		this.bonusPct = bonusPct;
		this.marriage = marriage;
		this.mgrId = mgrId;
		this.deptId = deptId;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNO() {
		return empNO;
	}

	public void setEmpNO(String empNO) {
		this.empNO = empNO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonusPct() {
		return bonusPct;
	}

	public void setBonusPct(double bonusPct) {
		this.bonusPct = bonusPct;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getMgrId() {
		return mgrId;
	}

	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	@Override
	public String toString() {
		return this.empid + ", " +  this.empName + ", " + this.empNO + ", " + this.email + ", " +
	this.phone + ", " + this.hireDate + ", " + this.jobid + ", " + this.salary + ", " + this.bonusPct + ", "
	+ this.marriage + ", " + this.mgrId + ", " + this.deptId;
	}
}
