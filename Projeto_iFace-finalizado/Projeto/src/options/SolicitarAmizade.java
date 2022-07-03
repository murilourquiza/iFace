package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class SolicitarAmizade implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		System.out.println("Informe o Login do amigo desejado: ");
    	String amigoDesejado = sc.nextLine();
    	if(loginConta.contentEquals(amigoDesejado) == true) {
    		System.out.println("Voce nao pode ser seu proprio amigo.");
    	} else {
			if(dados.buscaList(amigoDesejado) == null) {
				System.out.println("Login destinatario nao cadastrado");
			} else {
				int verificacaoSolAmi = dados.verificacaoSolAmi(loginConta, amigoDesejado);
				if(dados.verificacaoAmizade(loginConta, amigoDesejado) == 1) {
					System.out.println("Voce ja e amigo do usuario " + amigoDesejado + ".");
				} else if(verificacaoSolAmi == 1) {
					System.out.println("Verifique seus pedidos." + amigoDesejado + " ja lhe enviou um pedido de Amizade.");
				} else if(verificacaoSolAmi == 2) {
					System.out.println("Voce ja enviou anteriormente um pedido a esse usuario.");
				} else{
					dados.addListSolAmi(loginConta, amigoDesejado);
					System.out.println("Solicitacao enviada.");
				}
			}
    	}
    	return loginConta;
	}
}
