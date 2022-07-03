package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class EnviarMensagemUsuario implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		System.out.println("Informe o login do destinatario:");
		String loginDestinatario = sc.nextLine();
		if(dados.buscaList(loginDestinatario) == null) {
			System.out.println("Login destinatario nao cadastrado");
		} else {
			System.out.println("Informe a mensagem:");
			String mensagem = sc.nextLine();
			dados.enviarMenUsuario(loginConta, mensagem, loginDestinatario);
			System.out.println("Mensagem enviada com sucesso!");
		}
		return loginConta;
	}
}
