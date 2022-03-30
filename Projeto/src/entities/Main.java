package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Conta;
import entities.Comunidade;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bem-vindo ao iFace!");
		System.out.println("");
		System.out.println("Ate agora so foram implementadas: criacao de conta, criacao/edicao de perfil, criacao de comunidades e adicao de membros");
		System.out.println("");
		
		List <Conta> list = new ArrayList<>();
		
		List <Comunidade> listCom = new ArrayList<>();
		
		System.out.println("O que deseja realizar:");
		System.out.println("1 - Criar conta");
		System.out.println("2 - Alterar login");
		System.out.println("3 - Alterar senha");
		System.out.println("4 - Alterar nome");
		System.out.println("5 - Criar comunidade");
		System.out.println("6 - Entrar em uma comunidade");
		System.out.println("10 - Sair");
		System.out.print("Digite ");
		
		int x = sc.nextInt();
		sc.nextLine();
		
		while(x != 10) {
	      if(x == 1) {
	    	System.out.println("Informe seu login:");
	    	String login = sc.nextLine();
	    	System.out.println("Informe sua senha:");
	    	String senha = sc.nextLine();
	    	System.out.println("Informe seu nome:");
	    	String nome = sc.nextLine();
	    	list.add(new Conta(login, senha, nome));
	      } else if(x == 2) {
	    	if(list.size() == 0) {
		    	System.out.println("Nenhum usuario cadastrado");
		    } else {
		    	System.out.println("Informe seu login:");
		    	String loginAuxiliar = sc.nextLine();
		    	System.out.println("Novo login:");
		    	String login1 = sc.nextLine();
		    	int tamanhoLista = list.size();
		    	for(Conta val : list) {
		    		int aux = tamanhoLista;
		    		if(loginAuxiliar.contentEquals(val.getLogin()) == true) {
		    			val.setLogin(login1);
		    		} else {
		    			aux--;
		    			if(aux == 0) {
		    				System.out.println("Login nao cadastrado");
		    			}
		    		}
		    	}
	      }
	    } else if(x == 3) {
	    	if(list.size() == 0) {
			    System.out.println("Nenhum usuario cadastrado");
			} else {
				System.out.println("Informe seu login:");
				String loginAuxiliar = sc.nextLine();
				System.out.println("Nova senha:");
				String senha1 = sc.nextLine();
				int tamanhoLista = list.size();
				for(Conta val : list) {
					int aux = tamanhoLista;
					if(loginAuxiliar.contentEquals(val.getLogin()) == true) {
						val.setSenha(senha1);
					} else {
						aux--;
						if(aux == 0) {
							System.out.println("Login nao cadastrado");
						}
					}
				}
			}
	    } else if(x == 4) {
	    	if(list.size() == 0) {
			    System.out.println("Nenhum usuario cadastrado");
			} else {
				System.out.println("Informe seu login:");
				String loginAuxiliar = sc.nextLine();
				System.out.println("Novo nome:");
				String nome1 = sc.nextLine();
				int tamanhoLista = list.size();
				for(Conta val : list) {
					int aux = tamanhoLista;
					if(loginAuxiliar.contentEquals(val.getLogin()) == true) {
						val.setNome(nome1);
					} else {
						aux--;
						if(aux == 0) {
							System.out.println("Login nao cadastrado");
						}
					}
				}
			}
	    } else if(x == 5) {
	    	if(list.size() == 0) {
			    System.out.println("Nenhum usuario cadastrado");
			} else {
				System.out.println("Informe seu login:");
				String loginAuxiliar = sc.nextLine();
				int tamanhoLista = list.size();
				for(Conta val : list) {
					int aux = tamanhoLista;
					if(loginAuxiliar.contentEquals(val.getLogin()) == true) {
						System.out.println("Informe o nome da comunidade:");
						String nomCom = sc.nextLine();
						System.out.println("Informe a descricao da comunidade:");
						String descCom = sc.nextLine();
						listCom.add(new Comunidade(nomCom, descCom, loginAuxiliar));
					} else {
						aux--;
						if(aux == 0) {
							System.out.println("Sem permissao.");
						}
					}
				
				} 
	      }
	    } else{
	    	if(listCom.size() == 0) {
	    		System.out.println("Nao existe comunidade no momento");
	    	} else {
	    		System.out.println("Informe seu login:");
	    		String loginAuxiliar = sc.nextLine();
	    		int tamanhoLista = list.size();
	    		for(Conta val : list) {
	    			int aux = tamanhoLista;
	    			if(loginAuxiliar.contentEquals(val.getLogin()) == true) {
	    				System.out.println("Informe a comunidade de interesse:");
	    				String nomeComunidade = sc.nextLine();
	    				int tamanhoListaCom = listCom.size();
	    				for(Comunidade val2 : listCom) {
	    					int aux2 = tamanhoListaCom;
	    					if(nomeComunidade.contentEquals(val2.getNome()) == true) {
	    						val2.addMembro(loginAuxiliar);
	    					} else {
	    						aux2--;
	    						if(aux2 == 0) {
	    							System.out.println("Comunidade nao encontrada");
	    						}
	    					}
	    				}
	    			} else {
	    				aux--;
	    				if(aux == 0) {
	    					System.out.println("Login nao cadastrado");
	    				}
	    			}
	    		}
	    	}
	    }
	      System.out.println("");
	      System.out.println("O que deseja realizar:");
		  System.out.println("1 - Criar conta");
		  System.out.println("2 - Alterar login");
		  System.out.println("3 - Alterar senha");
		  System.out.println("4 - Alterar nome");
		  System.out.println("5 - Criar comunidade");
		  System.out.println("6 - Entrar em uma comunidade");
		  System.out.println("10 - Sair");
		  System.out.print("Digite ");
	      x = sc.nextInt();
	      sc.nextLine();
	      
		}
		
		System.out.println("Obrigado por confiar no iFace.");

	    sc.close();

	}
}
