package defaultpackage;

import java.util.Scanner;

public class Account {
	String id;
	public double balance;
	Scanner input = new Scanner(System.in);
	public Account(double balance, String i){
		String id;
		this.id = 0;
		this.balance = 0;
	}
	public Account(double balance, String id){
		this.id = id;
		this.balance = balance;
	}
	public void deposit(){
		System.out.println("How much would you like to deposit?");
		double amountD = input.nextDouble();
		amountD = balance + amountD;
		
	}
	public void withdraw(){
		System.out.println("How much would you like to withdraw?");
		double amountW = input.nextDouble();
		while(balance<amountW){
			System.out.println("Insufficient Funds! You only have" + balance + "dollars");
		}
		if(balance>amountW){
			amountW = balance - amountW;
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public static void main(String[] args){
		

	}

}


