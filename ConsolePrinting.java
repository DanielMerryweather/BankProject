import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * ID: 50018003
 * By: Daniel Merryweather
 * Version: 1.1
 * Creation Date: 20/03/2018
 * Finish Date: 20/03/2018
 */

public class ConsolePrinting {
	
	/**
	 * Prints into title and information
	 */
	public static void title() {
		System.out.println("");

		System.out.println(" /$$$$$$$  /$$   /$$ /$$$$$$$        /$$$$$$$   /$$$$$$  /$$   /$$ /$$   /$$");
		System.out.println("| $$__  $$| $$  | $$| $$__  $$      | $$__  $$ /$$__  $$| $$$ | $$| $$  /$$/");
		System.out.println("| $$  \\ $$| $$  | $$| $$  \\ $$      | $$  \\ $$| $$  \\ $$| $$$$| $$| $$ /$$/ ");
		System.out.println("| $$  | $$| $$$$$$$$| $$$$$$$/      | $$$$$$$ | $$$$$$$$| $$ $$ $$| $$$$$/  ");
		System.out.println("| $$  | $$| $$__  $$| $$____/       | $$__  $$| $$__  $$| $$  $$$$| $$  $$  ");
		System.out.println("| $$  | $$| $$  | $$| $$            | $$  \\ $$| $$  | $$| $$\\  $$$| $$\\  $$ ");
		System.out.println("| $$$$$$$/| $$  | $$| $$            | $$$$$$$/| $$  | $$| $$ \\  $$| $$ \\  $$");
		System.out.println("|_______/ |__/  |__/|__/            |_______/ |__/  |__/|__/  \\__/|__/  \\__/");
		System.out.println("                       ");
		System.out.println(" _____    _____           _         _      _____     _ ");
		System.out.println("|  _  |  |  _  |___ ___  |_|___ ___| |_   | __  |_ _|_|");
		System.out.println("|     |  |   __|  _| . | | | -_|  _|  _|  | __ -| | |_ ");
		System.out.println("|__|__|  |__|  |_| |___|_| |___|___|_|    |_____|_  |_|");
		System.out.println("                       |___|                    |___|  ");
		System.out.println(" ____          _     _    _____    _____             _                _____              _    _____         _ _      _____ ");
		System.out.println("|    \\ ___ ___|_|___| |  |     |  |  |  |___ ___ ___|_|___ ___ ___   |  |  |   ___ ___ _| |  |  _  |_ _ ___|_| |_   |_   _|");
		System.out.println("|  |  | .'|   | | -_| |  | | | |  |     | .'|  _|  _| |_ -| . |   |  |     |  | .'|   | . |  |   __| | |   | |  _|    | |  ");
		System.out.println("|____/|__,|_|_|_|___|_|  |_|_|_|  |__|__|__,|_| |_| |_|___|___|_|_|  |__|__|  |__,|_|_|___|  |__|  |___|_|_|_|_|      |_|   ");
	}
	
	/**
	 * Nicely prints an account into console
	 * @param a - Account
	 */
	public static void printAccount(Account a){
		String[] stats = {"Name: "+a.id,"Balance: "+a.balance};
		border(stats);
	}
	
	/**
	 * Nicely prints multiple accounts into console, uses 2 decimal format
	 * @param a - ArrayList of accounts
	 */
	public static void printAccounts(ArrayList<Account> a){
		DecimalFormat df = new DecimalFormat("#.00");
		String[] stats = new String[a.size()*3-1];
		for(int i=0;i<a.size();i++){
			stats[i*3] = "Name: "+a.get(i).id;
			stats[i*3+1] = "Balance: "+df.format(a.get(i).balance);
			if(i!=a.size()-1){
				stats[i*3+2] = "";
			}
		}
		border(stats);
	}
	
	/**
	 * Nicely prints all strings in a string array in a unicode character box.
	 * @param data
	 */
	public static void border(String[] data){
		int max = 0;
		for(String s : data){
			if(s.length() > max){
				max = s.length();
			}
		}
		
		System.out.print("┏");
		for(int i=0;i<max;i++){
			System.out.print("━");
		}
		System.out.println("┓");

		for(String s : data){
			System.out.print("┃"+s);
			for(int i=0;i<max-s.length();i++){
				System.out.print(" ");
			}
			System.out.println("┃");
		}
		
		System.out.print("┗");
		for(int i=0;i<max;i++){
			System.out.print("━");
		}
		System.out.println("┛");
	}

}