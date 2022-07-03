package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;
import entities.enums.PermissaoFeed;

public class ConfigurarFeed implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		verificacao = false;
		while(verificacao == false){
	    	try {
	    		System.out.println("Escolha a configuracao do seu feed:");
		    	System.out.println("Publico -> (todos podem visualizar)");
		        System.out.println("Privado -> (apenas amigos conseguem visualizar)");
		    	System.out.print("Escreva exatamente como encima: ");
			    String permissaoFeed = sc.nextLine();
			    PermissaoFeed permissaoFeedEnum = PermissaoFeed.valueOf(permissaoFeed);
			    dados.configurarFeed(loginConta, permissaoFeedEnum);
				System.out.println("Feed configurado.");
				verificacao = true;
	    	}
	    	catch (IllegalArgumentException e) {
				System.out.println("\n" + "Erro na entrada: " + e + "\n");
			} 
	    }
		return loginConta;
	}
}
