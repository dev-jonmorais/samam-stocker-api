package com.lp3btechsys.samamstocker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeID;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "alias_name")
	private String aliasName;
	
	private String sex;
	private int age;
	
	@Column(name = "phone_main")
	private String phoneMain;
	
	@Column(name = "doc_cpf")
	private String docCPF;
	
	@Column(name = "doc_rg")
	private String docRG;
	
	@Column(name = "employee_position")
	private String position;
	
	@Column(name = "experience_time")
	private String experienceTime;
	
	private String neighboorhood;
	
	@Column(name = "address_line_1")
	private String addressLine1;
	
	@Column(name = "address_line_2")
	private String addressLine2;
	
	@Column(name = "address_no")
	private int addressNumber;
	
	public Employee() {}

	public Employee(String firstName, String lastName, String aliasName, String sex, int age,
			String phoneMain, String docCPF, String docRG, String position, String experienceTime, String neighboorhood,
			String addressLine1, String addressLine2, int addressNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.aliasName = aliasName;
		this.sex = sex;
		this.age = age;
		this.phoneMain = phoneMain;
		this.docCPF = docCPF;
		this.docRG = docRG;
		this.position = position;
		this.experienceTime = experienceTime;
		this.neighboorhood = neighboorhood;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressNumber = addressNumber;
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
		
	public String getPhoneMain() {
		return phoneMain;
	}

	public void setPhoneMain(String phoneMain) {
		this.phoneMain = phoneMain;
	}

	public String getDocCPF() {
		return docCPF;
	}

	public void setDocCPF(String docCPF) {
		this.docCPF = docCPF;
	}

	public String getDocRG() {
		return docRG;
	}

	public void setDocRG(String docRG) {
		this.docRG = docRG;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getExperienceTime() {
		return experienceTime;
	}

	public void setExperienceTime(String experienceTime) {
		this.experienceTime = experienceTime;
	}

	public String getNeighboorhood() {
		return neighboorhood;
	}

	public void setNeighboorhood(String neighboorhood) {
		this.neighboorhood = neighboorhood;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public int getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(int addressNumber) {
		this.addressNumber = addressNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeID == null) ? 0 : employeeID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Employee other = (Employee) obj;
		if (employeeID == null) {
			if (other.employeeID != null)
				return false;
		} else if (!employeeID.equals(other.employeeID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", aliasName=" + aliasName + ", sex=" + sex + ", age=" + age + ", phoneMain=" + phoneMain
				+ ", docCPF=" + docCPF + ", docRG=" + docRG + ", position=" + position + ", experienceTime="
				+ experienceTime + ", neighboorhood=" + neighboorhood + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", addressNumber=" + addressNumber + "]";
	}
	
}
