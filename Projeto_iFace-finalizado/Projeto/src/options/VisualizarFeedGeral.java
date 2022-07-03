package options;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Amizades;
import entities.BancoDados;
import entities.Feed;
import entities.enums.PermissaoFeed;

public class VisualizarFeedGeral implements Options{
	public String escolhasLogado(boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar) {
		int auxFeed=dados.getTamanhoListaFeed();
    	List <Feed> listaFeed = new ArrayList<>();
    	listaFeed = dados.getListFeed();
    	List <Amizades> listaAmi = new ArrayList<>();
    	listaAmi = dados.getListAmi();
    	if(auxFeed == 0) {
    		System.out.println("Feed vazio.");
    	} else {
    		for(Feed val : listaFeed) {
    			int auxAmi=dados.getTamanhoListaAmi();
    			if(val.getPermissao() == PermissaoFeed.Publico ) {
    				System.out.println(val);
    			} else if(loginConta.contentEquals(val.getLogin()) == true){
    				System.out.println(val);
    			} else {
    				if(listaAmi.size() != 0) {
    					for(Amizades val2 : listaAmi) {
					    	if(loginConta.contentEquals(val2.getUsuario1()) == true && val.getLogin().contentEquals(val2.getUsuario2())) {
					    		System.out.println(val);
					    	} else if(loginConta.contentEquals(val2.getUsuario2()) == true && val.getLogin().contentEquals(val2.getUsuario1())) {
					    		System.out.println(val);
					    	} else {
					    		auxAmi--;
					    	}
    					}
    				}
    				if(auxAmi == 0) {
    					auxFeed--;
    				}
    			}
    	    }
    		if(auxFeed == 0) {
    			System.out.println("Feed vazio.");
    		}
    	}
    	return loginConta;
	}
}
