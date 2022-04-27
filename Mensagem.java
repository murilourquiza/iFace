package entities;

public class Mensagem {
	
	private String loginItinerario;
	private String mensagem;
	private String loginDestinatario;
	
	public Mensagem(String loginItinerario, String mensagem, String loginDestinatario) {
		this.loginItinerario = loginItinerario;
		this.mensagem = mensagem;
		this.loginDestinatario = loginDestinatario;
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

	public String getLoginDestinatario() {
		return loginDestinatario;
	}

	public void setLoginDestinatario(String loginDestinatario) {
		this.loginDestinatario = loginDestinatario;
	}
	
	public String toString() {
		return "Itinerario: " + loginItinerario + " .Mensagem: " + mensagem + " .Destinatário: " + loginDestinatario;
	}

}
