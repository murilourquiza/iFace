package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class EntrarComunidade implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		if(dados.getTamanhoListaCom() == 0) {
    		System.out.println("Nao existe comunidade no momento");
    	} else {
    		System.out.println("Comunidades Existentes:");
    		System.out.println(dados.getListCom());
    		System.out.println("\nInforme a comunidade de interesse:");
    		String nomeComunidade = sc.nextLine();
    		int respostaComunidade = dados.entrarComunidade(loginConta, nomeComunidade);
    		if(respostaComunidade == 0) {
    			System.out.println("Comunidade nao encontrada");
    		} else if(respostaComunidade == 1) {
    			System.out.println("Voce ja e o dono dessa comunidade.");
    		} else if(respostaComunidade == 2) {
    			System.out.println("Voce ja faz parte dessa comunidade.");
    		} else if(respostaComunidade == 3) {
    			System.out.println("Parabens! Agora voce faz parte dessa comunidade.");
    		}
    	}
		return loginConta;
	}
}
