package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class ConfigurarPerfil implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		verificacao = false;
		while(verificacao == false){
		    try {
		    	System.out.println("1-> Alterar login");
			    System.out.println("2-> Alterar senha");
			    System.out.println("3-> Alterar nome");
			    System.out.print("Digite sua opcao: ");
		    	entradaConfigurarPerfil = Integer.parseInt(sc.nextLine());
				verificacao = true;
				System.out.println("");
			} 
			catch (NumberFormatException e) {
				System.out.println("\n" + "Erro na entrada: " + e + "\n");
			}
		}
	    
	    switch (entradaConfigurarPerfil) {
	    case 1:
	    	System.out.println("Novo login:");
	    	String loginNovo = sc.nextLine();
	    	if(dados.buscaList(loginNovo) != null) {
			    System.out.println("ERRO! Ja existente um usuario com este login.");
			} else {
				dados.mudarLoginList(loginConta, loginNovo);
				System.out.println("Login alterado de " + loginConta + " para " + loginNovo + ".");
				loginConta = loginNovo;
			}
		 break;
	    case 2:
			System.out.println("Nova senha:");
			String senhaNova = sc.nextLine();
			System.out.println("Senha alterada de " + dados.buscaSenhaList(loginConta) + " para " + senhaNova + ".");
			dados.mudarSenhaList(loginConta, senhaNova);
	     break;
	    case 3:
			System.out.println("Novo nome:");
			String nomeNovo = sc.nextLine();
			System.out.println("Nome alterado de " + dados.buscaList(loginConta) + " para " + nomeNovo + ".");
			dados.mudarNomeList(loginConta, nomeNovo);
	     break;
	    default:
	    	System.out.println("Opcao Invalida");
	    }
	    
	    return loginConta;
	}
}
