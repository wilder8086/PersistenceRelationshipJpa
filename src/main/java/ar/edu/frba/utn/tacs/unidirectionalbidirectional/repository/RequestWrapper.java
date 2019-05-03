package ar.edu.frba.utn.tacs.unidirectionalbidirectional.repository;

import java.io.Serializable;
import java.util.List;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Publisher;

public class RequestWrapper implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Publisher> publishers;
	private String name;
	
	public List<Publisher> getPublishers() {
		return publishers;
	}
	public void setPublishers(List<Publisher> publishers) {
		this.publishers = publishers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
    
}
