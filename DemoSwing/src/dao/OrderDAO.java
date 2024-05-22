package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import database.JDBCUtil;
import model.PhieuOrder;
import view.CafeFrame;

public class OrderDAO implements IDao<PhieuOrder>{
	
	@Override
	public void Save(PhieuOrder p) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtil.getConnection();
		
		String sql = "INSERT into quanli value "
				+ "(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getTenKhachHang());
			ps.setString(2, p.getBan());
			ps.setString(3, p.getSoDienThoai());
			ps.setString(4, p.getMonAn_DoUong());
			ps.setInt(5, p.getSoLuong());
			ps.setDouble(6, p.getGia());
			ps.setString(7, p.getNgay());
			
			ps.executeUpdate();
			
			System.out.println("SAVE");
			
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void Delete(String ban) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtil.getConnection();
		
		String sql = "DELETE from quanli "
				+ "WHERE ban = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ban);
			
			ps.executeUpdate();
			
			System.out.println("DELETE");
			
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<PhieuOrder> Find(String ban) {
		// TODO Auto-generated method stub
		PhieuOrder p = null;
		
		ArrayList<PhieuOrder> list = new ArrayList<>();
		
		Connection conn = JDBCUtil.getConnection();
		
		String sql = "SELECT * from quanli "
				+ "WHERE ban = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ban);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String tenKhachHang = rs.getString("tenkhachhang");
				String ban1 = rs.getString("ban");
				String soDienThoai = rs.getString("sodienthoai");
				String monAn_DoUong = rs.getString("monandouong");
				int soLuong = rs.getInt("soLuong");
				double gia = rs.getDouble("gia");
				String ngay = rs.getString("ngay");
				
				p = new PhieuOrder(tenKhachHang, ban1, soDienThoai, monAn_DoUong, soLuong, gia, ngay);
				
				list.add(p);
			}
			
			System.out.println("find");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<PhieuOrder> ShowAll() {
		// TODO Auto-generated method stub
		ArrayList<PhieuOrder> listShow = new ArrayList<>();
		
		Connection conn = JDBCUtil.getConnection();
		
		String sql = "SELECT * from quanli";	
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String tenKhachHang = rs.getString("tenkhachhang");
				String ban1 = rs.getString("ban");
				String soDienThoai = rs.getString("sodienthoai");
				String monAn_DoUong = rs.getString("monandouong");
				int soLuong = rs.getInt("soLuong");
				double gia = rs.getDouble("gia");
				String ngay = rs.getString("ngay");
				
				PhieuOrder p = new PhieuOrder(tenKhachHang, ban1, soDienThoai, monAn_DoUong, soLuong, gia, ngay);
				
				listShow.add(p);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listShow;
	}

	@Override
	public ArrayList<PhieuOrder> Sort() {
		// TODO Auto-generated method stub
		ArrayList<PhieuOrder> listSort = new ArrayList<>();
		
		Connection conn = JDBCUtil.getConnection();
		
		String sql = "SELECT * from quanli "
				+ "ORDER BY ban";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String tenKhachHang = rs.getString("tenkhachhang");
				String ban1 = rs.getString("ban");
				String soDienThoai = rs.getString("sodienthoai");
				String monAn_DoUong = rs.getString("monandouong");
				int soLuong = rs.getInt("soLuong");
				double gia = rs.getDouble("gia");
				String ngay = rs.getString("ngay");
				
				PhieuOrder p = new PhieuOrder(tenKhachHang, ban1, soDienThoai, monAn_DoUong, soLuong, gia, ngay);
				
				listSort.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listSort;
	}


}
