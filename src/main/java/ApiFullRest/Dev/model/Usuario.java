package ApiFullRest.Dev.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Usuario")
@EntityListeners(AuditingEntityListener.class)

public class Usuario {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
    private long id;
    
    @Column(name = "idPersona", nullable = false)
    private long idPersona;
    
    @Column(name = "Usuario", nullable = false, unique = true)
    private String usuario;
    
    @Column(name = "Contrasena", nullable = false)
    private String contrasena;
    
    
    @Column(name = "roles", nullable = true)
    private String roles = "";
    
    @Column(name = "permisos", nullable = true)
    private String permissions = "";
    
    public Usuario() {
    	
    }
    
    public Usuario(String usuario, String contrasena, String roles, String permissions) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.roles = roles;
        this.permissions = permissions;
    }
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	  public String getRoles() {
	        return roles;
	    }
	
	public String getPermissions() {
        return this.permissions;
    }
	
	 public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length() > 0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

}