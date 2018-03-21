/**
 * @author 10239001
 * @version 1.4
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileLoader {
	
	ArrayList<String> accountArray;
	
	/**
	 * Constructor for creating new FileLoader's
	 */
	public FileLoader(){
		accountArray = fileReader();
	}
	
	/**
	 * Finds the master account with the id input and returns it
	 * 
	 * @param id ID input by user
	 * @return Returns either null if id does not account and the account if it does
	 */
	public MasterAccount getMasterAccount(int id){
		MasterAccount acc;
		for(String s : accountArray){
			acc = FileParser.dataToMasterAccount(s);
			if(acc.getId() == id)
				return acc;
		}
		return null;
	}
	
	/**
	 * Adds the master account to the arraylist in specific format
	 * 
	 * @param ms Master account currently used
	 */
	void addToArray(MasterAccount ms){
		accountArray.add(FileParser.masterAccountToData(ms.id, ms.name, ms.pass, ms.accounts));
	}
	
	/**
	 * Reads the text file and inputs all lines into the arraylist
	 * 
	 * @return Returns the arraylist
	 */
	ArrayList<String> fileReader(){
		ArrayList<String> accountArr = null;
		try{
			FileInputStream fstream = new FileInputStream(
					"bankData.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			accountArr = new ArrayList<String>();
			String hasNextLine = br.readLine();
			while (hasNextLine != null) {
				accountArr.add(hasNextLine);
				hasNextLine = br.readLine();
			}
			br.close();	
		}
		catch(IOException e){
			System.out.println("Error Ocurred");
		}
		return accountArr;
	}
	/**
	 * Writes the arraylist line by line into the text file
	 * 
	 * @param accountArr Arraylist written into file
	 */
	void fileWriter(ArrayList<String> accountArr){
		BufferedWriter bw = null;
		try{
			File file = new File("bankData.txt");
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write("");
			for (int i = 0; i < accountArr.size(); i++){
				bw.write(accountArr.get(i));
				bw.newLine();
			}
			bw.close();
		}
		catch (IOException e){
			System.out.println("Error Ocurred");
		}
		
	}
}