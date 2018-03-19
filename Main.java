import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void mains(String[] args) {
		FileLoader fl = new FileLoader();
		MasterAccount ms = new MasterAccount(1,"Daniel","test",new ArrayList<Account>());
		ms.accounts.add(new Account(1000,"Savings"));
		ms.accounts.add(new Account(2000,"Chequing"));
		fl.addToArray(ms);
		ms = new MasterAccount(2,"Harrison","test2",new ArrayList<Account>());
		ms.accounts.add(new Account(1500,"Savings"));
		ms.accounts.add(new Account(2500,"Chequing"));
		fl.addToArray(ms);
		fl.fileWriter(fl.accountArray);
	}
	
	public static void main(String[] args) {
		Scanner keyboardNum = new Scanner(System.in);
		Scanner keyboardWord = new Scanner(System.in);
		FileLoader fl = new FileLoader();
		System.out.println("Welcome to DHP Bank\nPlease enter your id.");
		int id = keyboardNum.nextInt();
		MasterAccount ms = fl.getMasterAccount(id);
		System.out.println("What is the password to the account?");
		String password = keyboardWord.nextLine();
		while(!passwordCheck(password, ms)){
			password = keyboardWord.nextLine();
		}
		for(Account a : ms.accounts){
			System.out.println("Account: "+a.id + ", Balance: "+a.balance);
		}
		//System.out.println("Which account would you like to edit?");
		
		Account currAcc = ms.loadAccount("Savings");
		currAcc.deposit();
		currAcc.withdraw();
		System.out.println("Account: "+currAcc.id + ", Balance: "+currAcc.balance);
		
	}
	
	public static boolean passwordCheck(String password, MasterAccount ms){
		boolean state = password.equals(ms.getPass());
		if(!state){
			System.out.println("Password is incorrect, please re-enter.");
		}
		return state;	
	}

}
