package ApiFullRest.Dev.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ApiFullRest.Dev.Repositories.UsuarioRepository;
import ApiFullRest.Dev.model.Usuario;

@RestController
@RequestMapping("/log")
public class LoginController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping("/in")
	@PostMapping
	public Usuario in(@RequestBody Usuario usuario) {
		
		 List<Usuario> usuarios = usuarioRepository.findAll();
		 
		 Usuario goodone = new Usuario();
		 for(Usuario u : usuarios) {
			 
			 if(u.getUsuario().equals(usuario.getUsuario())) {
				 
				 System.out.println(this.passwordEncoder.matches(usuario.getContrasena(), u.getContrasena()));
				 
				 if(this.passwordEncoder.matches(usuario.getContrasena(), u.getContrasena()) ) {
					 goodone = u;
					 
					 return goodone;
					 
				 }
				 
			 }
			 
		 }
		return goodone;
		
		
	}
	
}
