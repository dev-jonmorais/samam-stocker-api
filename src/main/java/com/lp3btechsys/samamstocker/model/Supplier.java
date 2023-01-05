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
@Table(name = "suppliers")
public class Supplier {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "supplier_id")
	private Long supplierID;
	
	@Column(name = "supplier_name", length = 80)
	private String supplierName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id")
	private City city;
	
	@Column(name = "phone_main")
	private String phoneMain;
	
	@Column(name = "phone_secondary")
	private String phoneSecondary;
	
	@Column(name = "email_contact")
	private String emailContact;
	
	@Column(name = "doc_cnpj")
	private String docCNPJ;
	
	private String neighboorhood;
	
	@Column(name = "address_line_1")
	private String addressLine1;
	
	@Column(name = "address_line_2")
	private String addressLine2;
	
	@Column(name = "address_no")
	private int addressNumber;
	
	public Supplier() {}
	
	public Supplier(String supplierName, City city, String phoneMain, String phoneSecondary, String emailContact,
			String docCNPJ, String neighboorhood, String addressLine1, String addressLine2, int addressNumber) {
		super();
		this.supplierName = supplierName;
		this.city = city;
		this.phoneMain = phoneMain;
		this.phoneSecondary = phoneSecondary;
		this.emailContact = emailContact;
		this.docCNPJ = docCNPJ;
		this.neighboorhood = neighboorhood;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressNumber = addressNumber;
	}

	public Long getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(Long supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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

	public String getDocCNPJ() {
		return docCNPJ;
	}

	public void setDocCNPJ(String docCNPJ) {
		this.docCNPJ = docCNPJ;
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
		result = prime * result + ((supplierID == null) ? 0 : supplierID.hashCode());
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
		Supplier other = (Supplier) obj;
		if (supplierID == null) {
			if (other.supplierID != null)
				return false;
		} else if (!supplierID.equals(other.supplierID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Supplier [supplierID=" + supplierID + ", supplierName=" + supplierName + ", city=" + city
				+ ", phoneMain=" + phoneMain + ", phoneSecondary=" + phoneSecondary + ", emailContact=" + emailContact
				+ ", docCNPJ=" + docCNPJ + ", neighboorhood=" + neighboorhood + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", addressNumber=" + addressNumber + "]";
	}
	
}
