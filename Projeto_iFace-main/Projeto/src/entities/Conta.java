package entities;

public class Conta {
	
	private String login;
	private String senha;
	private String nome;
	
	public Conta() {
	}

	public Conta(String login, String senha, String nome) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return "Login:" + login + "\nSenha:" + senha + "\nNome:" + nome;
	}

}
