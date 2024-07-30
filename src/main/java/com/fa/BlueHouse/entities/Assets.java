package com.fa.BlueHouse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TAI_SAN")
public class Assets {
	@EmbeddedId
	IdAssets id;
	@Column(name = "TEN_TAI_SAN")
	String nameAsset;
	
	@Column(name = "SO_LUONG")
	int quantityOfAssets;
	@Column(name = "GIA_TIEN")
	long priceOfAssets;
	
	
	public Assets() {
		super();
	}

	public Assets( String nameAsset, int quantityOfAssets, long priceOfAssets) {
		super();
		this.nameAsset = nameAsset;
		this.quantityOfAssets = quantityOfAssets;
		this.priceOfAssets = priceOfAssets;
	}
	public String getNameAsset() {
		return nameAsset;
	}

	public void setNameAsset(String nameAsset) {
		this.nameAsset = nameAsset;
	}

	public int getQuantityOfAssets() {
		return quantityOfAssets;
	}

	public void setQuantityOfAssets(int quantityOfAssets) {
		this.quantityOfAssets = quantityOfAssets;
	}

	public long getPriceOfAssets() {
		return priceOfAssets;
	}

	public void setPriceOfAssets(long priceOfAssets) {
		this.priceOfAssets = priceOfAssets;
	}
	
}
