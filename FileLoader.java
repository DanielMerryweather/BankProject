/**
 * @author 10239001
 * @version 1.4
 * StartDate: 14/3/2018
 * FinishDate: 21/3/2018
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
		accountArray.add(FileParser.masterAccountToData(ms));
	}
	
	/**
	 * Saves a master account and writes it to the file
	 * 
	 * @param ms
	 */
	void saveMasterAccount(MasterAccount ms){
		for(int i=0;i<accountArray.size();i++){
			if(ms.id == FileParser.dataToMasterAccount(accountArray.get(i)).id){
				accountArray.set(i, FileParser.masterAccountToData(ms));
			}
		}
		fileWriter(this.accountArray);
	}
	
	/**
	 * Removes the master account specified from the account array
	 * 
	 * @param a Master account entered
	 */
	public void deleteMasterAccount(MasterAccount a){
		for(int i=0;i<this.accountArray.size();i++){
			if(FileParser.dataToMasterAccount(this.accountArray.get(i)).id == a.id){
				this.accountArray.remove(i);
			}
		}
		fileWriter(this.accountArray);
	}
	
	/**
	 * Adds a new master account with an unused id to the account array
	 * 
	 * @param ms Master account entered
	 * @return Returns the id
	 */
	public int addMasterAccount(MasterAccount ms){
		int nextId = 0;
		boolean found = false;
		while(!found){
			nextId++;
			found = true;
			for(String s : this.accountArray){
				if(FileParser.dataToMasterAccount(s).id == nextId){
					found = false;
				}
			}
		}
		ms.setId(nextId);
		this.accountArray.add(FileParser.masterAccountToData(ms));
		fileWriter(this.accountArray);
		return nextId;
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
