package test;

import java.util.ArrayList;

import dao.OrderDAO;
import model.PhieuOrder;

public class test{
	public static void main(String[] args){
		PhieuOrder p = new PhieuOrder("A", "ban2", "099999", "ncCam", 1, 20000, "2/6/2024");
		OrderDAO d = new OrderDAO();
		String ban = "ban2";
		PhieuOrder f = new PhieuOrder("b", "ban5", "0999f9", "ncOi", 1, 30000, "4/6/2024");
		
		ArrayList<PhieuOrder>  listSort = new ArrayList<>();
		listSort = d.Sort();
		
		for(PhieuOrder po : listSort) {
			System.out.println(po);
		}
		
		
	}
}
