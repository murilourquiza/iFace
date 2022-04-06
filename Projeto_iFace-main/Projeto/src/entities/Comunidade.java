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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLoginDono() {
		return loginDono;
	}

	public void setLoginDono(String loginDono) {
		this.loginDono = loginDono;
	}

	public void addMembro(String login) {
		membros.add(login);
	}
	
	public void removeMembro(String login) {
		membros.remove(login);
	}
	
	public int buscarMembro(String loginDesejado) {
		for(String val : membros) {
			if(loginDesejado.contentEquals(val) == true) {
				return 1;
			}
		}
		return 0;
	}
	
	public String toString() {
		return "Comunidade: " + nome + " .Descricao: " + descricao + " .Login do Dono: " + loginDono + " .Membros: " + membros;
	}
	
}
