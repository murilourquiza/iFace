package entities;

public class SolicitacaoAmizade {
	
	private String loginSolicitante;
	private String amigoDesejado;
	
	
	
	public SolicitacaoAmizade() {
	}

	public SolicitacaoAmizade(String loginSolicitante, String amigoDesejado) {
		this.loginSolicitante = loginSolicitante;
		this.amigoDesejado = amigoDesejado;
	}

	public String getLoginSolicitante() {
		return loginSolicitante;
	}

	public void setLoginSolicitante(String loginSolicitante) {
		this.loginSolicitante = loginSolicitante;
	}

	public String getAmigoDesejado() {
		return amigoDesejado;
	}

	public void setAmigoDesejado(String amigoDesejado) {
		this.amigoDesejado = amigoDesejado;
	}

}
