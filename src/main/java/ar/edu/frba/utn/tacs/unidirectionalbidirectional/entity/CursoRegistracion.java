package ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * En un mundo ideal, podríamos resolver esto con la solución anterior, cuando teníamos una entidad con una 
 * clave compuesta. Sin embargo, nuestro mundo está lejos de ser ideal y los estudiantes no siempre realizan 
 * un curso en el primer intento.
 * En este caso, hay varias conexiones entre los mismos pares de cursos de estudiantes, o varias filas, 
 * con los mismos pares student_id-course_id. No podemos modelarlo usando ninguna de las soluciones anteriores 
 * porque todas las claves primarias deben ser únicas. Por lo tanto, necesitamos usar una clave primaria separada.
 * 
 * Por lo tanto, podemos introducir una entidad, que mantendrá los atributos del registro:
 * En este caso, la entidad CursoRegistracion representa la relación entre las otras dos entidades. Y como es una entidad
 * tendra su propia primary key.
 * 
 * Tenga en cuenta que en una solución es tener primary key compuesta, que creamos a partir de las dos 
 * foreign keys. Ahora, las dos foreign keys no serán parte de la primary key.
 * 
 * Tenga en cuenta que podríamos usar esta solución para solucionar el problema de Student y course: los estudiantes 
 * calificaron los cursos. Sin embargo, es extraño crear una primary key dedicada a menos que sea necesario. 
 * Además, desde una perspectiva RDBMS, no tiene mucho sentido, ya que combinar las dos foreign keys es una clave 
 * compuesta perfecta. Además, esa clave compuesta tenía un significado claro: qué entidades conectamos en la 
 * relación.
 * De lo contrario, la elección entre estas dos implementaciones a menudo es simplemente una preferencia personal.
 * 
 */

@Entity
public class CursoRegistracion {
	@Id
    Long id;
 
    @ManyToOne
    @JoinColumn(name = "alumno_id")
    Alumno alumno;
 
    @ManyToOne
    @JoinColumn(name = "curso_id")
    Curso curso;
 
    LocalDateTime registreredAt;
 
    int grade;

	public CursoRegistracion() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDateTime getRegistreredAt() {
		return registreredAt;
	}

	public void setRegistreredAt(LocalDateTime registreredAt) {
		this.registreredAt = registreredAt;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
    
    
}
