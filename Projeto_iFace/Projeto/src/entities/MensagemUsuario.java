package entities;

public class MensagemUsuario extends Mensagem{

	public MensagemUsuario() {
		super();
	}

	public MensagemUsuario(String loginItinerario, String mensagem, String loginDestinatario) {
		super(loginItinerario, mensagem, loginDestinatario);
	}
}
