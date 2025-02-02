package com.geek;
public class StaticApp {
public static void main(String[] args) {
	Account.setRoi(6.5f);
	Account a1=new Account();
	a1.setAccNo(1234);
	a1.setAccHolderName("ABC");
	a1.setBalance(1000);
	System.out.println(a1.getRoi());
	Account a2=new Account();
	a2.setAccNo(98709);
	a2.setAccHolderName("XYZ");
	a2.setBalance(10000);
	System.out.println(a2.getRoi());
	a1=null;
	System.out.println(a1.getRoi());
	//System.out.println(a1.getAccHolderName());//NULLPointerException
}
}
class Account{
	private int accNo;
	private String accHolderName;
	private float balance;
	private static float roi;
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public static float getRoi() {
		return roi;
	}
	public static void setRoi(float roi) {
		Account.roi = roi;
	}
	
}