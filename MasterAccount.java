import java.util.ArrayList;

public class MasterAccount {

	int id = 0;
	String name = "";
	String pass = "";
	
	ArrayList<Account> accounts = new ArrayList<Account>();
	
	public MasterAccount(int id, String name, String pass, ArrayList<Account> accounts) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.accounts = accounts;
	}
	
	public Account loadAccount(String id){
		for(Account a : accounts){
			if(a.id == id){
				return a;
			}
		}
		return null;
	}
	
	public void saveAccount(Account acc){
		for(Account a : accounts){
			if(a.id == acc.id){
				a.balance = acc.balance;
			}
		}
	}
	
	public void createAccount(Account a){
		accounts.add(a);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

}
