package com.fa.BlueHouse.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class IdAssets implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "ID_TAI_SAN")
	String idAsset;
	@Column(name = "VI_TRI")
	String location;
	
	
	public IdAssets() {
		super();
	}
	public IdAssets(String idAsset, String location) {
		super();
		this.idAsset = idAsset;
		this.location = location;
	}
	public String getIdAsset() {
		return idAsset;
	}
	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idAsset, location);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdAssets other = (IdAssets) obj;
		return Objects.equals(idAsset, other.idAsset) && Objects.equals(location, other.location);
	}
	
	
}
