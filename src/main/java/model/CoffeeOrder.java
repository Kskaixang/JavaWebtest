package model;

import java.util.Map;

public class CoffeeOrder {
	private String type;
	private String size;
	private Boolean sugar;
	private int price;
	//高頻交易時  final 定值 速度較快
	private static final Map<String,Map<String,Integer>> priceTable = Map.of(
			"latte",Map.of("S",50  ,"M",70  ,"L",90),
			"mocha",Map.of("S",45  ,"M",55  ,"L",65),
			"americano",Map.of("S",40  ,"M",45  ,"L",60),
			"cappuccino",Map.of("S",55  ,"M",80  ,"L",100)
			);
	
	private static final Map<String,String> sizeTable = Map.of("S","小", "M","中", "L","大");
	private static final Map<Boolean,String> sugarTable = Map.of(true,"有糖", false,"無糖");
	
	public CoffeeOrder (String type, String size, String suger) {
		this.type = type;
		this.size = size;
		this.sugar = Boolean.parseBoolean(suger);
		this.price = priceTable.get(type.toLowerCase()).get(size);
	}
	
	public String getInfo() {
		//使用者輸入好的size轉成大寫 再進行查找
		String sizeText = sizeTable.get(size.toUpperCase());
		String sugarText = sugarTable.get(sugar);
		return String.format("您點了一杯%s杯 %s 咖啡（%s）價格：%d 元",sizeText,type,sugarText,price);
	}

	public String getType() {
		return type;
	}

	public String getSize() {
		return size;
	}

	public Boolean getSugar() {
		return sugar;
	}

	public int getPrice() {
		return price;
	}
	
	

}
