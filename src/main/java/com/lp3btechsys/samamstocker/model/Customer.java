package com.lp3btechsys.samamstocker.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerID;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String sex;
	
	@Column(name = "doc_cpf")
	private String docCPF;
	
	@Column(name = "doc_cnpj")
	private String docCNPJ;
	
	@Column(name = "phone_main")
	private String phoneMain;
	
	@Column(name = "phone_secondary")
	private String phoneSecondary;
	
	@Column(name = "email_contact")
	private String emailContact;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id")
	private City city;
	
	private String neighboorhood;
	
	@Column(name = "address_line_1")
	private String addressLine1;
	
	@Column(name = "address_line_2")
	private String addressLine2;
	
	@Column(name = "address_no")
	private int addressNumber;
	
	public Customer() {}
	
	/**
	 * ****************************************
	 * Constructor Main
	 * ****************************************
	 */
	public Customer(String firstName, String lastName, String sex, String docCPF, String docCNPJ,
			String phoneMain, String phoneSecondary, String emailContact, City city, String neighboorhood,
			String addressLine1, String addressLine2, int addressNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.docCPF = docCPF;
		this.docCNPJ = docCNPJ;
		this.phoneMain = phoneMain;
		this.phoneSecondary = phoneSecondary;
		this.emailContact = emailContact;
		this.city = city;
		this.neighboorhood = neighboorhood;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressNumber = addressNumber;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDocCPF() {
		return docCPF;
	}

	public void setDocCPF(String docCPF) {
		this.docCPF = docCPF;
	}

	public String getDocCNPJ() {
		return docCNPJ;
	}

	public void setDocCNPJ(String docCNPJ) {
		this.docCNPJ = docCNPJ;
	}

	public String getPhoneMain() {
		return phoneMain;
	}

	public void setPhoneMain(String phoneMain) {
		this.phoneMain = phoneMain;
	}

	public String getPhoneSecondary() {
		return phoneSecondary;
	}

	public void setPhoneSecondary(String phoneSecondary) {
		this.phoneSecondary = phoneSecondary;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
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
		Customer other = (Customer) obj;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", sex="
				+ sex + ", docCPF=" + docCPF + ", docCNPJ=" + docCNPJ + ", phoneMain=" + phoneMain + ", phoneSecondary="
				+ phoneSecondary + ", emailContact=" + emailContact + ", city=" + city + ", neighboorhood="
				+ neighboorhood + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", addressNumber=" + addressNumber + "]";
	}
}
