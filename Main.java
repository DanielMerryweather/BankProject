/**
 * @author Harrison Fah
 * @version 1.2
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static FileLoader fl = new FileLoader();
	public static Scanner keyboardWord = new Scanner(System.in);
	
	/**
	 * Checks to make sure password entered is correct
	 * 
	 * @param password Password entered
	 * @param ms Master account associated
	 * @return Returns the state boolean
	 */
	public static boolean passwordCheck(String password, MasterAccount ms) {
		boolean state = password.equals(ms.getPass());
		if (!state) {
			System.out.println("Password is incorrect, please re-enter.");
		}
		return state;
	}
	
	/**
	 * Method for creating an account and adding it to the arraylist
	 */
	public static void createAccount() {
		System.out.println("What would you like to name the account?");
		String accName = keyboardWord.nextLine();
		System.out.println("What would you like the pasword to be?");
		String accPass = keyboardWord.nextLine();
		int newId = fl.addMasterAccount(new MasterAccount(0,accName,accPass,new ArrayList<Account>()));
		System.out.println("Account created with:\nName: " + accName + "\nPassword: " + accPass + "\nID: " + newId);
		main(null);
	}
	
	/**
	 * Deletes a specified account
	 */
	public static void deleteAccount(){
		System.out.println("What is the id of the account you want to delete?");
		int idChosen = getInt();
		while(fl.getMasterAccount(idChosen) == null){
			System.out.println("Please enter a valid id");
			idChosen = getInt();
		}
		MasterAccount ms = fl.getMasterAccount(idChosen);
		System.out.println("What is the password to the account?");
		String password = keyboardWord.nextLine();
		while (!passwordCheck(password, ms)) {
			password = keyboardWord.nextLine();
		}
		fl.deleteMasterAccount(fl.getMasterAccount(idChosen));
		System.out.println("Account deleted");
		main(null);
	}
	
	/**
	 * Allows user to enter id for account and then password to edit that account
	 */
	public static void enterAccount(){
		System.out.println("What is the account id?");
		int id = getInt();
		int attempts = 5;
		while (fl.getMasterAccount(id) == null){
			System.out.println("Please enter a valid id");
			id = getInt();
		}
		MasterAccount ms = fl.getMasterAccount(id);
		System.out.println("What is the password to the account?");
		String password = keyboardWord.nextLine();
		while (!passwordCheck(password, ms) && attempts > 0) {
			attempts--;
			password = keyboardWord.nextLine();
		}
		if(attempts == 0){
			System.out.println("Too many incorrect passwords, returning to main menu.");
			main(null);
		}else{
			accountMenu(ms);
		}
		
	}
	
	/**
	 * Allows user to edit, add, or delete sub-accounts
	 * 
	 * @param ms Master account entered
	 */
	public static void accountMenu(MasterAccount ms){
		System.out.println("Would you like to:\n1. Edit account(s)\n2. Add sub-account\n3. Delete sub-account\n4. Exit");
		int numTyped = getInt(4);
		if (numTyped == 1) {
			editSub(ms);
		} else if (numTyped == 2) {
			addSub(ms);
		}
		else if (numTyped == 3){
			deleteSub(ms);
		}
		else if (numTyped == 4){
			main(null);
		}
	}
	
	/**
	 * Checks to make sure user has entered a valid number between 1 and max
	 * 
	 * @param max Maximum value allowed
	 * @return Returns the valid number entered by user
	 */
	public static int getInt(int max){
		int amount = 0;
		String in = "";
		Scanner kb = new Scanner(System.in);
		while(true){
			in = kb.nextLine();
			try{
				amount = Integer.parseInt(in);
			}catch(Exception e){
				System.out.println("Invalid input, try again");
				continue;
			}
			if(amount > 0 && amount <= max){
				break;
			}else{
				System.out.println("Invalid input, please try a positive value between 1-"+max);
			}
		}
		return amount;
	}
	
	/**
	 * Checks to make sure user has entered a valid number
	 * 
	 * @return Returns valid number entered by user
	 */
	public static int getInt(){
		int amount = 0;
		String in = "";
		Scanner kb = new Scanner(System.in);
		while(true){
			in = kb.nextLine();
			try{
				amount = Integer.parseInt(in);
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
	
	/**
	 * Checks to make sure user enters valid double
	 * 
	 * @return Returns valid double user enters
	 */
	public static double getDoubleInput(){
		double amount = 0;
		String in = "";
		Scanner kb = new Scanner(System.in);
		while(true){
			in = kb.nextLine();
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
	
	/**
	 * Allows user to edit sub-accounts by depositing, withdrawing or checking balance
	 * 
	 * @param ms Master account entered
	 */
	public static void editSub(MasterAccount ms){
		System.out.println("Sub-accounts in account are:");
		ConsolePrinting.printAccounts(ms.accounts);
		System.out.println("Which account would you like to edit? (Enter exact name or type 'exit')");
		String accChosen = keyboardWord.nextLine();
		while (!accChosen.equals("Savings") && !accChosen.equals("Chequing") && !accChosen.equals("exit")) {
			System.out.println("Please enter a correct name.");
			accChosen = keyboardWord.nextLine();
		}
		accChosen = checkSubState(ms, accChosen);
		if (accChosen.equals("exit")){
			accountMenu(ms);
		}
		Account currAcc = ms.loadAccount(accChosen);
		System.out.println("Would you like to:\n1. Deposit\n2. Withdraw\n3. Check balance\n4. Exit");
		int numTyped2 = getInt(4);
		if (numTyped2 == 1) {
			currAcc.deposit();
			ms.saveAccount(currAcc);
			fl.saveMasterAccount(ms);
			fl.fileWriter(fl.accountArray);
			editSub(ms);
		} else if (numTyped2 == 2) {
			currAcc.withdraw();
			ms.saveAccount(currAcc);
			fl.saveMasterAccount(ms);
			fl.fileWriter(fl.accountArray);
			editSub(ms);
		} else if (numTyped2 == 3) {
			System.out.println("Account balance is: " + currAcc.getBalance());
			editSub(ms);
		} else if (numTyped2 == 4) {
			accountMenu(ms);
		}
	}
	
	/**
	 * Allows user to create either a savings or chequing account if one has no already been created
	 * 
	 * @param ms Master account enetered
	 */
	public static void addSub(MasterAccount ms){
		System.out.println("Would you like to create a:\n1.Savings account\n2.Chequing account\n3.Exit");
		int userInput = getInt(3);
		if (userInput == 1) {
			if(ms.loadAccount("Savings")!=null){
				System.out.println("There is already a Savings sub account.");
			}else{
				System.out.println("How much money will be in the account?");
				double baseAmount = getDoubleInput();
				ms.addAccount(new Account(baseAmount, "Savings"));
				fl.saveMasterAccount(ms);
				fl.fileWriter(fl.accountArray);
			}
		} else if (userInput == 2 && ms.loadAccount("Chequing")==null) {
			if(ms.loadAccount("Chequing")!=null){
				System.out.println("There is already a Chequings sub account.");
			}else{
				System.out.println("How much money will be in the acount?");
				double baseAmount = getDoubleInput();
				ms.addAccount(new Account(baseAmount, "Chequing"));
				fl.saveMasterAccount(ms);
				fl.fileWriter(fl.accountArray);
			}
		}
		else if (userInput == 3){
			accountMenu(ms);
		}
		accountMenu(ms);
	}
	
	/**
	 * Allows user to delete sub-account
	 * 
	 * @param ms Master account entered
	 */
	public static void deleteSub(MasterAccount ms){
		System.out.println("Sub-accounts in account are:");
		ConsolePrinting.printAccounts(ms.accounts);
		System.out.println("Which account would you like to delete? (Enter exact name or type 'exit')");
		String accChosen = keyboardWord.nextLine();
		while (!accChosen.equals("Savings") && !accChosen.equals("Chequing") && !accChosen.equals("exit")) {
			System.out.println("Please enter a correct name.");
			accChosen = keyboardWord.nextLine();
		}
		accChosen = checkSubState(ms, accChosen);
		if (accChosen.equals("exit")){
			accountMenu(ms);
		}
		ms.deleteAccount(accChosen);
		fl.saveMasterAccount(ms);
		fl.fileWriter(fl.accountArray);
		accountMenu(ms);
	}
	
	/**
	 * Checks to see if an account exists with name that user has input and if not then make user input valid name
	 * 
	 * @param ms Master account enetered
	 * @param accName Account name user has entered
	 * @return Returns the valid account name
	 */
	public static String checkSubState(MasterAccount ms, String accName){
		while (ms.loadAccount(accName) == null && !accName.equals("exit")){
			System.out.println("There is no sub-account with that name. Please re-enter or type 'exit'");
			accName = keyboardWord.nextLine();
		}
		return accName;
	}
	
	/**
	 * Main method in which user is allowed to enter, create, or delete a master account
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ConsolePrinting.title();
		System.out.println(
				"\nWould you like to:\n1. Enter account\n2. Create account\n3. Delete account\n4. Shut down");
		int mainChoice = getInt(4);
		if (mainChoice == 1) {
			enterAccount();
		} else if (mainChoice == 2) {
			createAccount();
		} else if (mainChoice == 3) {
			deleteAccount();
		}
		else if (mainChoice == 4){
			System.out.println("Thank you for choosing DHP Bank.");
			System.exit(0);
		}
	}
}