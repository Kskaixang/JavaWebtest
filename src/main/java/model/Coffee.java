package model;

import java.util.*;
import java.util.function.BiPredicate;

/*
 可擴充:rules.add(...)
 邏輯可分離: 條件與邏輯分開
 容易測試
 可以利用lambda開發與理解上較為直觀  別再用IF else了
 */
//這是老師寫的 應用到lambda predicate介面


public class Coffee {
	private String coffeeType;
	private Double milkMl;
	private Double coffeeMl;
	private String describe;
	
	//建立一個內部類來代表一種咖啡類型的判斷 規則   存放 規則
	static class CoffeeRule{
		//coffee type name
		private String type;
		//coffee describe
		private String description;
		//Founction Interfaces 機器
		private BiPredicate<Double,Double> condition;
		
		public CoffeeRule(String type, String description,BiPredicate<Double,Double> condition) {
			this.type = type;
			this.description = description;
			this.condition = condition;
		}
		public boolean matches(Double milkMl,Double coffeeMl) {
			return condition.test(milkMl, coffeeMl);
		}
		public String getResult() {
			return type + ":" + description;
		}		
	}
	
	//儲存咖啡規則的清單
	private static final List<CoffeeRule> rules = new ArrayList<>();
	//如果你用List.of 將來就不能添加了 所以我們才會另外寫 靜態塊
	
	//建構子區段 每次創建 重創內容
	{
		
	}
	//靜態區塊 不必每次創建 重建 加載時就在記憶體裡
	static {
		//初始化規則 CoffeeRule(String type, String description,BiPredicate<Double,Double> condition) 用lambda重寫好介面
		rules.add(new CoffeeRule("濃郁的拿鐵", "牛奶的比例遠高於咖啡，味道偏向牛奶。", (milkMl,coffeeMl) -> milkMl >= 3 * coffeeMl));
		rules.add(new CoffeeRule("平衡的拿鐵咖啡", "牛奶與咖啡的比例較為平衡，風味溫和。", (milkMl,coffeeMl) -> milkMl >= 1.5 * coffeeMl));
		//因為物件相比== 要用精確比較 equlse 或是轉字面值
		rules.add(new CoffeeRule("標準卡布奇諾", "牛奶與咖啡的比例恰到好處，典型的卡布奇諾。", (milkMl,coffeeMl) -> milkMl.doubleValue() == coffeeMl.doubleValue()));
		rules.add(new CoffeeRule("濃縮咖啡", "咖啡的比例遠高於牛奶，口感濃烈，偏向純咖啡。", (milkMl,coffeeMl) -> 3 * milkMl <= coffeeMl));
		rules.add(new CoffeeRule("普通咖啡", "牛奶與咖啡的比例較為普通，適合日常飲用。", (milkMl,coffeeMl) -> true));
	}	
	//Servlet建構
	public Coffee(String milkMl, String coffeeMl) {	
		this.milkMl = Double.parseDouble(milkMl);
		this.coffeeMl = Double.parseDouble(coffeeMl);
	}
	//Java test建構
	public Coffee(Double milkMl, Double coffeeMl) {	
		this.milkMl = milkMl;
		this.coffeeMl = milkMl;
	}

	public String getcoffeeType() {
		return rules.stream()
				.filter(rule -> rule.matches(milkMl,coffeeMl)) //找出符合條件的規則	因為機器介面 會回傳布林值 讓你篩選出			
				.findFirst() //取得第一筆 匹配的
				.map(CoffeeRule::getResult) //轉換成字串 方法參考  =   map(rule -> rule.getResult())
				.orElse("無法辨識的類型"); //
	}
	
	public Double getMilkMl() {
		return milkMl;
	}

	public Double getCoffeeMl() {
		return coffeeMl;
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	
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

	

	public String getDescribe() {
		return describe;
	}
	
	*/
	
	
	
	

}
