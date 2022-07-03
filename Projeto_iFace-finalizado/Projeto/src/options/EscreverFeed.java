package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class EscreverFeed implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		if(dados.buscarLoginNoFeed(loginConta) == 0) {
    		System.out.println("Seu feed precisa ser configurado primeiro");
    	} else {
    		System.out.println("Escreva a mensagem para o feed:");
	    	String feedTexto = sc.nextLine();
	    	dados.escreverFeed(loginConta, feedTexto);
	    	System.out.println("Feed atualizado.");
    	}
		return loginConta;
	}
}
