package entities;

public abstract class Mensagem extends InformacaoMensagem {
	
	private String loginDestinatario;
	
	public Mensagem() {
		super();
	}

	public Mensagem(String loginItinerario, String mensagem, String loginDestinatario) {
		super(loginItinerario, mensagem);
		this.loginDestinatario = loginDestinatario;
	}

	public String getLoginDestinatario() {
		return loginDestinatario;
	}

	public void setLoginDestinatario(String loginDestinatario) {
		this.loginDestinatario = loginDestinatario;
	}
}
