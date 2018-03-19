package defaultpackage;

import java.util.Scanner;

/**
 * @author Punit Thanki
 *Start Date:
 *End Date: 
 *
 */
public class Account {
	public String id;
	public double balance;
	Scanner input = new Scanner(System.in);
	public Account(){
		this.id = "";
		this.balance = 0;
	}
	public Account(double balance, String id){
		this.id = id;
		this.balance = balance;
	}
	public void deposit(){
		System.out.println("How much would you like to deposit?");
		double amountD = input.nextDouble();
		while(amountD<0){
			System.out.println("Invalid input!! Please please enter a number greater than 0");
			this.balance+=amountD;
		}
		while(!input.hasNextInt()){
			System.out.println("That is not a valid input!! Please enter a number");
			input.next();
		}
		this.balance+=amountD;				
		
	}
	public void withdraw(){
		System.out.println("How much would you like to withdraw?");
		double amountW = input.nextDouble();
		while(balance<amountW){
			System.out.println("Insufficient Funds! You only have" + balance + "dollars");
		}
		while(amountW<0){
			System.out.println("Invalid input!! Please please enter a number greater than 0");
			this.balance-=amountW;
		}
		if(balance>amountW){
			this.balance-=amountW;
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}



