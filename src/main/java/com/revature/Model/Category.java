package com.revature.Model;

public class Category {
	private int category_id;
	private String category_name;
	public int getCategory_id() {
		return category_id;
	}
	@Override
	public String toString() {
		return " [category Id= " + category_id + "    category Name= " + category_name + "]";
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

}
