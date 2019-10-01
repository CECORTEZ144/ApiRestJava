package ApiFullRest.Dev.Controller;

import javax.transaction.Transaction;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ApiFullRest.Dev.Repositories.PersonaRepository;
import ApiFullRest.Dev.Repositories.UsuarioRepository;
import ApiFullRest.Dev.model.Persona;
import ApiFullRest.Dev.model.Usuario;
import ApiFullRest.Dev.model.ModelView.Registro;


@RestController
@RequestMapping("/registro")
public class RegistroController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/alta")
	public Usuario crearPersona(@RequestBody Registro registro) {
				
		System.out.println(registro.getPersona().getDireccion());

		System.out.println(registro.getPersona().getNombre());

		System.out.println(registro.getPersona().getEdad());

		System.out.println(registro.getPersona().getTelefono());
		
		System.out.println(registro.getPersona().getId());
		
		Persona resultPersona =  personaRepository.save(registro.getPersona());
		
		if(resultPersona.getId() > 0) {
			
			registro.getUsuario().setIdPersona(resultPersona.getId());
			
			registro.getUsuario().setContrasena(passwordEncoder.encode(registro.getUsuario().getContrasena()));
			
		
			
			return usuarioRepository.save(registro.getUsuario());
			
		}
		
		return null;	
		
	}
	
}
