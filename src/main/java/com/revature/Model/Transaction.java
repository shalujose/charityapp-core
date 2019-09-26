package com.revature.model;

public class Transaction {
	
	private int transactionId;
	private String dateOfTransaction;
	private int fundrequestId;
	private int categoryId;
	private int donorId;
	private double amount;
	private String name;
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", dateOfTransaction=" + dateOfTransaction
				+ ", fundrequestId=" + fundrequestId + ", categoryId=" + categoryId + ", donorId=" + donorId
				+ ", amount=" + amount + ", name=" + name + "]";
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(String dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public int getFundrequestId() {
		return fundrequestId;
	}
	public void setFundrequestId(int fundrequestId) {
		this.fundrequestId = fundrequestId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
