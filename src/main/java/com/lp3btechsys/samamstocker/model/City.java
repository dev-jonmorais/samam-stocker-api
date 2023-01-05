package com.lp3btechsys.samamstocker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "city_id")
	private Long cityID;
	
	@Column(name = "city_name")
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;
	
	public City() {}
	
	public City(String cityName, State state) {
		//super();
		this.cityName = cityName;
		this.state = state;
	}

	public Long getCityID() {
		return cityID;
	}

	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityID == null) ? 0 : cityID.hashCode());
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
		City other = (City) obj;
		if (cityID == null) {
			if (other.cityID != null)
				return false;
		} else if (!cityID.equals(other.cityID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City [cityName=" + cityName + ", state=" + state + "]";
	}
}
