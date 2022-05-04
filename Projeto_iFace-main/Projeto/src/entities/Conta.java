package entities;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	
	private String login;
	private String senha;
	private String nome;
	
	private List<String> solAmi = new ArrayList<>();
	private List<String> amigos = new ArrayList<>();
	private List<String> mensagens = new ArrayList<>();
	private List<String> comunidades = new ArrayList<>();
	private List<String> feed = new ArrayList<>();
	
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
	
	public List<String> getAmigos() {
		return amigos;
	}
	
	public List<String> getMensagens() {
		return mensagens;
	}

	public List<String> getComunidades() {
		return comunidades;
	}

	public List<String> getFeed() {
		return feed;
	}
	
	public List<String> getSolAmi() {
		return solAmi;
	}

	public void addSolAmi(String usuario) {
		solAmi.add(usuario);
	}
	
	public void removeSolAmi(String usuario) {
		solAmi.remove(usuario);
	}
	
	public void addAmigos(String amigo) {
		amigos.add(amigo);
	}
	
	public void removeAmigos(String amigo) {
		amigos.remove(amigo);
	}
	
	public int buscarAmigos(String loginDesejado) {
		for(String val : amigos) {
			if(loginDesejado.contentEquals(val) == true) {
				return 1;
			}
		}
		return 0;
	}
	
	public void addMensagens(String mensagem) {
		mensagens.add(mensagem);
	}
	
	public void removeMensagens(String mensagem) {
		mensagens.remove(mensagem);
	}
	
	public void addComunidades(String usuario) {
		comunidades.add(usuario);
	}
	
	public void removeComunidades(String usuario) {
		comunidades.remove(usuario);
	}
	
	public void addFeed(String mensagem) {
		feed.add(mensagem);
	}
	
	public void removeFeed(String mensagem) {
		feed.remove(mensagem);
	}

	public String toString() {
		return "Login:" + login + "\nSenha:" + senha + "\nNome:" + nome;
	}

}
