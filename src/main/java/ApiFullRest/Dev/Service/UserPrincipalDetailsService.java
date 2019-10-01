package ApiFullRest.Dev.Service;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ApiFullRest.Dev.UserPrincipal;
import ApiFullRest.Dev.Repositories.UsuarioRepository;
import ApiFullRest.Dev.model.Usuario;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
	
    private UsuarioRepository userRepository;

    public UserPrincipalDetailsService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<Usuario> user = this.userRepository.findAll();
        
        Usuario thisone = new Usuario(); 
        for (Usuario usuario : user) {
        	if(thisone.getUsuario().equals(s)) {
        		thisone = usuario;
        		break;
        	}
		}
        
        UserPrincipal userPrincipal = new UserPrincipal(thisone);

        return userPrincipal;
    }
    
    public Usuario save(Usuario u) {
    	return this.userRepository.save(u);
    }
    
}