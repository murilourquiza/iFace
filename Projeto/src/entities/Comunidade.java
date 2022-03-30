package entities;

import java.util.ArrayList;
import java.util.List;

public class Comunidade {
	
	public String nome;
	public String descricao;
	public String loginDono;
	
	List<String> membros = new ArrayList<>();
	
	public Comunidade(String nome, String descricao, String loginDono) {
		this.nome = nome;
		this.descricao = descricao;
		this.loginDono = loginDono;
	}
	
	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public void addMembro(String login) {
		membros.add(login);
	}
	
	public String toString() {
		return "Comunidade: " + nome + "Descricao: " + descricao + "Login do Dono: " + loginDono;
	}
	
}
