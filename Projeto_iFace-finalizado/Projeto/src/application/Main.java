package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.BancoDados;
import options.CancelarCadastro;
import options.ChamaClasseOptions;
import options.ConfigurarFeed;
import options.ConfigurarPerfil;
import options.CriarComunidade;
import options.EntrarComunidade;
import options.EnviarMensagemComunidade;
import options.EnviarMensagemUsuario;
import options.EscreverFeed;
import options.Options;
import options.PedidosAmizade;
import options.SairComunidade;
import options.SolicitarAmizade;
import options.VerAmigos;
import options.VerMinhasComunidades;
import options.VisualizarComunidadesExistentes;
import options.VisualizarFeedGeral;
import options.VisualizarMensagens;
import options.VisualizarMeuFeed;
import options.VisualizarPerfil;

public class Main {
	
	public static void paginaInicial() {
		System.out.println("Bem-vindo ao iFace!");
		System.out.println("");
		System.out.println("1-> Cadastrar-se");
		System.out.println("2-> Fazer Login");
		System.out.println("3-> Sair do iFace");
	} 
	
	public static void cadastro(Scanner sc, BancoDados dados) {
		System.out.println("Informe seu login:");
		String login = sc.nextLine();
		if(dados.buscaList(login) != null) {
		    System.out.println("Login ja existente.");
		} else {
			System.out.println("Informe sua senha:");
			String senha = sc.nextLine();
			System.out.println("Informe seu nome:");
			String nome = sc.nextLine();
			dados.addList(login, senha, nome);
			System.out.println("Login criado com sucesso.");
		}
	}
	
	public static void paginaLogin(String loginConta, BancoDados dados) {
		System.out.println("\n---------------------------------------");
		System.out.println("L o g i n : " + loginConta);
		System.out.println("---------------------------------------");
	    System.out.println("Solicitacoes (" + dados.mostrarSolUsu(loginConta) +")");
		System.out.println("Amigos (" + dados.mostrarAmi(loginConta) +")");
		System.out.println("Mensagens (" + dados.mostrarMen(loginConta) +")");
		System.out.println("Comunidades (" + dados.mostrarCom(loginConta) +")");
		System.out.println("");
		System.out.println("PERFIL");
		System.out.println("  01-> Configurar Perfil");
		System.out.println("  02-> Visualizar Perfil");
		System.out.println("AMIGOS");
		System.out.println("  03-> Solicitar Nova Amizade");
		System.out.println("  04-> Verificar Pedidos de Amizade");
		System.out.println("  05-> Ver Amigos");
		System.out.println("MENSAGENS");
		System.out.println("  06-> Enviar Mensagem para um Usuario");
		System.out.println("  07-> Enviar Mensagem para uma Comunidade");
		System.out.println("  08-> Visualizar Todas as Mensagens");
		System.out.println("COMUNIDADES");
		System.out.println("  09-> Criar comunidade");
		System.out.println("  10-> Entrar em uma comunidade");
		System.out.println("  11-> Visualizar Comunidades Existentes");
		System.out.println("  12-> Ver Minhas Comunidades");
		System.out.println("  13-> Sair de uma Comunidade");
		System.out.println("FEED");
		System.out.println("  14-> Configurar seu Feed de Noticias");
		System.out.println("  15-> Escrever no Feed de Noticias");
		System.out.println("  16-> Visualizar Meu Feed");
		System.out.println("  17-> Visualizar Feed Geral");
		System.out.println("...");
		System.out.println("  19-> Cancelar Cadastro");
		System.out.println("  20-> Deslogar");
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<String> auxiliar = new ArrayList<>();
		
		int entrada1=0;
		int entradaLogin=0;
		int entradaConfigurarPerfil=0;
		
		BancoDados dados = new BancoDados();
		
		Options menu[] = new Options[20];
	    menu[1] = new ConfigurarPerfil();
	    menu[2] = new VisualizarPerfil();
	    menu[3] = new SolicitarAmizade();
	    menu[4] = new PedidosAmizade();
	    menu[5] = new VerAmigos();
	    menu[6] = new EnviarMensagemUsuario();
	    menu[7] = new EnviarMensagemComunidade();
	    menu[8] = new VisualizarMensagens();
	    menu[9] = new CriarComunidade();
	    menu[10] = new EntrarComunidade();
	    menu[11] = new VisualizarComunidadesExistentes();
	    menu[12] = new VerMinhasComunidades();
	    menu[13] = new SairComunidade();
	    menu[14] = new ConfigurarFeed();
	    menu[15] = new EscreverFeed();
	    menu[16] = new VisualizarMeuFeed();
	    menu[17] = new VisualizarFeedGeral();
	    menu[19] = new CancelarCadastro();
	    
		do {
			boolean verificacao = false;
			while(verificacao == false)	{		    
				try {
					paginaInicial();
					System.out.print("Digite sua opcao: ");
					entrada1 = Integer.parseInt(sc.nextLine());
					verificacao = true;
					System.out.println("");
				} 
				catch (NumberFormatException e) {
					System.out.println("\n" + "Erro na entrada: " + e + "\n");
				}
			}
			
			switch (entrada1) {
			case 1:
				cadastro(sc, dados);
		     break;
			case 2:
				if(dados.getTamanhoLista() == 0) {
			    	System.out.println("Sem usuarios cadastrados");
			    } else {
			    	System.out.println("Informe seu login:");
			    	String loginConta = sc.nextLine();
			    	String nome_LoginConta = dados.buscaList(loginConta);
			    	if(nome_LoginConta == null) {
			    		System.out.println("Login nao cadastrado");
			    	} else {
					    do {
					    	verificacao = false;
							while(verificacao == false){
								try {
						    		paginaLogin(loginConta, dados);
						    		System.out.print("Digite sua opcao: ");
									entradaLogin = Integer.parseInt(sc.nextLine());
									verificacao = true;
									System.out.println("");
								} 
								catch (NumberFormatException e) {
									System.out.println("\n" + "Erro na entrada: " + e + "\n");
								}
							}
							
							if(entradaLogin < 1 || entradaLogin > 20 || entradaLogin == 18) 
								System.out.println("Digite um numero correto");
							else if(entradaLogin != 20)
								loginConta = new ChamaClasseOptions().Write(menu[entradaLogin], verificacao, entradaConfigurarPerfil, loginConta, dados, sc, auxiliar);
							
						    
					    } while (entradaLogin != 20 && entradaLogin != 19);
			    	}
		        }
			 break;
			default:
				System.out.println("Digite um numero correto");
			}
		} while(entrada1 != 3);
		
		System.out.println("\nObrigado por confiar no iFace.");
	    sc.close();
	}
}