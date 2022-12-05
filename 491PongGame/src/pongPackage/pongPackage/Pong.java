package pongPackage;

import java.io.*;
public class Pong {

	static UserList users;
	
	private static void saveList() {
	
		try {
			FileOutputStream fos = new FileOutputStream("userList");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.flush();
			oos.close();
			System.out.println("users saved");
		} 
		catch (Exception e) {
			System.out.println("users not saved correctly!");
		}
	}
	
	private static void loadList() {
		try {
			FileInputStream fis = new FileInputStream("userList");
			ObjectInputStream ois = new ObjectInputStream(fis);
			users = (UserList) ois.readObject();
			ois.close();
			System.out.println("users loaded");
		}
		catch (Exception e) {
			System.out.println("users load error!");
		}
	}
	public static void main(String[] args){

		StartFrame sFrame = new StartFrame();
		sFrame.setVisible(true);
	}
	
}
