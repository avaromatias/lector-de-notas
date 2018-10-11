package dominio;

import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class Asignacion {

	private String id;
	private String title;
	private String description;

	private List<Grade> grades = new LinkedList<>();

	public Asignacion() {}

	public List<Grade> getGrades() {
		return grades;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

}