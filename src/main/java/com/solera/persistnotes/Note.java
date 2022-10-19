package com.solera.persistnotes;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	Date date_completion;

	String text;
	String link;
	String mentions;
	String description;
	int priority;
	Date date_est_completion;
	Date date_creation;
	
	public Note(String description, String text, String link, String mentions, int priority, Date date_est_completion) {
		super();
		this.description = description;
		this.text = text;
		this.link = link;
		this.mentions = mentions;
		this.priority = priority;
		this.date_est_completion = date_est_completion;
		
		this.date_creation = new Date();
		this.date_completion = null;
		
	}
	
	public void setDateCompletion() {
		this.date_completion = new Date();
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", date_completion=" + date_completion + ", text=" + text + ", link=" + link
				+ ", mentions=" + mentions + ", description=" + description + ", priority=" + priority
				+ ", date_est_completion=" + date_est_completion + ", date_creation=" + date_creation + "]";
	}

}
