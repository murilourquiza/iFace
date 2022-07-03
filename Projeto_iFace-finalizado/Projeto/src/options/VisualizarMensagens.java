package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class VisualizarMensagens implements Options {
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		auxiliar = dados.visualizarMensagens(loginConta);
    	if(auxiliar == null) {
    		System.out.println("Nenhuma mensagem encontrada.");
    	} else {
    		System.out.println(auxiliar);
    	}
    	return loginConta;
	}
}
