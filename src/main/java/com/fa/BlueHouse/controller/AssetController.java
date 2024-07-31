package com.fa.BlueHouse.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fa.BlueHouse.entities.Assets;
import com.fa.BlueHouse.entities.IdAssets;

@RestController
@RequestMapping(path = "api/v1/Assets")
public class AssetController {
	@GetMapping("")
	public List<Assets> showAllAsset(){
		Assets as1 = new Assets();
		IdAssets id = new IdAssets("AS001", "KhuA");
		as1.setId(id);
		as1.setName("Bóng đèn");
		as1.setPriceOfAssets(10000);
		as1.setQuantityOfAssets(20);
		Assets as2 = new Assets();
		IdAssets id2 = new IdAssets("AS002", "KhuA");
		as2.setId(id2);
		as2.setName("Ghế");
		as2.setPriceOfAssets(50000);
		as2.setQuantityOfAssets(5);
		return List.of(as1,as2);
	}
}
