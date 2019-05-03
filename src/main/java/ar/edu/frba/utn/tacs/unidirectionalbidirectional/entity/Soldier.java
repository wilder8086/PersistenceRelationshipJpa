package ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.repository.CustomListSerializer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "soldier")
public class Soldier implements Serializable {

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
    
    private String sequence;

    private String abbreviatedSequence;

    //@ManyToMany(fetch = FetchType.LAZY, mappedBy = "soldiers")
    
    // @JoinTable Define la estructura intermedia que contendra la relacion entre soldier y medal
    // @JoinTable no es obligatoria y en caso de no definirse JPA asumirá el nombre de la tabla, columnas, longitud, etc.
    @ManyToMany 
    @JoinTable(
    		  name = "soldier_medals", 
    		  joinColumns = @JoinColumn(name = "soldier_id"), 
    		  inverseJoinColumns = @JoinColumn(name = "medal_id"))
    //@JsonBackReference // Serializamos una instalcia de esa clase(Soldier) pero no obtenemos una matriz con Medals   
    //@JsonIgnoreProperties("soldiers")
    //@JsonIgnore  // si se setea ignora esta relacion, y obtendra solo un array de esta clase, y no una matriz de con esta lista
    //@JsonSerialize(using = CustomListSerializer.class)
    private List<Medal> medals;

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
    public List<Medal> getMedals() {
        return medals;
    }

    public void setMedals(List<Medal> medals) {
        this.medals = medals;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getAbbreviatedSequence() {
        return abbreviatedSequence;
    }

    public void setAbbreviatedSequence(String abbreviatedSequence) {
        this.abbreviatedSequence = abbreviatedSequence;
    }
}
