package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class PedidosAmizade implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
    	int escolhaSolAmi = 1;
    	auxiliar = dados.listaSolAmi(loginConta);
    	if(auxiliar == null) {
    		System.out.println("Sem solicitacoes no momento.");
    	} else {
			System.out.println(auxiliar);
			verificacao = false;
            while(verificacao == false){
	    		try {
					System.out.println("1-> Aceitar uma solicitacao:");
					System.out.println("2-> Recusar uma solicitacao:");
					System.out.println("3-> Voltar.");
					System.out.print("Digite sua opcao: ");
					escolhaSolAmi = Integer.parseInt(sc.nextLine());
					verificacao = true;
					System.out.println("");
				} 
				catch (NumberFormatException e) {
					System.out.println("\n" + "Erro na entrada: " + e + "\n");
				} 
			}
	    	while (escolhaSolAmi != 3) {
	    		String loginAmigo;
	    		System.out.println("Digite o login de quem fez a solicitacao:");
				loginAmigo = sc.nextLine();
				if(dados.buscaList(loginAmigo) == null) {
					System.out.println("Login nao cadastrado.");
				} else if(dados.verificacaoSolAmi(loginConta, loginAmigo) == 0) {
					System.out.println("Login invalido.");
				} else {
					switch (escolhaSolAmi) {
		    			case 1:
		    				dados.addListAmi(loginConta, loginAmigo);
		    				dados.removeListSolAmi(loginConta, loginAmigo);
		    				System.out.println("Solicitacao Aceita");
		    		    break;
		    			case 2:
		    				dados.removeListSolAmi(loginConta, loginAmigo);
		    				System.out.println("Solicitacao Recusada");
		    			break;
		    			default:
		    				System.out.println("Opcao Invalida");
		    	    }
				}
				verificacao = false;
                while(verificacao == false){
		    		try {
						System.out.println("1-> Aceitar uma solicitacao:");
						System.out.println("2-> Recusar uma solicitacao:");
						System.out.println("3-> Voltar.");
						System.out.print("Digite sua opcao: ");
						escolhaSolAmi = Integer.parseInt(sc.nextLine());
						verificacao = true;
						System.out.println("");
					} 
					catch (NumberFormatException e) {
						System.out.println("\n" + "Erro na entrada: " + e + "\n");
					}
				}
	    	}
    	}
    	return loginConta;
	}
}
