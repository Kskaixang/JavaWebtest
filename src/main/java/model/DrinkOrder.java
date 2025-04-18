package model;

import java.util.Map;

public class DrinkOrder {
	private String type;
	private String size;
	private Boolean ice;
	private int price;
	//高頻交易時  final 定值 速度較快
	private static final Map<String,Map<String,Integer>> priceTable = Map.of(
			"greenTea",Map.of("S",30  ,"M",40  ,"L",50),
			"blackTea",Map.of("S",45  ,"M",55  ,"L",65),
			"milkTea",Map.of("S",40  ,"M",45  ,"L",60)
			);
	
	
	private static final Map<Boolean,String> iceTable = Map.of(true,"有加冰",  false,"去冰");
	
	public DrinkOrder (String type, String size, String ice) {
		this.type = type;
		this.size = size;
		
		this.ice = ice.equalsIgnoreCase("yes");
		this.price = priceTable.get(type).get(size);
	}
	
	public String getInfo() {
		//使用者輸入好的size轉成大寫 再進行查找
		
		String iceText = iceTable.get(ice);
	
		//您點了一杯 milkTea（L，有加冰），價格為 65 元
		//您點了一杯 %s（%s，有加冰），價格為 %d 元, type,size,iceText,price
		return String.format("您點了一杯 %s（%s，%s），價格為 %d 元", type,size,iceText,price);
	}

	public String getType() {
		return type;
	}

	public String getSize() {
		return size;
	}

	public Boolean getice() {
		return ice;
	}

	public int getPrice() {
		return price;
	}
	
	

}
