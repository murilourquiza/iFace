package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class VerAmigos implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		auxiliar = dados.visualizarAmigos(loginConta);
    	if(auxiliar == null) {
    		System.out.println("Sem amigos.");
    	} else {
    		System.out.println(auxiliar);
    	}
    	return loginConta;
	}
}
