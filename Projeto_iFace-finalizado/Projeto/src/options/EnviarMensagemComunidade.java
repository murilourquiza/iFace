package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class EnviarMensagemComunidade implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		if(dados.getTamanhoListaCom() == 0) {
    		System.out.println("Nao existe comunidade no momento");
    	} else {
			System.out.println("Informe o nome da comunidade:");
			String loginDestinatario2 = sc.nextLine();
			System.out.println("Informe a mensagem:");
			String mensagem2 = sc.nextLine();
			if(dados.enviarMenComunidade(loginConta, mensagem2, loginDestinatario2) == 0) {
				System.out.println("Comunidade nao cadastrada");
			} else {
				System.out.println("Mensagem enviada com sucesso!");
			}
		}
		return loginConta;
	}
}
