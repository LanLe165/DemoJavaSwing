package controller;

import java.util.ArrayList;

import dao.AccountDao;
import model.Account;

public class AccountController {
	private String key = "keyAdmin";
	
	public AccountController() {
		
	}

	public static int checkAccount(String username, String password) {
		
		ArrayList<Account> list = new ArrayList<>();
		AccountDao ad = new AccountDao();
		
		list = ad.find(username);
		
		for(Account a : list) {
			if(a.getPassword().equals(password)) {
				return 1;
			}
		}
		
		return 0;
	}
	
	public int register(String key) {
		if(this.key.equals(key)) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
	}
}
