package dto;

public class MemberDto {
	
	private int empno;
	private String name;
	private String dept;
	private String phone;
	private String hiredate;
	private String job;
	private int sal;
	
	public MemberDto() {
	}

	public MemberDto(int empno, String name, String dept, String phone, String hiredate, String job, int sal) {
		super();
		this.empno = empno;
		this.name = name;
		this.dept = dept;
		this.phone = phone;
		this.hiredate = hiredate;
		this.job = job;
		this.sal = sal;
	}

	public MemberDto(String name, String dept, String phone, String job, int sal) {
		super();
		this.name = name;
		this.dept = dept;
		this.phone = phone;
		this.job = job;
		this.sal = sal;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "MemberDto [empno=" + empno + ", name=" + name + ", dept=" + dept + ", phone=" + phone + ", hiredate="
				+ hiredate + ", job=" + job + ", sal=" + sal + "]";
	}
	

}
