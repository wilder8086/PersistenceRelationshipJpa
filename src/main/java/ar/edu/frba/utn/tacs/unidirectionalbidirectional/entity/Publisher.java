package ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publisher")
public class Publisher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String name;
	
	@ManyToMany(mappedBy = "publishers")
	private Set<Magazine> magazines = new HashSet<>();
	

    public Publisher(String name) {
        this.name = name;
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Magazine> getMagazines() {
		return magazines;
	}


	public void setMagazines(Set<Magazine> magazines) {
		this.magazines = magazines;
	}

}
