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
	
	public FileLoader(){
		accountArray = fileReader();
	}
	
	public void getMasterAccount(int id){
		for(String s : accountArray){
			int cid = FileParser.dataToMasterAccount(s);
			if(id == cid)
				System.out.println("Correct Account is " + s);
		}
	}
	
	void addToArray(int id, String name, String pass, String[] accs){
		accountArray.add(FileParser.masterAccountToData(id, name, pass, accs));
	}
	
	ArrayList<String> fileReader(){
		ArrayList<String> accountArr = null;
		try{
			FileInputStream fstream = new FileInputStream(
					"H://Desktop//Eclipse Work//GroupBankProject//src//bankData.txt");
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
	
	void fileWriter(ArrayList<String> accountArr){
		BufferedWriter bw = null;
		try{
			File file = new File("H://Desktop//Eclipse Work//GroupBankProject//src//bankData.txt");
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			for (int i = 0; i < accountArr.size(); i++){
				bw.write(accountArr.get(i));
				bw.newLine();
			}
		}
		catch (IOException e){
			System.out.println("Error Ocurred");
		}
	}
}