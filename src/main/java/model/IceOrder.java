package model;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class IceOrder {
	private static int count = 0;
	private int id = 0;
	private String mainDish;
	private String[] toppings;
	private int price;
	private Date date;
	
	public IceOrder(String mainDish, String[] toppings) {
		count++;
		id = count;
		this.mainDish = mainDish;
		this.toppings = toppings;
		this.price = checkMainDish(mainDish) +  toppings.length * 10 ;
		this.date = new Date();
	}
	
	public int checkMainDish(String mainDish) {
		if(mainDish.equals("剉冰")) {
			return 50;
		} else {
			return 40;
		}
	}

	public String getInfor() {
		return "IceOrder [mainDish=" + mainDish + ", toppings=" + Arrays.toString(toppings) + ", price=" + price
				+ ", date=" + date + "]";
	}

	public String getMainDish() {
		return mainDish;
	}

	public String[] getToppings() {
		return toppings;
	}

	public int getPrice() {
		return price;
	}

	public Date getDate() {
		return date;
	}

	public int getId() {
		return id;
	}
	
	
	

}
