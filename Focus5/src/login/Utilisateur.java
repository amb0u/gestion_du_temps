package login;

public class Utilisateur {

	public Utilisateur(String logiN,int ident) {
		login=logiN;
		id=ident;
	}
	private String login;
	private int id;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
