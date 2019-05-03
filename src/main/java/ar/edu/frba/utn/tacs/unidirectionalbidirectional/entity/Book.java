package ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Book")
public class Book  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Title")
    @NotBlank(message = "Enter a title ")
    private String title;

    @Column(name = "Genre")
    @NotBlank(message = "Enter a genre ")
    private String genre;


    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
    @JoinColumn(name = "authorId", nullable = false)
    private Author author;


    public Book() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //getter method to retrieve the AuthorId
    public Long getAuthor_id(){
        return author.getId();
    }

    //getter Method to get the author's full name
    public String getAuthorName(){
        return author.getFirstName() + " " + author.getLastName();
    }

    @JsonIgnore
    public Author getAuthor() {
        return author;
    }

    @JsonIgnore
    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
