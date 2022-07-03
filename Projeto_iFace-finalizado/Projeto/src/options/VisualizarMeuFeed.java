package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class VisualizarMeuFeed implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		if(dados.visualizarFeed(loginConta) == null) {
    		System.out.println("Nenhuma atividade encontrada no Feed.");
    	}else {
    		System.out.println(dados.visualizarFeed(loginConta));
    	}
		return loginConta;
	}
}
