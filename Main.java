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
		System.out.println("Welcome to DHP Bank\nPlease enter your id.");
		int id = keyboardNum.nextInt();
		MasterAccount ms = fl.getMasterAccount(id);
		System.out.println("What is the password to the account?");
		String password = keyboardWord.nextLine();
		while (!passwordCheck(password, ms)) {
			password = keyboardWord.nextLine();
		}
		System.out.println("Would you like to:\n1. Edit account\2. Add Account");
		int numTyped = keyboardNum.nextInt();
		if (numTyped == 1) {
			System.out.println("Sub-accounts in account are:");
			for (Account a : ms.accounts) {
				System.out.println("Account: " + a.id + ", Balance: " + a.balance);
			}

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
				currAcc.getBalance();
			} else if (numTyped2 == 4) {

			}
		} else if (numTyped == 2) {

		}

	}

	public static boolean passwordCheck(String password, MasterAccount ms) {
		boolean state = password.equals(ms.getPass());
		if (!state) {
			System.out.println("Password is incorrect, please re-enter.");
		}
		return state;
	}

}