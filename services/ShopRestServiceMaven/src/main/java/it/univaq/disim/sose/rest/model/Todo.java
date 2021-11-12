/*
package it.univaq.disim.sose.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Todo")
public class Todo {
	private Long id;
	private String summary;
	private String description;

	public Todo() {

	}

	public Todo(Long id) {
		this.id = id;		
	}
	
	public Todo(Long id, String summary, String description) {
		this.id = id;
		this.summary = summary;
		this.description = description;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (!(obj instanceof Todo))return false;
		Todo objClass = (Todo)obj;
		return this.id == objClass.getId() ? true : false;
	}
}
*/