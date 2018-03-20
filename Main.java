import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void mains(String[] args) {
		FileLoader fl = new FileLoader();
		MasterAccount ms = new MasterAccount(1, "Daniel", "test", new ArrayList<Account>());
		ms.accounts.add(new Account(1000, "Savings"));
		ms.accounts.add(new Account(2000, "Chequing"));
		fl.addToArray(ms);
		ms = new MasterAccount(2, "Harrison", "test2", new ArrayList<Account>());
		ms.accounts.add(new Account(1500, "Savings"));
		ms.accounts.add(new Account(2500, "Chequing"));
		fl.addToArray(ms);
		fl.fileWriter(fl.accountArray);
	}

	public static void main(String[] args) {
		Scanner keyboardNum = new Scanner(System.in);
		Scanner keyboardWord = new Scanner(System.in);
		FileLoader fl = new FileLoader();
		//fl.addMasterAccount(new MasterAccount(0,"James","test4",new ArrayList<Account>()));
		System.out.println("Welcome to DHP Bank\nWould you like to:\n1. Enter account\n2. Create account\n3. Delete Account");
		int mainChoice = keyboardNum.nextInt();
		if (mainChoice == 1){
		int id = keyboardNum.nextInt();
		MasterAccount ms = fl.getMasterAccount(id);
		System.out.println("What is the password to the account?");
		String password = keyboardWord.nextLine();
		while (!passwordCheck(password, ms)) {
			password = keyboardWord.nextLine();
		}
		System.out.println("Would you like to:\n1. Edit account(s)\n2. Add Account");
		int numTyped = keyboardNum.nextInt();
		if (numTyped == 1) {
			System.out.println("Sub-accounts in account are:");
			for (Account a : ms.accounts) {
				System.out.println("Account: " + a.id + ", Balance: " + a.balance);
			}
			System.out.println("Which account would you like to edit?");

			String accChosen = keyboardWord.nextLine();
			while (!accChosen.equals("Savings") && !accChosen.equals("Chequing")) {
				System.out.println("Please enter a correct name.");
				accChosen = keyboardWord.nextLine();
			}
			Account currAcc = ms.loadAccount(accChosen);
			System.out.println("Would you like to:\n1. Deposit\n2. Withdraw\n3. Check balance\n4. Exit");
			int numTyped2 = keyboardNum.nextInt();
			if (numTyped2 == 1) {
				currAcc.deposit();
			} else if (numTyped2 == 2) {
				currAcc.withdraw();
				
			} else if (numTyped2 == 3) {
				System.out.println(currAcc.getBalance());
			} else if (numTyped2 == 4) {
				
			}
		} else if (numTyped == 2) {
			System.out.println("Would you like to create a:\n1.Savings account\n2.Chequing account");
			int userInput = keyboardNum.nextInt();
			if (userInput == 1){
				System.out.println("How much money will be in the account?");
				double baseAmount = keyboardNum.nextDouble();
				ms.addAccount(new Account(baseAmount,"Savings"));
				fl.saveMasterAccount(ms);
			}
			else if (userInput == 2){
				System.out.println("How much money will be in the acount?");
				double baseAmount = keyboardNum.nextDouble();
				ms.addAccount(new Account(baseAmount,"Chequing"));
			}
		}
		}
		else if (mainChoice == 2){
			
		}
		else if (mainChoice == 3){
			
		}

	}

	public static boolean passwordCheck(String password, MasterAccount ms) {
		boolean state = password.equals(ms.getPass());
		if (!state) {
			System.out.println("Password is incorrect, please re-enter.");
		}
		return state;
	}
	
	public static void createAccount(){
		Scanner keyboardNum = new Scanner(System.in);
		Scanner keyboardWord = new Scanner(System.in);
		System.out.println("What would you like to name the account?");
	}

}