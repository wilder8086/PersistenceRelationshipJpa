package ar.edu.frba.utn.tacs.unidirectionalbidirectional.controller;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Author;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Book;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Child;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Employee;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Magazine;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Medal;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Parent;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Project;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Soldier;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.repository.RequestWrapper;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.service.AuthorService;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.service.BookService;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.service.ChildService;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.service.EmployeeService;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.service.MagazineService;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.service.MedalService;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.service.ParentService;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.service.ProjectService;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.service.SoldierService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class AuthorBookController {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @Autowired
    ParentService parentService;

    @Autowired
    ChildService childService;

    
    @Autowired
    MagazineService magazineService;    
    
    
    @Autowired
    private SoldierService soldierService;
    
    @Autowired
    private MedalService medalService;
    
    
    @Autowired
    private EmployeeService employeeService;  
    
    @Autowired
    private ProjectService projectService;     
    
    @RequestMapping(value = "/getAllAuthors", method = RequestMethod.GET)
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    //
    @RequestMapping(value = "/author", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @RequestMapping(value = "/parent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Parent createParent(@RequestBody Parent parent) {
        return parentService.createParent(parent);
    }


    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.GET)
    public Optional<Author> getAuthorById(@PathVariable(value = "authorId") Long authorId) {
        return authorService.getAuthorById(authorId);
    }

    @RequestMapping(value = "/author", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Author updateAuthor(@PathVariable(value = "authorId") Long authorId, @RequestBody Author author) {
        return authorService.updateAuthorById(authorId, author);
    }

    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAuthorById(@PathVariable(value = "authorId") long authorId) {
        return authorService.deleteAuthorById(authorId);
    }

    @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }


    //
    @RequestMapping(value = "/{authorId}/book", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book createBook(@PathVariable(value = "authorId") Long authorId, @RequestBody Book book) {
        return bookService.createBook(authorId, book);
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public Optional<Book> getBookById(@PathVariable(value = "bookId") Long bookId) {
        return bookService.getBookById(bookId);
    }


    @RequestMapping(value = "/book", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book updateBook(@PathVariable(value = "bookId") Long bookId, @RequestBody Book book) {
        return bookService.updateBookById(bookId, book);
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBookById(@PathVariable(value = "bookId") long bookId) {
        return bookService.deleteBookById(bookId);
    }


    @RequestMapping(value = "/{parentId}/child", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Child createChild(@PathVariable(value = "parentId") int parentId, @RequestBody Child child) {
        return childService.createChild(parentId, child);
    }

    @RequestMapping(value = "/child/{childId}", method = RequestMethod.GET)
    public Optional<Child> getChildById(@PathVariable(value = "childId") int childId) {
        return childService.getChildById(childId);
    }

    
    @RequestMapping(value = "/magazine", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Magazine createMagazine(@RequestBody RequestWrapper requestWrapper) {
    	
    	Magazine magazine = new Magazine();
    	
    	BeanUtils.copyProperties(requestWrapper ,magazine );
    	
        return magazineService.createMagazine(magazine);
    }    
    
    
    @RequestMapping(value = "/soldier", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Soldier  addSoldier(@RequestBody Soldier soldier) {
    	
    	for(Medal s: soldier.getMedals()) {
            Medal ss = medalService.getMedalById(s.getId());
            ss.getSoldiers().add(soldier);
            medalService.addMedal(ss);
        }   
    	
        return soldierService.createSoldier(soldier);
    } 
    
    
    @RequestMapping(value = "/medal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Medal createMedal(@RequestBody Medal medal) {
        return medalService.addMedal(medal);
    }    
    
    
    @RequestMapping(value = "/getAllSoldiers", method = RequestMethod.GET)
    public List<Soldier> getSoldiers() {
    	
    	List<Soldier> lista = soldierService.getSoldiers();
    	
        return lista;
    }    
    
    @RequestMapping(value = "/getAllMedals", method = RequestMethod.GET)
    public List<Medal> getMedals() {
    	
    	List<Medal> lista = medalService.getMedals();
    	
        return lista;
    }  
    
    
    @RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee  addEmployee(@RequestBody Employee employee) {
    	
    	for(Project s: employee.getProjects()) {
            Project ss = projectService.getProjectById(s.getId());
            ss.getEmployees().add(employee);
            projectService.addProject(ss);
        }   
    	
        return employeeService.createEmployee(employee);
    } 
    
    
    @RequestMapping(value = "/project", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Project createProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }   
    
    
    
    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
    	
    	List<Employee> lista = employeeService.getEmployees();
    	
        return lista;
    }    
    
    @RequestMapping(value = "/getAllProjects", method = RequestMethod.GET)
    public List<Project> getProjects() {
    	
    	List<Project> lista = projectService.getProjects();
    	
        return lista;
    }     
    
}