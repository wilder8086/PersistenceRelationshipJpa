package ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ID", nullable = false, length = 10)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    public String name;
    
    private String lastname;

    @OneToMany(mappedBy = "alumno")
    //@JsonBackReference // Serializamos una instalcia de esa clase(Soldier) pero no obtenemos una matriz con Medals   
    //@JsonIgnoreProperties("soldiers")
    //@JsonIgnore  // si se setea ignora esta relacion, y obtendra solo un array de esta clase, y no una matriz de con esta lista
    //@JsonSerialize(using = CustomListSerializer.class)
    private Set<CursoRegistracion> registrations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<CursoRegistracion> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<CursoRegistracion> registrations) {
		this.registrations = registrations;
	}

  

}
