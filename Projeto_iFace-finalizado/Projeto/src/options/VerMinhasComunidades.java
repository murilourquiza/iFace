package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class VerMinhasComunidades implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		auxiliar = dados.visualizarComunidades(loginConta);
    	if(auxiliar == null) {
    		System.out.println("Nenhuma comunidade encontrada.");
    	} else {
    		System.out.println("Comunidades que voce faz parte:");
    		System.out.println(auxiliar);
    	}
    	return loginConta;
	}
}
