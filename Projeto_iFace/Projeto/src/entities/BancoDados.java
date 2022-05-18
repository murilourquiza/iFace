package entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.enums.PermissaoFeed;

public class BancoDados {
	
	private List <Conta> list = new ArrayList<>();
	private List <Comunidade> listCom = new ArrayList<>();
	private List <MensagemUsuario> listMenUsu = new ArrayList<>();
	private List <MensagemComunidade> listMenCom = new ArrayList<>();
	private List <Amizades> listSolAmi = new ArrayList<>();
	private List <Amizades> listAmi = new ArrayList<>();
	private List <Feed> listFeed = new ArrayList<>();
	
	private int tamanhoLista = 0 ;
	private int tamanhoListaCom = 0;
	private int tamanhoListaMenUsu = 0;
	private int tamanhoListaMenCom = 0;
	private int tamanhoListaSolAmi = 0;
	private int tamanhoListaAmi = 0;
	private int tamanhoListaFeed = 0;
	
	public BancoDados() {
	}

	public int getTamanhoLista() {
		return tamanhoLista;
	}

	public int getTamanhoListaCom() {
		return tamanhoListaCom;
	}

	public int getTamanhoListaMenUsu() {
		return tamanhoListaMenUsu;
	}
	
	public int getTamanhoListaMenCom() {
		return tamanhoListaMenCom;
	}

	public int getTamanhoListaSolAmi() {
		return tamanhoListaSolAmi;
	}

	public int getTamanhoListaAmi() {
		return tamanhoListaAmi;
	}

	public int getTamanhoListaFeed() {
		return tamanhoListaFeed;
	}
	
	public List<Comunidade> getListCom() {
		return listCom;
	}
	
	public List<Conta> getList() {
		return list;
	}

	public List<MensagemUsuario> getListMenUsu() {
		return listMenUsu;
	}
	
	public List<MensagemComunidade> getListMenCom() {
		return listMenCom;
	}

	public List<Amizades> getListSolAmi() {
		return listSolAmi;
	}

	public List<Amizades> getListAmi() {
		return listAmi;
	}

	public List<Feed> getListFeed() {
		return listFeed;
	}
	
	//FEED
	//------------------------------------------------------
	
	public List<String> visualizarFeed(String login) {
		if(tamanhoListaFeed == 0) {
			return null;
		}
		for(Conta val : list) {
    		if(login.contentEquals(val.getLogin()) == true) {
    			if(val.getFeed().size() == 0) {
    				return null;
    			}
    			return val.getFeed();
    		}
    	}
		return null;
	}
	
	public void escreverFeed(String login, String mensagem) {
		for(Conta val : list) {
			if(login.contentEquals(val.getLogin()) == true) {
    			val.addFeed(mensagem);
    		    break;
    		}
		}
		for(Feed val2 : listFeed) {
    		if(login.contentEquals(val2.getLogin()) == true) {
    			val2.addMensagem(mensagem);
    			return;
    		}  
        }
	}
	
	public int buscarLoginNoFeed(String login) {
		if(tamanhoListaFeed == 0) {
			return 0;
		}
		for(Feed val : listFeed) {
    		if(login.contentEquals(val.getLogin()) == true) {
		    	return 1;
    		}     
        }
		return 0;
	}
	
	public void configurarFeed(String login, PermissaoFeed permissao) {
		if(tamanhoListaFeed != 0) {
    		for(Feed val : listFeed) {
	    		if(login.contentEquals(val.getLogin()) == true) {
			    	val.setPermissao(permissao);
			    	return;
	    		}     
	        }
    	}
		listFeed.add(new Feed(login, permissao));
		tamanhoListaFeed = listFeed.size();
	}
	
	//COMUNIDADE
	//------------------------------------------------------
	
	public List<String> visualizarComunidades(String login) {
		if(tamanhoListaCom == 0) {
			return null;
		}
		for(Conta val : list) {
    		if(login.contentEquals(val.getLogin()) == true) {
    			if(val.getComunidades().size() == 0) {
    				return null;
    			}
    			return val.getComunidades();
    		}
    	}
		return null;
	}
	
	public int sairComunidade(String login, String comunidade) {
    	for(Comunidade val : listCom) {
    		if(comunidade.contentEquals(val.getNome()) == true) {
    			if(login.contentEquals(val.getLoginDono()) == true) {
    				return 1;
    			} else if(val.buscarMembro(login) == 1){
    				val.removeMembro(login);
    				for(Conta val2 : list) {
			    		if(login.contentEquals(val2.getLogin()) == true) {
			    			val2.removeComunidades(comunidade);
			    			break;
			    		}
			    	}
    				return 2;
    			} else {
    				return 3;
    			}
    	    }
	    }
    	return 0;
	}
	
	public int entrarComunidade(String login, String comunidade) {
    	for(Comunidade val : listCom) {
    		if(comunidade.contentEquals(val.getNome()) == true) {
    			if(login.contentEquals(val.getLoginDono()) == true) {
    				return 1;
    			} else if(val.buscarMembro(login) == 1){
    				return 2;
    			} else {
    				val.addMembro(login);
    				for(Conta val2 : list) {
			    		if(login.contentEquals(val2.getLogin()) == true) {
			    			val2.addComunidades(comunidade);
			    			break;
			    		}
			    	}
    				return 3;
    			}
    	    }
	    }
    	return 0;
	}
	
	public int criarComunidade(String login, String nomeCom, String descricao) {
		if(tamanhoListaCom != 0) {
			for(Comunidade val2 : listCom) {
				if(nomeCom.contentEquals(val2.getNome()) == true) {
					return 0;
				}
			}
		}
		listCom.add(new Comunidade(nomeCom, descricao, login));
		for(Conta val : list) {
    		if(login.contentEquals(val.getLogin()) == true) {
    			val.addComunidades(nomeCom);
    			break;
    		}
    	}
		tamanhoListaCom = listCom.size();
		return 1;
	}
	
	//MENSAGENS
	//-------------------------------------------------------
	
	public List<String> visualizarMensagens(String login) {
		List <String> auxiliar = new ArrayList<>();
		if(tamanhoListaMenUsu == 0) {
			return null;
		}
		for(MensagemUsuario val : listMenUsu) {
    		if(login.contentEquals(val.getLoginDestinatario()) == true) {
    			auxiliar.add(val.toString());
    		}
    	}
		if(auxiliar.size() == 0) {
			return null;
		}
		return auxiliar;
	}
	
	public int enviarMenComunidade(String loginItinerario, String mensagem, String comunidade) {
		InformacaoMensagem aux = new InformacaoMensagem(loginItinerario, mensagem);
		for(Comunidade val : listCom) {
			if(comunidade.contentEquals(val.getNome()) == true){
				listMenCom.add(new MensagemComunidade(loginItinerario, mensagem, comunidade));
				val.addMensagem(aux);
				tamanhoListaCom = listCom.size();
				return 1;
			}
		}
		return 0;
	}
	
	public void enviarMenUsuario(String loginItinerario, String mensagem, String loginDestinatario) {
		listMenUsu.add(new MensagemUsuario(loginItinerario, mensagem, loginDestinatario));
		for(Conta val : list) {
			if(loginDestinatario.contentEquals(val.getLogin()) == true){
				val.addMensagens(mensagem);
				tamanhoListaMenUsu = listMenUsu.size();
				return;
			}
		}
	}
	//CANCELAR
	//------------------------------------------------------------
	
	public void cancelarConta(String login) {
		for (Iterator<Conta> iterator = list.iterator(); iterator.hasNext(); ) {
    		Conta val = iterator.next();
    		if(login.contentEquals(val.getLogin()) == true) {
    			iterator.remove();
    		}
    	}
		
    	for(Iterator<Comunidade> iterator = listCom.iterator(); iterator.hasNext(); ) {
    		Comunidade val = iterator.next();
    		if(login.contentEquals(val.getLoginDono()) == true) {
    			for(Conta val2 : list) {
    				if(val.buscarMembro(val2.getLogin()) == 1) {
    					val2.removeComunidades(val.getNome());
    					break;
    				}
    			}
    			iterator.remove();
    		} else if (val.buscarMembro(login) == 1){
    			val.removeMembro(login);
    		} 
    	    List <InformacaoMensagem> cancConta = new ArrayList<>();
    		cancConta = val.getMensagens();
    		for(Iterator<InformacaoMensagem> iterator2 = cancConta.iterator(); iterator2.hasNext();) {
    			InformacaoMensagem val3 = iterator2.next();
    			if(val3.getLoginItinerario().contentEquals(login)) {
    				iterator2.remove();
    			}
    		}
    	}
    	
    	for(Iterator<MensagemUsuario> iterator = listMenUsu.iterator(); iterator.hasNext(); ) {
    		Mensagem val = iterator.next();
    		if(login.contentEquals(val.getLoginItinerario()) == true) {
    			for(Conta val2: list) {
    				if(val.getLoginItinerario().contentEquals(val2.getLogin()) == true) {
    					val2.removeMensagens(val.getMensagem());
    				} else if(val.getLoginDestinatario().contentEquals(val2.getLogin()) == true){
    					if(val.getLoginItinerario() != val.getLoginDestinatario()) {
    						val2.removeMensagens(val.getMensagem());
    					}
    				}
    			}
    			iterator.remove();
    		} else if(login.contentEquals(val.getLoginDestinatario()) == true) {
    			iterator.remove();
    		}
    	}
    	
    	for(Iterator<Amizades> iterator = listSolAmi.iterator(); iterator.hasNext(); ) {
    		Amizades val = iterator.next();
			if(login.contentEquals(val.getUsuario2()) == true){
				iterator.remove();
			} else if (login.contentEquals(val.getUsuario1()) == true) {
				for(Conta val2 : list) {
					if(val.getUsuario2().contentEquals(val2.getLogin()) == true) {
						val2.removeSolAmi(login);
					}
				}
				iterator.remove();
			}
		}
    	
    	for(Iterator<Amizades> iterator = listAmi.iterator(); iterator.hasNext(); ) {
    		Amizades val = iterator.next();
    		if(login.contentEquals(val.getUsuario1()) == true) {
    			for(Conta val2 : list) {
    				if(val.getUsuario2().contentEquals(val2.getLogin())) {
    					val2.removeAmigos(val.getUsuario1());
    				}
    			}
    			iterator.remove();
    		} else if(login.contentEquals(val.getUsuario2()) == true) {
    			for(Conta val3 : list) {
    				if(val.getUsuario1().contentEquals(val3.getLogin())) {
    					val3.removeAmigos(val.getUsuario2());
    				}
    			}
    			iterator.remove();
    		}
    	}
    	for(Iterator<Feed> iterator = listFeed.iterator(); iterator.hasNext(); ) {
    		Feed val = iterator.next();
    		if(login.contentEquals(val.getLogin()) == true) {
    			iterator.remove();
    		}
    	}
    	tamanhoLista = list.size();
    	tamanhoListaCom = listCom.size();
    	tamanhoListaMenUsu = listMenUsu.size();
    	tamanhoListaMenCom = listMenCom.size();
    	tamanhoListaSolAmi = listSolAmi.size();
    	tamanhoListaAmi = listAmi.size();
    	tamanhoListaFeed = listFeed.size();
	}
	
	//AMIGOS
	//-------------------------------------------------------------
	
	public List<String> visualizarAmigos(String login) {
		if(tamanhoListaAmi == 0) {
			return null;
		}
		for(Conta val : list) {
    		if(login.contentEquals(val.getLogin()) == true) {
    			if(val.getAmigos().size() == 0) {
    				return null;
    			}
    			return val.getAmigos();
    		}
    	}
		return null;
	}
	
	public void addListAmi(String login, String amigo) {
		listAmi.add(new Amizades(login, amigo));
		tamanhoListaAmi = listAmi.size();
		for(Conta val : list) {
    		if(login.contentEquals(val.getLogin()) == true) {
    			val.addAmigos(amigo);
    			break;
    		}
    	}
		for(Conta val : list) {
    		if(amigo.contentEquals(val.getLogin()) == true) {
    			val.addAmigos(login);
    			return;
    		}
    	}
		return;
	}
	
	public List<String> listaSolAmi(String login) {
		if(tamanhoListaSolAmi == 0) {
			return null;
		}
		for(Conta val : list) {
    		if(login.contentEquals(val.getLogin()) == true) {
    			if(val.getSolAmi().size() == 0) {
    				return null;
    			} 
    			return val.getSolAmi();
    		}
    	}
		return null;
	}
	
	public void removeListSolAmi(String login, String amigoSolicitante) {
		for(Iterator<Amizades> iterator = listSolAmi.iterator(); iterator.hasNext(); ) {
    		Amizades val = iterator.next();
			if(login.contentEquals(val.getUsuario2()) == true){
				iterator.remove();
				break;
			} else if (login.contentEquals(val.getUsuario1()) == true) {
				iterator.remove();
				break;
			}
		}
		for(Conta val : list) {
    		if(login.contentEquals(val.getLogin()) == true) {
    			val.removeSolAmi(amigoSolicitante);
    			break;
    		}
    	}
		tamanhoListaSolAmi = listSolAmi.size();
	}
	
	public void addListSolAmi(String login, String amigoDesejado) {
		listSolAmi.add(new Amizades(login, amigoDesejado));
		for(Conta val : list) {
    		if(amigoDesejado.contentEquals(val.getLogin()) == true) {
    			val.addSolAmi(login);
    		}
    	}
		tamanhoListaSolAmi = listSolAmi.size();
	}
	
	public int verificacaoSolAmi(String login, String amigoDesejado) {
		for(Amizades val : listSolAmi) {
    		if(login.contentEquals(val.getUsuario2()) == true && amigoDesejado.contentEquals(val.getUsuario1()) == true){
	    		return 1;
			} else if(login.contentEquals(val.getUsuario1()) == true && amigoDesejado.contentEquals(val.getUsuario2()) == true){
	    		return 2;
			}
    	}
		return 0;
	}
	
	public int verificacaoAmizade(String login, String amigoDesejado) {
		for(Amizades val : listAmi) {
    		if(login.contentEquals(val.getUsuario1()) == true && amigoDesejado.contentEquals(val.getUsuario2()) == true) {
    			return 1;
    		} else if(login.contentEquals(val.getUsuario2()) == true && amigoDesejado.contentEquals(val.getUsuario1()) == true) {
    			return 1;
    		}
    	}
		return 0;
	}
	
	//CONTA
	//--------------------------------------------------------------------------------------------
	
	public String imprimirConta(String login) {
		for(Conta val : list) {
			if(login.contentEquals(val.getLogin()) == true) {
				System.out.println(val.toString());
				return val.toString();
			}
		}
		return null;
	}
	
	public void mudarNomeList(String loginConta, String nomeNovo) {
		for(Conta val : list) {
			if(loginConta.contentEquals(val.getLogin()) == true) {
				val.setNome(nomeNovo);
				return;
			}
    	}
	}
	
	public String buscaSenhaList(String login) {
		if(tamanhoLista != 0) {
    		for(Conta val : list) {
	    		if(login.contentEquals(val.getLogin()) == true) {
	    			return val.getSenha();
	    		}
	    	}
	    }
		return null;
	}
	
	public void mudarSenhaList(String loginConta, String senhaNova) {
		for(Conta val : list) {
			if(loginConta.contentEquals(val.getLogin()) == true) {
				val.setSenha(senhaNova);
				return;
			}
    	}
		return;
	}
	
	public void mudarLoginList(String loginConta, String loginNovo) {
		for(Conta val : list) {
    		if(loginConta.contentEquals(val.getLogin()) == true) {
    			val.setLogin(loginNovo);
    		    return;
    		}
    	}
		return;
	}

	public String buscaList(String login) {
		if(tamanhoLista != 0) {
    		for(Conta val : list) {
	    		if(login.contentEquals(val.getLogin()) == true) {
	    			return val.getNome();
	    		}
	    	}
	    }
		return null;
	}
	
	public void addList(String login, String senha, String nome) {
		list.add(new Conta(login, senha, nome));
		tamanhoLista = list.size();
	}
	
	//VIZUALIZAR DADOS
	
	public int mostrarSolUsu(String login) {
		if(tamanhoListaSolAmi == 0) {
			return 0;
		}
		for(Conta val : list) {
    		if(login.contentEquals(val.getLogin()) == true) {
    			return val.getSolAmi().size();
    		}
    	}
		return 0;
	}
	
	public int mostrarAmi(String login) {
		if(tamanhoListaAmi == 0) {
			return 0;
		}
		for(Conta val : list) {
    		if(login.contentEquals(val.getLogin()) == true) {
    			return val.getAmigos().size();
    		}
    	}
		return 0;
	}
	
	public int mostrarMen(String login) {
		if(tamanhoListaMenUsu == 0) {
			return 0;
		}
		for(Conta val : list) {
    		if(login.contentEquals(val.getLogin()) == true) {
    			return val.getMensagens().size();
    		}
    	}
		return 0;
	}
	
	public int mostrarCom(String login) {
		if(tamanhoListaCom == 0) {
			return 0;
		}
		for(Conta val : list) {
    		if(login.contentEquals(val.getLogin()) == true) {
    			return val.getComunidades().size();
    		}
    	}
		return 0;
	}

}
