package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import model.Coffee.CoffeeRule;

public class PhonePlan {
	/*
	 通話 > 1000 分鐘 or 流量 > 50 GB → 商務型($1499)
    通話 > 500 分鐘 and 流量 > 10 GB → 一般用戶型($660)
    流量 < 1 GB and 通話 < 200 分鐘 → 長輩節省型($200)
	 */
	private Integer minutes;
	private Integer gb;	
	
	//內部類 提供對照表
	static class PhoneRule{		
		private String type;//coffee type name		
		private String description;//coffee describe
		private Integer price;
		private BiPredicate<Integer,Integer> condition;//設定一個機器介面
		public PhoneRule(String type, String description, Integer price, BiPredicate<Integer, Integer> condition) {
			this.type = type;
			this.description = description;
			this.price = price;
			this.condition = condition;
		}
		//包裝 機器介面 等待重寫的方法 
		public boolean matches(Integer minutes,Integer gb) {
			return condition.test(minutes, gb);
		}
		public String getResult() {
			return description + " -> " + type + "($" + price + ")";
		}
	}
	//////////////這邊是本類///////////////////////////////

	public PhonePlan(Integer minutes, Integer gb) {
		this.minutes = minutes;
		this.gb = gb;
	}
	
	//
	private static final List<PhoneRule> rules = new ArrayList<>();
	static {
		/*
		 通話 > 1000 分鐘 or 流量 > 50 GB → 商務型($1499)
	    通話 > 500 分鐘 and 流量 > 10 GB → 一般用戶型($660)
	    流量 < 1 GB and 通話 < 200 分鐘 → 長輩節省型($200)
		 */
		rules.add(new PhoneRule("商務型", "通話 > 1000 分鐘 or 流量 > 50 GB", 1499,(min, gb) -> (min > 1000 || gb > 50) ));
		rules.add(new PhoneRule("一般用戶型", "通話 > 500 分鐘 and 流量 > 10 GB",660,(min, gb) -> (min > 500 && gb > 10) ));
		rules.add(new PhoneRule("長輩節省型", "流量 < 1 GB and 通話 < 200 分鐘", 200,(min, gb) -> (min < 200 && gb < 1) ));	
	}
	
	public String getPhonePlan() {
		return rules.stream()
				.filter(rule -> rule.matches(minutes,gb)) //找出符合條件的規則	因為機器介面 會回傳布林值 讓你篩選出			
				.findFirst() //取得第一筆 匹配的
				.map(PhoneRule::getResult) //轉換成字串 方法參考  =   map(rule -> rule.getResult())
				.orElse("無法辨識的類型"); //
	}
	
	
	public double getMinutes() {
		return minutes;
	}
	public double getGb() {
		return gb;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
