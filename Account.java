
import java.util.Scanner;

public class Account {
	String id;
	public double balance;
	Scanner input = new Scanner(System.in);
	public Account(){
		this.id = "";
		this.balance = 100;
	}
	public Account(double balance, String id){
		this.id = id;
		this.balance = balance;
	}
	public void deposit(){
		System.out.println("How much would you like to deposit?");
		this.balance += getDoubleInput();
		System.out.println("New Balance: " + this.balance);
	}
	public void withdraw(){
		if(this.balance <= 0){
			System.out.println("Cannot withdraw from an account with no funds");
			return;
		}
		System.out.println("How much would you like to withdraw?");
		double amountW = getDoubleInput();
		while(balance<amountW){
			System.out.println("Insufficient Funds! You only have " + balance + " dollars");
			amountW = getDoubleInput();
		}
		this.balance -= amountW;
		System.out.println("New Balance: " + this.balance);
	}
	public double getDoubleInput(){
		double amount = 0;
		String in = "";
		while(true){
			in = input.nextLine();
			try{
				amount = Double.parseDouble(in);
			}catch(Exception e){
				System.out.println("Invalid input, try again");
				continue;
			}
			if(amount > 0){
				break;
			}else{
				System.out.println("Invalid input, please try a positive value");
			}
		}
		return amount;
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
	public static void main(String[] args){
		
		new Account().withdraw();

	}

}
