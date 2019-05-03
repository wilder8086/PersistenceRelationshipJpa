package ar.edu.frba.utn.tacs.unidirectionalbidirectional.service;

import java.util.List;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao.ProjectRepository;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	
    @Autowired
    ProjectRepository projectRepository;

    public Project getProjectById(Long id) {
        return projectRepository.getById(id);
    }

    
    public Project addProject(Project project) {
        return projectRepository.save(project);

    }

	public List<Project> getProjects() {
		return projectRepository.findAll();
	}    
}
