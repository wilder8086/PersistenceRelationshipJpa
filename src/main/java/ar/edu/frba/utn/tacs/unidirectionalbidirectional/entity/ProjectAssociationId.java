package ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity;

import java.io.Serializable;

public class ProjectAssociationId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long employeeId;

	private long projectId;

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

	public int hashCode() {
		return (int) (employeeId + projectId);
	}

	public boolean equals(Object object) {
		if (object instanceof ProjectAssociationId) {
			ProjectAssociationId otherId = (ProjectAssociationId) object;
			return (otherId.employeeId == this.employeeId)
					&& (otherId.projectId == this.projectId);
		}
		return false;
	}
}
