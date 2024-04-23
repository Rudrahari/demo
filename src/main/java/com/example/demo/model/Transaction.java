package com.example.demo.model;

public class Transaction {
	private String transactiontype;
	private double amount;
	private int transactionid;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(String transactiontype, double amount, int transactionid) {
		super();
		this.transactiontype = transactiontype;
		this.amount = amount;
		this.transactionid = transactionid;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	@Override
	public String toString() {
		return "Transaction [transactiontype=" + transactiontype + ", amount=" + amount + ", transactionid="
				+ transactionid + "]";
	}
	

}
