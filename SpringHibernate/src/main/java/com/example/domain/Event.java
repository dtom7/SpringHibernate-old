package com.example.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="EVENT")
public class Event {
	
	@Id
	@GeneratedValue
	@Column(name = "EVENT_ID")
    private int id;
	@Column(name = "EVENT_TITLE")
    private String title;
    @Column(name = "EVENT_DATE")
    private Date date;
    @ManyToMany(mappedBy="eventList")
    private List<Person> personList = new ArrayList<>();

    public Event() {}

    public Event(String title, Date date) {
		super();
		this.title = title;
		this.date = date;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
