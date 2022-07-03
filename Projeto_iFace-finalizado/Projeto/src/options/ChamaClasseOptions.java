package options;

import java.util.List;
import java.util.Scanner;

import entities.BancoDados;

public class ChamaClasseOptions {
	public String Write(Options language, boolean verificacao, int entradaConfigurarPerfil, String loginConta, BancoDados dados, Scanner sc, List<String> auxiliar)
    {
        return language.escolhasLogado(verificacao, entradaConfigurarPerfil, loginConta, dados, sc, auxiliar);
    }
}
