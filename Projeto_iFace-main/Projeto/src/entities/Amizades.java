package entities;

public class Amizades {
	
	private String usuario1;
	private String usuario2;
	
	public Amizades() {
	}

	public Amizades(String usuario1, String usuario2) {
		this.usuario1 = usuario1;
		this.usuario2 = usuario2;
	}

	public String getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(String usuario1) {
		this.usuario1 = usuario1;
	}

	public String getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(String usuario2) {
		this.usuario2 = usuario2;
	}

}
