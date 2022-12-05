package pongPackage;

import java.util.ArrayList;

public class UserList implements java.io.Serializable{

		UserCreate testUser = new UserCreate ("testUser",10000);
		ArrayList<UserCreate> users = new ArrayList<UserCreate>();
		
		public UserList() {
			users.add(testUser);
		}
		
		boolean checkName(String name) {
			for(UserCreate u : users) {
				if (u.getName() == name){
					return true;
				}
			}
			return false;
		}
		void addNewUser(String name) {
			if (checkName(name) == false) {
				UserCreate newUser = new UserCreate(name);
				users.add(newUser);
			}
			
		}
}
