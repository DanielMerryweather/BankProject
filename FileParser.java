import java.util.ArrayList;

public class FileParser {
	
	public static String accountToData(Account a){
		String fin = "[";
		fin += "name:"+a.id+",";
		fin += "balance:"+a.balance+"]";
		return fin;
	}
	
	public static Account dataToAccount(String data){
		String name = getStringData(data, "name:",",");
		double balance = getIntegerData(data, "balance:","]");
		return new Account(balance,name);
	}
	
	public static String masterAccountToData(int id, String name, String pass, ArrayList<Account> accs){
		String fin = "[";
		fin += "id:"+id+",";
		fin += "name:"+name+",";
		fin += "pass:"+pass+",";
		fin += "accounts:{";
		for(int i=0;i<accs.size();i++){
			fin += accs.get(i) + (i==accs.size()-1?"":",");
		}
		fin += "}]";
		return fin;
	}
	
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
	
	public static int getIntegerData(String all, String startPat, String endPat){
		try{
			String intString = cropUpTo(getStringData(all, startPat, endPat),".");
			return Integer.parseInt(intString);
		}catch(Exception e){
			return 0;
		}
	}
	
	public static double getDoubleData(String all, String startPat, String endPat){
		try{
			return Double.parseDouble(getStringData(all, startPat, endPat));
		}catch(Exception e){
			return 0;
		}
	}
	
	public static String getStringData(String all, String startPat, String endPat){
		int pos = all.indexOf(startPat);
		return all.substring(pos+startPat.length(), all.indexOf(endPat, pos+startPat.length()));
	}
	
	public static String cropUpTo(String all, String endPat){
		int pos = all.indexOf(endPat);
		if(pos == -1)
			return all;
		return all.substring(0,pos);
	}
	
}
