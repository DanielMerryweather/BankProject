import java.util.ArrayList;

public class FileParser {
	
	/**
	 * Returns the conversion of an account into string data format
	 * @param a - Account
	 * @return
	 */
	public static String accountToData(Account a){
		String fin = "[";
		fin += "name:"+a.id+",";
		fin += "balance:"+a.balance+"]";
		return fin;
	}
	/**
	 * Returns the conversion of a account string into a usable account object.
	 * @param data - String
	 * @return
	 */
	public static Account dataToAccount(String data){
		String name = getStringData(data, "name:",",");
		double balance = getIntegerData(data, "balance:","]");
		return new Account(balance,name);
	}
	/**
	 * Returns the conversion of a master account into string data format
	 * @param ms - MasterAccount
	 * @return
	 */
	public static String masterAccountToData(MasterAccount ms){
		String fin = "[";
		fin += "id:"+ms.id+",";
		fin += "name:"+ms.name+",";
		fin += "pass:"+ms.pass+",";
		fin += "accounts:{";
		for(int i=0;i<ms.accounts.size();i++){
			fin += ms.accounts.get(i) + (i==ms.accounts.size()-1?"":",");
		}
		fin += "}]";
		return fin;
	}
	
	/**
	 * Returns the conversion of a master account string into a usable master account object.
	 * @param data
	 * @return
	 */
	public static MasterAccount dataToMasterAccount(String data){
		int id = getIntegerData(data, "id:",",");
		String name = getStringData(data, "name:",",");
		String pass = getStringData(data, "pass:",",");
		int accIndex = data.indexOf("[",1);
		ArrayList<Account> accs = new ArrayList<Account>();
		while(accIndex != -1){
			String currAccData = data.substring(accIndex, data.indexOf("]",accIndex)+1);
			accs.add(dataToAccount(currAccData));
			accIndex = data.indexOf("[",accIndex+1);
		}
		return new MasterAccount(id, name, pass, accs);
	}
	/**
	 * Retrieves integer data from a string given a prefix and suffix
	 * @param all - Entire string
	 * @param startPat - Prefix
	 * @param endPat - Suffix
	 * @return
	 */
	public static int getIntegerData(String all, String startPat, String endPat){
		try{
			String intString = cropUpTo(getStringData(all, startPat, endPat),".");
			return Integer.parseInt(intString);
		}catch(Exception e){
			return 0;
		}
	}
	/**
	 * Retrieves double data from a string given a prefix and suffix
	 * @param all - Entire string
	 * @param startPat - Prefix
	 * @param endPat - Suffix
	 * @return
	 */
	public static double getDoubleData(String all, String startPat, String endPat){
		try{
			return Double.parseDouble(getStringData(all, startPat, endPat));
		}catch(Exception e){
			return 0;
		}
	}
	/**
	 * Retrieves a string from another string given a prefix and suffix
	 * @param all - Entire string
	 * @param startPat - Prefix
	 * @param endPat - Suffix
	 * @return
	 */
	public static String getStringData(String all, String startPat, String endPat){
		int pos = all.indexOf(startPat);
		return all.substring(pos+startPat.length(), all.indexOf(endPat, pos+startPat.length()));
	}
	/**
	 * Crops a string from the beginning to a desired suffix
	 * @param all - String
	 * @param endPat - Suffix
	 * @return
	 */
	public static String cropUpTo(String all, String endPat){
		int pos = all.indexOf(endPat);
		if(pos == -1)
			return all;
		return all.substring(0,pos);
	}
	
}
