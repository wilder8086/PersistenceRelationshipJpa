package ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*@Entity
@Table(name = "proj_emp")
@IdClass(ProjectAssociationId.class)*/
public class ProjectAssociation  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long employeeId;
	
	@Id
	private long projectId;


/*	@Column("IS_PROJECT_LEAD")
	private boolean isProjectLead;*/
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="EMPLOYEEID", referencedColumnName="ID")
	private Employee employee;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="PROJECTID", referencedColumnName="ID")
	private Project project;


    public ProjectAssociation() {
    }


	public long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}


	public long getProjectId() {
		return projectId;
	}


	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}


/*	public boolean isProjectLead() {
		return isProjectLead;
	}


	public void setProjectLead(boolean isProjectLead) {
		this.isProjectLead = isProjectLead;
	}*/


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


  
}
