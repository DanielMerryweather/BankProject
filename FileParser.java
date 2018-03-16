
public class FileParser {

	public static void main(String[] args){
		String acc1 = accountToData("Savings",10000);
		String acc2 = accountToData("Chequing",1000);
		String mstacc = masterAccountToData(1,"Daniel","testpass",new String[]{acc1,acc2});
		System.out.println(mstacc);
		dataToMasterAccount(mstacc);
	}
	
	public static String accountToData(String name, double balance){
		String fin = "[";
		fin += "name:"+name+",";
		fin += "balance:"+balance+"]";
		return fin;
	}
	
	public static void dataToAccount(String data){
		String name = getStringData(data, "name:",",");
		System.out.println(name);
		double balance = getIntegerData(data, "balance:","]");
		System.out.println(balance);
	}
	
	public static String masterAccountToData(int id, String name, String pass, String[] accs){
		String fin = "[";
		fin += "id:"+id+",";
		fin += "name:"+name+",";
		fin += "pass:"+pass+",";
		fin += "accounts:{";
		for(int i=0;i<accs.length;i++){
			fin += accs[i] + (i==accs.length-1?"":",");
		}
		fin += "}]";
		return fin;
	}
	
	public static int dataToMasterAccount(String data){
		int id = getIntegerData(data, "id:",",");
		System.out.println(id);
		String name = getStringData(data, "name:",",");
		System.out.println(name);
		String pass = getStringData(data, "pass:",",");
		System.out.println(pass);
		int accIndex = data.indexOf("[",1);
		while(accIndex != -1){
			String currAccData = data.substring(accIndex, data.indexOf("]",accIndex)+1);
			dataToAccount(currAccData);
			accIndex = data.indexOf("[",accIndex+1);
		}
		return id;
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
