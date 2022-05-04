package entities;

public class InformacaoMensagem {
	
	private String loginItinerario;
	private String mensagem;
	
	public InformacaoMensagem() {
	}
	
	public InformacaoMensagem(String loginItinerario, String mensagem) {
		this.loginItinerario = loginItinerario;
		this.mensagem = mensagem;
	}

	public String getLoginItinerario() {
		return loginItinerario;
	}

	public void setLoginItinerario(String loginItinerario) {
		this.loginItinerario = loginItinerario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String toString() {
		return "Itinerário: " + loginItinerario + ", mandou -> " + mensagem;
	}
}
