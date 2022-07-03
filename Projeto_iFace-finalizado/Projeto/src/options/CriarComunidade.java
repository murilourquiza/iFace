package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class CriarComunidade implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		System.out.println("Informe o nome da comunidade:");
		String nomCom = sc.nextLine();
		System.out.println("Informe a descricao da comunidade:");
	    String descCom = sc.nextLine();
		if(dados.criarComunidade(loginConta, nomCom, descCom) == 0) {
			System.out.println("Uma comunidade ja existe com esse nome.");
		} else {
			System.out.println("Comunidade criada com sucesso!");
		}
		return loginConta;
	}
}
