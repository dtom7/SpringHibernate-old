package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "LIBRARY")
public class Library {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	@Column(name = "NAME")
	private String name;
	@OneToMany(cascade={CascadeType.ALL}, orphanRemoval = true, mappedBy = "library", fetch=FetchType.LAZY)
	private List<Book> books = new ArrayList<Book>();
	@Version
	@Column(name = "VERSION")
	private long version;
	
	public Library() {
		super();
	}

	public Library(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getVersion() {
		return version;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}	

}
