package model;

import java.util.*;
import java.util.function.BiPredicate;

/*
 可擴充:rules.add(...)
 邏輯可分離: 條件與邏輯分開
 容易測試
 可以利用lambda開發與理解上較為直觀 
 
 */
//這是我自己寫的爛判斷


public class CoffeeT {
	private String coffeeType;
	private Double milkMl;
	private Double coffeeMl;
	private String describe;
	
	
	public CoffeeT(String milkMl, String coffeeMl) {	
		this.milkMl = Double.parseDouble(milkMl);
		this.coffeeMl = Double.parseDouble(coffeeMl);
		check();
	}
	
	//判斷牛奶與咖啡的比例
	public void check() {
		String coffeeType ="";
		String describe ="";
		
		if(milkMl >= (3*coffeeMl)) {
			coffeeType = "濃郁的拿鐵";
			describe = "牛奶的比例遠高於咖啡，味道偏向牛奶。";
		} else if (milkMl >= (1.5*coffeeMl)) {
			coffeeType = "平衡的拿鐵咖啡";
			describe = "牛奶與咖啡的比例較為平衡，風味溫和。";
		}  else if (milkMl == coffeeMl) {
			coffeeType = "標準卡布奇諾";
			describe = "牛奶與咖啡的比例恰到好處，典型的卡布奇諾。";
		}  else if (coffeeMl >= 3*milkMl) {
			coffeeType = "濃縮咖啡";
			describe = "咖啡的比例遠高於牛奶，口感濃烈，偏向純咖啡。";
		}  else {
			coffeeType = "普通咖啡";
			describe = "牛奶與咖啡的比例較為普通，適合日常飲用。";
		} 
		this.coffeeType = coffeeType;
		this.describe = describe;
	}

	public String getCoffeeType() {
		return coffeeType;
	}

	public Double getMilkMl() {
		return milkMl;
	}

	public Double getCoffeeMl() {
		return coffeeMl;
	}

	public String getDescribe() {
		return describe;
	}
	
	
	
	
	
	

}
