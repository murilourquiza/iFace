package entities;

import java.util.ArrayList;
import java.util.List;

public class Feed {
	
	private String login;
	private String permissao;
	
	List<String> mensagem = new ArrayList<>();
	
	public Feed() {
	}

	public Feed(String login, String permissao) {
		this.login = login;
		this.permissao = permissao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
	public void addMensagem(String login) {
		mensagem.add(login);
	}
	
	public String toString() {
		return "Feed " + permissao + ".\nO usuário " + login + " escreveu a(s) seguinte mensagem(ns): " + mensagem;
	}

}
