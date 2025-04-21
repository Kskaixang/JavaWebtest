package case2;

import java.util.ArrayList;

import model.Guestbook;

import java.util.*;

public class GuestbookMain {
	//希望有一個存放所有留言的集合	
	private static List<Guestbook> guestbook = new ArrayList<>();  
	
	public static void main(String[] args) {
		//留言
		Guestbook g1 = new Guestbook("留言文字A");
		guestbook.add(g1); //存入留言
		Guestbook g2 = new Guestbook("留言文字B");
		guestbook.add(g2); //存入留言
		
		System.out.println(guestbook);

	}

}
