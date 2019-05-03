package ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Child")
public class Child implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name = "Name")
    private String name;


    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
    @JoinColumn(name = "parentId", nullable = false)
    private Parent parent;

    public Child() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Parent getParent() {
        return parent;
    }

    public int getParent_Id(){
        return parent.getId();
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
