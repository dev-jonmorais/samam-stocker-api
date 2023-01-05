package com.lp3btechsys.samamstocker.model;

//import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "states")
public class State {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "state_id")
	private Long stateID;
	
	@Column(name = "state_name")
	private String stateName;
	
//	@OneToMany
//	private List<City> city;

	public State() {}
	
	public State(String stateName) {
		super();
		this.stateName = stateName;
	}

	public Long getStateID() {
		return stateID;
	}

	public void setStateID(Long stateID) {
		this.stateID = stateID;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stateID == null) ? 0 : stateID.hashCode());
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
		State other = (State) obj;
		if (stateID == null) {
			if (other.stateID != null)
				return false;
		} else if (!stateID.equals(other.stateID))
			return false;
		return true;
	}
}
