package ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Project")
public class Project implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Name")
    @NotBlank(message = "Enter the project's name")
    public String name;

    @Column(name = "detalle")
    @NotBlank(message = "Enter the project's detail")
    public String detalle;

 
    @ManyToMany(mappedBy="projects")
    private List<Employee> employees;
    

/*    
    @OneToMany
    private List<ProjectAssociation> employees;    
    */
    public Project() {
    }


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


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	/*
	public List<ProjectAssociation> getEmployees() {
		return employees;
	}


	public void setEmployees(List<ProjectAssociation> employees) {
		this.employees = employees;
	}


*/
	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

  
}
