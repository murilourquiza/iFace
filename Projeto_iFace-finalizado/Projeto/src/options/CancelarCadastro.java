package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class CancelarCadastro implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		dados.cancelarConta(loginConta);
    	System.out.println("Cadastro cancelado com sucesso.");
    	return loginConta;
	}
}
