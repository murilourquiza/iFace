package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class VisualizarComunidadesExistentes implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		if(dados.getTamanhoListaCom() == 0) {
    		System.out.println("Nao existe comunidade no momento");
    	} else {
    		System.out.println("Comunidades Existentes:");
    		System.out.println(dados.getListCom());
    	}
		return loginConta;
	}
}
