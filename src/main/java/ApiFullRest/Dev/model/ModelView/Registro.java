package ApiFullRest.Dev.model.ModelView;

import ApiFullRest.Dev.model.Persona;
import ApiFullRest.Dev.model.Usuario;

public class Registro {
	
	private Usuario usuario;
	
	private Persona persona;
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
