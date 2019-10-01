package ApiFullRest.Dev.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ApiFullRest.Dev.Repositories.UsuarioRepository;
import ApiFullRest.Dev.model.Usuario;

@RestController
@RequestMapping("/Usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@GetMapping
	public List<Usuario> obtenerCadena() {
		
		 List<Usuario> usuarios = userRepository.findAll();
		 
		 for(Usuario u : usuarios) {
			 
			 
		 }
		 
		 
		 return null;
	}
	

  /*@GetMapping("/ObtenerUsuario/{id}")
  public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId)
      throws ResourceNotFoundException {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    return ResponseEntity.ok().body(user);
  }*/
  

  @PostMapping("/CrearUsuario")
  public Usuario createUser(@Valid @RequestBody Usuario user) {
	  return userRepository.save(user);
  }

  /*@PutMapping("/users/{id}")
  public ResponseEntity<User> updateUser(
      @PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails)
      throws ResourceNotFoundException {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    user.setEmail(userDetails.getEmail());
    user.setLastName(userDetails.getLastName());
    user.setFirstName(userDetails.getFirstName());
    user.setUpdatedAt(new Date());
    final User updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }*/

  
  /*@DeleteMapping("/user/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    userRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }*/

}
