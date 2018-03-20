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
	
	/**
	 * Saves account in this master account
	 * @param acc - specified account
	 */
	public void saveAccount(Account acc){
		for(Account a : accounts){
			if(a.id.equals(acc.id)){
				a.balance = acc.balance;
			}
		}
	}
	
	/**
	 * Adds an account to this master account
	 * @param a - Account
	 */
	public void addAccount(Account a){
		accounts.add(a);
	}
	
	/**
	 * Deletes an account from this master account
	 * @param a - Account
	 */
	public void deleteAccount(Account a){
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).id == a.id){
				accounts.remove(i);
			}
		}
	}

	/**
	 * Gets the id of this master account
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of this master account
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name of this master account
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of this master account
	 * @param id
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the password of this master account
	 * @return
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * Sets the password of this master account
	 * @param id
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * Gets the accounts of this master account
	 * @return
	 */
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	/**
	 * Sets the accounts of this master account
	 * @param id
	 */
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

}
