package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class SairComunidade implements Options {
    public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
    	auxiliar = dados.visualizarComunidades(loginConta);
    	if(auxiliar == null) {
    		System.out.println("Voce nao faz parte de nenhuma comunidade.");
    	} else {
    		System.out.println("Comunidades que voce faz parte:");
    		System.out.println(auxiliar);
    		System.out.println("Digite o nome da comunidade que deseja sair:");
    		String nomeComunidadeSair = sc.nextLine();
    		int respostaComunidade = dados.sairComunidade(loginConta, nomeComunidadeSair);
    		if(respostaComunidade == 0) {
    			System.out.println("Comunidade nao encontrada.");
    		} else if(respostaComunidade == 1) {
    			System.out.println("Voce e o(a) dono(a) dessa comunidade e nao pode sair.");
    		} else if(respostaComunidade == 2) {
    			System.out.println("Saida efetivada com sucesso!");
    		} else if(respostaComunidade == 3) {
    			System.out.println("Voce nao faz parte dessa comunidade.");
    		}
    	}
    	return loginConta;
	}
}
