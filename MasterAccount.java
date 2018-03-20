import java.util.ArrayList;

public class MasterAccount {

	int id = 0;
	String name = "";
	String pass = "";
	
	ArrayList<Account> accounts = new ArrayList<Account>();
	
	
	/**
	 * Master Account Constructor
	 * @param id - Unique account identifing number
	 * @param name - Name of account holder
	 * @param pass - Password to master account
	 * @param accounts - Accounts in the master account
	 */
	public MasterAccount(int id, String name, String pass, ArrayList<Account> accounts) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.accounts = accounts;
	}
	
	/**
	 * Returns account from this master account from a specific id
	 * @param id
	 * @return Account
	 */
	public Account loadAccount(String id){
		for(Account a : accounts){
			if(a.id.equals(id)){
				return a;
			}
		}
		return null;
	}
	
	public void saveAccount(Account acc){
		for(Account a : accounts){
			if(a.id.equals(acc.id)){
				a.balance = acc.balance;
			}
		}
	}
	
	public void addAccount(Account a){
		accounts.add(a);
	}
	
	public void deleteAccount(Account a){
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).id == a.id){
				accounts.remove(i);
			}
		}
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
