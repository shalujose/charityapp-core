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

	/*
	 * private int transaction_id; private String date_of_transaction; private int
	 * fundrequest_id; private int cate_id; private int donor_id; private double
	 * amount; private String name;
	 * 
	 * public int getTransaction_id() { return transaction_id; }
	 * 
	 * public void setTransaction_id(int transaction_id) { this.transaction_id =
	 * transaction_id; }
	 * 
	 * public String getDate_of_transaction() { return date_of_transaction; }
	 * 
	 * @Override public String toString() { return "Transaction [transaction_id=" +
	 * transaction_id + ", date_of_transaction=" + date_of_transaction +
	 * ", fundrequest_id=" + fundrequest_id + ", cate_id=" + cate_id + ", donor_id="
	 * + donor_id + ", amount=" + amount + ", name=" + name + "]"; }
	 * 
	 * public void setDate_of_transaction(String date_of_transaction) {
	 * this.date_of_transaction = date_of_transaction; }
	 * 
	 * public int getFundrequest_id() { return fundrequest_id; }
	 * 
	 * public void setFundrequest_id(int fundrequest_id) { this.fundrequest_id =
	 * fundrequest_id; }
	 * 
	 * public int getDonor_id() { return donor_id; }
	 * 
	 * public void setDonor_id(int donor_id) { this.donor_id = donor_id; }
	 * 
	 * public double getAmount() { return amount; }
	 * 
	 * public void setAmount(double amount) { this.amount = amount; }
	 * 
	 * public int getCate_id() { return cate_id; }
	 * 
	 * public void setCate_id(int cate_id) { this.cate_id = cate_id; }
	 * 
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 */

}
