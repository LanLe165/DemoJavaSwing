package dao;

import java.util.ArrayList;

import model.PhieuOrder;

public interface IDao<T> {
	void Save(T t);
	
	void Delete(String ban);
	
	ArrayList<T> Find(String ban);
	
	ArrayList<T> ShowAll();
	
	ArrayList<T> Sort();
	
}
