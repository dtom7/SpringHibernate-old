package com.example.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "BOOK")
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	@Column(name = "TITLE")
	private String title;
	@ManyToOne
	@JoinColumn(name = "LIBRARY_ID")
	private Library library;
	@Version
	@Column(name = "VERSION")
	private long version;
	
	public Book() {
		super();
	}

	public Book(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public long getVersion() {
		return version;
	}
	
	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book rhs = (Book) obj;
		return Objects.equals(this.getTitle(), rhs.getTitle());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getTitle());
	}

}
