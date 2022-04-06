package entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List <Conta> list = new ArrayList<>();
		List <Comunidade> listCom = new ArrayList<>();
		List <Mensagem> listMen = new ArrayList<>();
		List <SolicitacaoAmizade> listSolAmi = new ArrayList<>();
		List <Amizades> listAmi = new ArrayList<>();
		List <Feed> listFeed = new ArrayList<>();
		int x=0;
		
		
		System.out.println("Bem-vindo ao iFace!");
		System.out.println("");
		System.out.println("1-> Cadastrar-se");
		System.out.println("2-> Fazer Login");
		System.out.println("3-> Sair do iFace");
		System.out.print("Digite sua opção: ");
		int aux=0;
		int tamanhoLista=0;
					    
		try {
			x = sc.nextInt();
			sc.nextLine();
			System.out.println("");
		} 
		catch (InputMismatchException e) {
			sc.close();
			System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
			return;
		}
		
		
		while(x != 3) {
			switch (x) {
			case 0:
				
			break;
			
			case 1:
				System.out.println("Informe seu login:");
		    	String login = sc.nextLine();
		    	if(list.size() == 0) {
		    		System.out.println("Informe sua senha:");
			    	String senha = sc.nextLine();
			    	System.out.println("Informe seu nome:");
			    	String nome = sc.nextLine();
			    	list.add(new Conta(login, senha, nome));
			    	System.out.println("Login criado com sucesso.");
			    } else {
			    	int tamanhoLista5 = list.size();
			    	int aux5=0;
			    	aux5 = tamanhoLista5;
			    	for(Conta val : list) {
			    		if(login.contentEquals(val.getLogin()) == true) {
			    		} else {
			    			aux5--;
			    		}
			    	}
			    	if(aux5 == 0) {
			    		System.out.println("Informe sua senha:");
				    	String senha = sc.nextLine();
				    	System.out.println("Informe seu nome:");
				    	String nome = sc.nextLine();
				    	list.add(new Conta(login, senha, nome));
				    	System.out.println("Login criado com sucesso.");
			    	} else {
			    		System.out.println("Login já existente.");
			    	}
			    }
		    break;
		    
			case 2:
				if(list.size() == 0) {
			    	System.out.println("Sem usuários cadastrados");
			    } else {
			    	System.out.println("Informe seu login:");
			    	String loginConta = sc.nextLine();
			    	tamanhoLista = list.size();
			    	aux=0;
			    	aux = tamanhoLista;
			    	for(Conta val : list) {
			    		if(loginConta.contentEquals(val.getLogin()) == true) {
			    			System.out.println("Olá, " + val.getNome());
			    		} else {
			    			aux--;
			    		}
			    	}
			    	if(aux == 0) {
			    		System.out.println("Login não cadastrado");
			    	} else {
			    		System.out.println("");
			    		System.out.println("PERFIL");
					    System.out.println("01-> Configurar Perfil");
					    System.out.println("02-> Visualizar Perfil");
					    System.out.println("AMIGOS");
					    System.out.println("03-> Solicitar Nova Amizade");
					    System.out.println("04-> Verificar Pedidos de Amizade");
					    System.out.println("05-> Ver Amigos");
					    System.out.println("MENSAGENS");
					    System.out.println("06-> Enviar Mensagem para um Usuário");
					    System.out.println("07-> Enviar Mensagem para uma Comunidade");
					    System.out.println("08-> Visualizar Todas as Mensagens");
					    System.out.println("COMUNIDADES");
					    System.out.println("09-> Criar comunidade");
						System.out.println("10-> Entrar em uma comunidade");
						System.out.println("11-> Ver Minhas Comunidades");
						System.out.println("FEED");
						System.out.println("12-> Configurar seu Feed de Notícias");
						System.out.println("13-> Escrever no Feed de Notícias");
						System.out.println("14-> Visualizar Meu Feed");
						System.out.println("15-> Visualizar Feed Geral");
					    System.out.println("...");
					    System.out.println("19-> Cancelar Cadastro");
					    System.out.println("20-> Deslogar");
						System.out.print("Digite sua opção: ");
						
						int auxLogin=0;
						
					    try {
					    	auxLogin = sc.nextInt();
						    sc.nextLine();
						    System.out.println("");
						} 
						catch (InputMismatchException e) {
							sc.close();
							System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
							return;
						}
					    
					    while (auxLogin != 20) {
						    switch (auxLogin) {
						    case 1:
						    	System.out.println("1-> Alterar login");
								System.out.println("2-> Alterar senha");
								System.out.println("3-> Alterar nome");
								System.out.print("Digite sua opção: ");
								int auxPerfil=0;
							    
							    try {
							    	auxPerfil = sc.nextInt();
								    sc.nextLine();
								} 
								catch (InputMismatchException e) {
									sc.close();
									System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
									return;
								}
							    switch (auxPerfil) {
							    case 1:
							    	System.out.println("Novo login:");
							    	String login1 = sc.nextLine();
							    	for(Conta val : list) {
							    		if(loginConta.contentEquals(val.getLogin()) == true) {
							    			System.out.println("Login alterado de " + val.getLogin() + " para " + login1 + ".");
							    			loginConta = login1;
							    			val.setLogin(login1);
							    		}
							    	}
							    break;
							    case 2:
									System.out.println("Nova senha:");
									String senha1 = sc.nextLine();
									for(Conta val : list) {
										if(loginConta.contentEquals(val.getLogin()) == true) {
											System.out.println("Senha alterado de " + val.getSenha() + " para " + senha1 + ".");
											val.setSenha(senha1);
										}
									}
							    break;
							    case 3:
									System.out.println("Novo nome:");
									String nome1 = sc.nextLine();
									for(Conta val : list) {
										if(loginConta.contentEquals(val.getLogin()) == true) {
											System.out.println("Nome alterado de " + val.getNome() + " para " + nome1 + ".");
											val.setNome(nome1);
										}
									}
							    break;
							    default:
							    	System.out.println("Opção Inválida");
							    }
							break;
						    case 2:
						    	for(Conta val : list) {
									if(loginConta.contentEquals(val.getLogin()) == true) {
										System.out.println(val);
									}
								}
						    break;
						    case 3:
						    	int tamanhoAmi=listAmi.size();
						    	int aux8=listSolAmi.size();
						    	System.out.println("Informe o Login do amigo desejado: ");
						    	String amigoDesejado = sc.nextLine();
						    	if(loginConta.contentEquals(amigoDesejado) == true) {
						    		System.out.println("Você não pode ser seu próprio amigo.");
						    	} else {
						    		tamanhoLista = list.size();
									aux = tamanhoLista;
									for(Conta val : list) {
										if(amigoDesejado.contentEquals(val.getLogin()) == true){
										} else {
											aux--;
										}
									}
									if(aux == 0) {
										System.out.println("Login destinatário não cadastrado");
									} else {
										for(Amizades val : listAmi) {
								    		if(loginConta.contentEquals(val.getAmigo1()) == true) {
								    			if(amigoDesejado.contentEquals(val.getAmigo2()) == true) {
								    				System.out.println("Você já é amigo do " + amigoDesejado + ".");
								    			} else {
								    				tamanhoAmi--;
								    			}
								    		} else if(loginConta.contentEquals(val.getAmigo2()) == true) {
								    			if(amigoDesejado.contentEquals(val.getAmigo1()) == true) {
								    				System.out.println("Você já é amigo do " + amigoDesejado + ".");
								    			} else {
								    				tamanhoAmi--;
								    			}
								    		} else {
								    			tamanhoAmi--;
								    		}
								    	}
										for(SolicitacaoAmizade val : listSolAmi) {
								    		if(loginConta.contentEquals(val.getAmigoDesejado()) == true){
								    			if(amigoDesejado.contentEquals(val.getLoginSolicitante()) == true){
									    			System.out.println(amigoDesejado + " já lhe enviou um pedido de Amizade.\nVerifique seus pedidos.");
												} else {
													aux8--;
												}
											} else if(loginConta.contentEquals(val.getLoginSolicitante()) == true){
								    			if(amigoDesejado.contentEquals(val.getAmigoDesejado()) == true){
									    			System.out.println("Você já enviou anteriormente um pedido a esse usuário.");
												} else {
													aux8--;
												}
											} else {
												aux8--;
											}
								    	}
										if(tamanhoAmi == 0 && aux8 == 0) {
											listSolAmi.add(new SolicitacaoAmizade(loginConta, amigoDesejado));
										    System.out.println("Solicitação enviada.");
										}
									}
						    	}
						    break;
						    case 4:
						    	tamanhoLista = listSolAmi.size();
								aux = tamanhoLista;
								if(tamanhoLista == 0) {
									System.out.println("Sem solicitações no momento");
								} else {
									int resposta;
							    	for(Iterator<SolicitacaoAmizade> iterator = listSolAmi.iterator(); iterator.hasNext(); ) {
							    		SolicitacaoAmizade val = iterator.next();
							    		if(loginConta.contentEquals(val.getAmigoDesejado()) == true){
							    			System.out.println("Aceitar amizade de " + val.getLoginSolicitante() + " ? (s=1/n=2)");
							    			try {
							    				resposta = sc.nextInt();
							    				sc.nextLine();
							    				System.out.println("");
							    			} 
							    			catch (InputMismatchException e) {
							    				sc.close();
							    				System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
							    				return;
							    			}
							    			if(resposta == 1) {
							    				listAmi.add(new Amizades(loginConta, val.getLoginSolicitante()));
							    				System.out.println("Amizade aceita.");
							    				iterator.remove();
							    			} else if(resposta == 2){
							    				System.out.println("Amizade recusada.");
							    				iterator.remove();
							    			} else {
							    				System.out.println("Opção Inválida.");
							    			}
										} else {
											aux--;
											if(aux == 0) {
												System.out.println("Sem solicitações no momento");
											}
										}
							    	}
								}
						    break;
						    case 5:
						    	int tamanhoAmizade = listAmi.size();
						    	if(tamanhoAmizade == 0) {
						    		System.out.println("Nenhum amigo encontrado.");
						    	} else {
							    	for(Amizades val : listAmi) {
							    		if(loginConta.contentEquals(val.getAmigo1()) == true) {
							    			System.out.println(val.getAmigo2());
							    		} else if(loginConta.contentEquals(val.getAmigo2()) == true) {
							    			System.out.println(val.getAmigo1());
							    		} else {
							    			tamanhoAmizade--;
							    			if(tamanhoAmizade == 0) {
							    				System.out.println("Nenhum amigo encontrado.");
							    			}
							    		}
							    	}
						    	}
						    break;
						    case 6:
						    	System.out.println("Informe o login do destinatário:");
								String loginDestinatario = sc.nextLine();
								System.out.println("Informe a mensagem:");
								String mensagem = sc.nextLine();
								tamanhoLista = list.size();
								aux = tamanhoLista;
								for(Conta val : list) {
									if(loginDestinatario.contentEquals(val.getLogin()) == true){
									} else {
										aux--;
									}
								}
								if(aux == 0) {
									System.out.println("Login destinatário não cadastrado");
								} else {
									listMen.add(new Mensagem(loginConta, mensagem, loginDestinatario));
									System.out.println("Mensagem enviada com sucesso.");
								}
						    break;
						    case 7:
						    	if(listCom.size() == 0) {
						    		System.out.println("Nao existe comunidade no momento");
						    	} else {
									System.out.println("Informe o nome da comunidade:");
									String loginDestinatario2 = sc.nextLine();
									System.out.println("Informe a mensagem:");
									String mensagem2 = sc.nextLine();
									int tamanhoListaCom = listCom.size();
									int aux2 = tamanhoListaCom;
									for(Comunidade val : listCom) {
										if(loginDestinatario2.contentEquals(val.getNome()) == true) {
										} else {
											aux2--;
											if(aux2 == 0) {
												System.out.println("Comunidade nao cadastrada");
											}
									    }
									}
									if(aux2 == 0) {
									} else {
										listMen.add(new Mensagem(loginConta, mensagem2, loginDestinatario2));
										System.out.println("Mensagem enviada com sucesso.");
									}
								}
						    break;
						    case 8:
						    	int tamanhoMensagem = listMen.size();
						    	if(tamanhoMensagem == 0) {
						    		System.out.println("Nenhuma mensagem encontrada.");
						    	} else {
							    	for(Mensagem val : listMen) {
							    		if(loginConta.contentEquals(val.getLoginItinerario()) == true) {
							    			System.out.println(val);
							    		} else if(loginConta.contentEquals(val.getLoginDestinatario()) == true) {
							    			System.out.println(val);
							    		} else {
							    			tamanhoMensagem--;
							    			if(tamanhoMensagem == 0) {
							    				System.out.println("Nenhuma mensagem encontrada.");
							    			}
							    		}
							    	}
						    	}
						    break;
						    case 9:
						    	System.out.println("Informe o nome da comunidade:");
								String nomCom = sc.nextLine();
								int tamanhoListaCom2 = listCom.size();
					    		int aux22 = tamanhoListaCom2;
					    		if(aux22 == 0) {
					    			System.out.println("Informe a descrição da comunidade:");
						            String descCom = sc.nextLine();
						            listCom.add(new Comunidade(nomCom, descCom, loginConta));
						            System.out.println("Comunidade criada com sucesso.");
					    		} else {
					    			for(Comunidade val2 : listCom) {
						    			if(nomCom.contentEquals(val2.getNome()) == true) {
						    				System.out.println("Uma comunidade já existe com esse nome.");
						    			} else {
						    				aux22--;
						    			}
						    		}
					    			if(aux22 == 0) {
						    	        System.out.println("Informe a descrição da comunidade:");
									    String descCom = sc.nextLine();
									    listCom.add(new Comunidade(nomCom, descCom, loginConta));
									    System.out.println("Comunidade criada com sucesso.");
						    		}
					    		}
								
								
						    break;
						    case 10:
						    	if(listCom.size() == 0) {
						    		System.out.println("Nao existe comunidade no momento");
						    	} else {
						    		System.out.println("Comunidades Existentes:");
						    		for(Comunidade val2 : listCom) {
						    			System.out.println(val2);
						    		}
						    		System.out.println("");
						    		System.out.println("Informe a comunidade de interesse:");
						    		String nomeComunidade = sc.nextLine();
						    		int tamanhoListaCom = listCom.size();
						    		int aux2 = tamanhoListaCom;
						    		for(Comunidade val2 : listCom) {
						    			if(nomeComunidade.contentEquals(val2.getNome()) == true) {
						    				if(loginConta.contentEquals(val2.getLoginDono()) == true) {
						    					System.out.println("Você já é o dono dessa comunidade.");
						    				} else if(val2.buscarMembro(loginConta) == 1){
						    					System.out.println("Você já faz parte dessa comunidade.");
						    				} else {
						    					val2.addMembro(loginConta);
						    				    System.out.println("Parabéns! Agora você faz parte dessa comunidade.");
						    				}
						    			} else {
						    				aux2--;
						    				if(aux2 == 0) {
						    					System.out.println("Comunidade nao encontrada");
						    				}
						    			}
						    		}
						    	} 
						    break;
						    case 11:
						    	int tamanhoComunidade = listCom.size();
						    	if(tamanhoComunidade == 0) {
						    		System.out.println("Nenhuma comunidade encontrada.");
						    	} else {
							    	for(Comunidade val : listCom) {
							    		if(loginConta.contentEquals(val.getLoginDono()) == true) {
							    			System.out.println(val.getNome() + " (dono)");
							    		} else if (val.buscarMembro(loginConta) == 1){
							    			System.out.println(val.getNome());
							    		} else {
							    			tamanhoComunidade--;
							    			if(tamanhoComunidade == 0) {
							    				System.out.println("Nenhuma comunidade encontrada.");
							    			}
							    		}
							    	}
						    	}
						    break;
						    case 12:
						    	int tamanhoFeed = listFeed.size();
						    	aux = tamanhoFeed;
						    	System.out.println("Escolha a configuração do seu feed:");
						    	System.out.println("1-> Público (todos podem visualizar)");
						    	System.out.println("2-> Privado (apenas amigos conseguem visualizar)");
						    	int feed=0; 
					
						    	try {
									feed = sc.nextInt();
									sc.nextLine();
									System.out.println("");
								} 
								catch (InputMismatchException e) {
									sc.close();
									System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
									return;
								}
						    	if(aux == 0) {
						    		if(feed == 1) {
							    		listFeed.add(new Feed(loginConta, "Público"));
							    		System.out.println("Feed configurado.");
							    	} else if (feed == 2) {
							    		listFeed.add(new Feed(loginConta, "Privado"));
							    		System.out.println("Feed configurado.");
							    	} else {
							    		System.out.println("Opção Inválida.");
							    	}
						    	} else {
							    	for(int i=0; i<tamanhoFeed; i++) {
							    		Feed val2 = new Feed();
							    		val2 = listFeed.get(i);
							    		if(loginConta.contentEquals(val2.getLogin()) == true) {
							    			if(feed == 1) {
									    		val2.setPermissao("Público");
									    		System.out.println("Feed configurado.");
									    	} else if (feed == 2) {
									    		val2.setPermissao("Privado");
									    		System.out.println("Feed configurado.");
									    	} else {
									    		System.out.println("Opção Inválida.");
									    	}
							    		} else {
							    			--aux;
							    			if(aux == 0) {
							    				if(feed == 1) {
										    		listFeed.add(new Feed(loginConta, "Público"));
										    		System.out.println("Feed configurado.");
										    	} else if (feed == 2) {
										    		listFeed.add(new Feed(loginConta, "Privado"));
										    		System.out.println("Feed configurado.");
										    	} else {
										    		System.out.println("Opção Inválida.");
										    	}
							    			}
							    		}      
							        }
						    	}
						    break;
						    case 13:
						    	tamanhoFeed = listFeed.size();
						    	if(tamanhoFeed == 0) {
						    		System.out.println("Seu feed precisa ser configurado primeiro");
						    	} else {
						    		aux = tamanhoFeed;
						    		for(Feed val2 : listFeed) {
							    		if(loginConta.contentEquals(val2.getLogin()) == true) {
							    			System.out.println("Escreva a mensagem para o feed:");
							    	        String feedTexto = sc.nextLine();
							    	        val2.addMensagem(feedTexto);
							    	        System.out.println("Feed atualizado.");
							    		} else {
							    			aux--;
							    			if(aux == 0)
							    				System.out.println("Seu feed precisa ser configurado primeiro");
							    		}      
							        }
						    	}
						    break;
						    case 14:
						    	tamanhoFeed = listFeed.size();
						    	if(tamanhoFeed == 0) {
						    		System.out.println("Nenhuma atividade encontrada no Feed.");
						    	} else {
							    	for(Feed val : listFeed) {
							    		if(loginConta.contentEquals(val.getLogin()) == true) {
							    			System.out.println(val);
							    		} else {
							    			tamanhoFeed--;
							    			if(tamanhoFeed == 0) {
							    				System.out.println("Nenhuma atividade encontrada no Feed.");
							    			}
							    		}
							    	}
						    	}
						    break;
						    case 15:
						    	if(listFeed.size() == 0) {
						    		System.out.println("Feed vazio.");
						    	} else {
						    		for(Feed val : listFeed) {
						    			if(val.getPermissao().contentEquals("Público") == true) {
						    				System.out.println(val);
						    			} else if(loginConta.contentEquals(val.getLogin()) == true){
						    				System.out.println(val);
						    			} else {
						    				if(listAmi.size()>0) {
						    					for(Amizades val2 : listAmi) {
											    	if(loginConta.contentEquals(val2.getAmigo1()) == true && val.getLogin().contentEquals(val2.getAmigo2())) {
											    		System.out.println(val);
											    	} else if(loginConta.contentEquals(val2.getAmigo2()) == true && val.getLogin().contentEquals(val2.getAmigo1())) {
											    		System.out.println(val);
											    	}
						    					}
						    				}
						    			}
						    	    }
						    	}
						    break;
						    case 19:
						    	for (Iterator<Conta> iterator = list.iterator(); iterator.hasNext(); ) {
						    		Conta val = iterator.next();
						    		if(loginConta.contentEquals(val.getLogin()) == true) {
						    			iterator.remove();
						    		}
						    	}
						    	for(Iterator<Comunidade> iterator = listCom.iterator(); iterator.hasNext(); ) {
						    		Comunidade val = iterator.next();
						    		if(loginConta.contentEquals(val.getLoginDono()) == true) {
						    			iterator.remove();
						    		} else if (val.buscarMembro(loginConta) == 1){
						    			val.removeMembro(loginConta);
						    		}
						    	}
						    	for(Iterator<Mensagem> iterator = listMen.iterator(); iterator.hasNext(); ) {
						    		Mensagem val = iterator.next();
						    		if(loginConta.contentEquals(val.getLoginItinerario()) == true) {
						    			iterator.remove();
						    		} else if(loginConta.contentEquals(val.getLoginDestinatario()) == true) {
						    			iterator.remove();
						    		}
						    	}
						    	for(Iterator<SolicitacaoAmizade> iterator = listSolAmi.iterator(); iterator.hasNext(); ) {
						    		SolicitacaoAmizade val = iterator.next();
									if(loginConta.contentEquals(val.getAmigoDesejado()) == true){
										iterator.remove();
									} else if (loginConta.contentEquals(val.getLoginSolicitante()) == true) {
										iterator.remove();
									}
								}
						    	for(Iterator<Amizades> iterator = listAmi.iterator(); iterator.hasNext(); ) {
						    		Amizades val = iterator.next();
						    		if(loginConta.contentEquals(val.getAmigo1()) == true) {
						    			iterator.remove();
						    		} else if(loginConta.contentEquals(val.getAmigo2()) == true) {
						    			iterator.remove();
						    		}
						    	}
						    	for(Iterator<Feed> iterator = listFeed.iterator(); iterator.hasNext(); ) {
						    		Feed val = iterator.next();
						    		if(loginConta.contentEquals(val.getLogin()) == true) {
						    			iterator.remove();
						    		}
						    	}
						    	System.out.println("Cadastro cancelado com sucesso.");
						    break;
						    case 20:
						    break;
						   
							default:
								System.out.println("Opção Inválida.");
					        }
						    if(auxLogin == 19) {
						    	auxLogin = 20;
						    } else {
							    System.out.println("");
					    		System.out.println("PERFIL");
							    System.out.println("01-> Configurar Perfil");
							    System.out.println("02-> Visualizar Perfil");
							    System.out.println("AMIGOS");
							    System.out.println("03-> Solicitar Nova Amizade");
							    System.out.println("04-> Verificar Pedidos de Amizade");
							    System.out.println("05-> Ver Amigos");
							    System.out.println("MENSAGENS");
							    System.out.println("06-> Enviar Mensagem para um Usuário");
							    System.out.println("07-> Enviar Mensagem para uma Comunidade");
							    System.out.println("08-> Visualizar Todas as Mensagens");
							    System.out.println("COMUNIDADES");
							    System.out.println("09-> Criar comunidade");
								System.out.println("10-> Entrar em uma comunidade");
								System.out.println("11-> Ver Minhas Comunidades");
								System.out.println("FEED");
								System.out.println("12-> Configurar seu Feed de Notícias");
								System.out.println("13-> Escrever no Feed de Notícias");
								System.out.println("14-> Visualizar Meu Feed");
								System.out.println("15-> Visualizar Feed Geral");
							    System.out.println("...");
							    System.out.println("19-> Cancelar Cadastro");
							    System.out.println("20-> Deslogar");
								System.out.print("Digite sua opção: ");
							    
							    try {
							    	auxLogin = sc.nextInt();
								    sc.nextLine();
								    System.out.println("");
								} 
								catch (InputMismatchException e) {
									sc.close();
									System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
									return;
								}
						    }
					    }
			    	}
		        }
			break;
			
			default:
				System.out.println("Digite um número correto");
			}
			
			System.out.println("");
			System.out.println("1-> Cadastrar-se");
			System.out.println("2-> Fazer Login");
			System.out.println("3-> Sair do iFace");
			System.out.print("Digite sua opção: ");
			try {
				x = sc.nextInt();
				sc.nextLine();
				System.out.println("");
			} 
			catch (InputMismatchException e) {
				sc.close();
				System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
				return;
			}
		}
		
		System.out.println("\nObrigado por confiar no iFace.");

	    sc.close();

	}
}
