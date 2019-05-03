package ar.edu.frba.utn.tacs.unidirectionalbidirectional.service;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao.ChildDao;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao.ParentDao;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Author;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Book;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Child;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Parent;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ChildService {

    @Autowired
    ChildDao childDao;

    @Autowired
    ParentDao parentDao;

    public Optional<Child> getChildById(int childId) {
        if (!childDao.existsById(childId)) {
            throw new ResourceNotFoundException("Book with id " + childId + " not found");
        }
        return childDao.findById(childId);
    }


    public Child createChild(int childId, Child child) {
        Set<Child> children = new HashSet<>();
        Parent parent = new Parent();

        Optional<Parent> byId = parentDao.findById(childId);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Parent with id " + childId + " does not exist");
        }
        Parent parent1 = byId.get();

        //tie Author to Book
        child.setParent(parent1);

        Child child1 = childDao.save(child);
        //tie Book to Author
        children.add(child1);
        parent.setChildren(children);

        return child1;

    }

}
