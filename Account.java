package defaultpackage;
import java.util.Scanner;

/**
 * @author Punit Thanki
 * Start Date: 2018/03/14
 * End Date: 20180/03/19 
 * UserID: 20218002	
 * Version 1
 */

public class Account {
	String id;
	public double balance;	
	Scanner input = new Scanner(System.in);
	public Account(){
		this.id = "";
		this.balance = 100;
	}
	public Account(double balance, String id){// constructor with two arguments 
		this.id = id;
		this.balance = balance;
	}
	/**
	 * Deposit method so the user can add money to their account
	 */
	public void deposit(){
		System.out.println("How much would you like to deposit?");
		this.balance += getDoubleInput();//adds the amount of money the user puts in 
		System.out.println("New Balance: " + this.balance);
	}
	/**
	 * Withdraw method so the user can remove money to their account
	 */
	public void withdraw(){
		if(this.balance <= 0){// if the balance is 0 it does not allow the user to withdraw money
			System.out.println("Cannot withdraw from an account with no funds");
			return;
		}
		System.out.println("How much would you like to withdraw?");
		double amountW = getDoubleInput();
		while(balance<amountW){ //does not allow the user to withdraw more money then they already have in their account 
			System.out.println("Insufficient Funds! You only have " + balance + " dollars");
			amountW = getDoubleInput();
		}
		this.balance -= amountW;
		System.out.println("New Balance: " + this.balance);
	}
	/**
	 * method for the invalid input 
	 * @returns the amount 
	 */
	public double getDoubleInput(){
		double amount = 0;
		String in = "";
		while(true){// when the user inputs anything invalid like a letter this is true  
			in = input.nextLine();
			try{
				amount = Double.parseDouble(in);
			}catch(Exception e){ // does not allow the user to input anything else other than a number 
				System.out.println("Invalid input, try again");
				continue;
			}
			if(amount > 0){// if the user enters a amount less than 0 it does not let them 
				break;
			}else{
				System.out.println("Invalid input, please try a positive value");
			}
		}
		return amount;
	}
	/**
	 * getters and setters 
	 * @returns the balance 
	 */
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
	public static void main(String[] args){
		
		new Account().withdraw();

	}

}

