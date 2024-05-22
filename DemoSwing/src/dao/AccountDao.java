package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Account;
import model.PhieuOrder;

public class AccountDao {
	public static void insert(Account a) {
		Connection conn = JDBCUtil.getConnection();
		
		String sql = "INSERT into taikhoan value "
				+ "(?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getUsername());
			ps.setString(2, a.getPassword());
			
			ps.executeUpdate();
			
			System.out.println("Insert");
			
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Account> find(String tentaikhoan){
		ArrayList<Account> findList = new ArrayList<>();
		Connection conn = JDBCUtil.getConnection();
		Account a = null;
		
		String sql = "SELECT * from taikhoan "
				+ "WHERE tentaikhoan = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tentaikhoan);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("tentaikhoan");
				String password = rs.getString("matkhau");
				
				a = new Account(username, password);
				
				findList.add(a);
			}
			
			System.out.println("find");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return findList;
	}
}
