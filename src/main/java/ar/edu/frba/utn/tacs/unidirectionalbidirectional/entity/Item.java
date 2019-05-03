package ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "item")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
    private String name;
    
    private List<ProductItem> productItems = new LinkedList<ProductItem>();	

    public Item() {
    }

    @Id
    @GenericGenerator(name ="generator", strategy ="increment")
    @GeneratedValue(generator ="generator")
    @Column(name ="item_id", nullable =false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name ="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="pk.item")
	public List<ProductItem> getProductItems() {
		return productItems;
	}

	public void setProductItems(List<ProductItem> productItems) {
		this.productItems = productItems;
	}



}
