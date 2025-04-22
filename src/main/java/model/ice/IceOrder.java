package model.ice;
//組合設計模式
public class IceOrder {
	//自己加的
	private static int count = 0;
	private int id;
	//自己加的
	
	private MainDish mainDish;
	private Topping topping;
	private int totalPrice;
	
	public IceOrder(String mainDishName,String[] toppingArray) {
		this(new MainDish(mainDishName),new Topping(toppingArray));
		//呼叫底下建構子  兩種可能我們都要考慮
	}
	public IceOrder(MainDish mainDish,Topping topping) {
		//自己加的
		this.id = ++count;
		//自己加的
		this.mainDish = mainDish;
		this.topping = topping;
		this.totalPrice = mainDish.getPrice() + topping.calculateToppingPrice();		
	}
	//自己加的
	public int getId() {
		return id;
	}
	//自己加的
	public MainDish getMainDish() {
		return mainDish;
	}
	public Topping getTopping() {
		return topping;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	
	
	
}
