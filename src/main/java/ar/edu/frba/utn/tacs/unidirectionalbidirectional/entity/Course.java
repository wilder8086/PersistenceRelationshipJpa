package ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "course")
public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "ID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "medal_seq")
    @SequenceGenerator(name = "medal_seq", sequenceName = "medal_seq", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", length = 50, unique = true)
    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    
    //@JsonManagedReference // serializamos una instancia de esta clase(Nedal) a Json y obtenemos una matriz que tiene instancias de esta collecion (soldiers)
    //@JsonIgnoreProperties("medals")
    //@JsonIgnore  // si se setea ignora esta relacion, y obtendra solo un array de esta clase, y no una matriz de con esta lista
    @OneToMany(mappedBy = "course")
    Set<CourseRating> ratings;
   

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

	public Set<CourseRating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<CourseRating> ratings) {
		this.ratings = ratings;
	}
    
}
