package bean;

public class Account {
	String username;
	String password;

	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Account() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
