package util;
//工具類
public class Util {
	//判斷是否是浮點數
	public static boolean isDouble(String data) {
		try {
			Double.parseDouble(data);
			//如果轉入parse通過 不會拋異常
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	public static boolean isNumber(String data) {
		try {
			Integer.parseInt(data);
			//如果轉入parseInt通過 不會拋異常
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
