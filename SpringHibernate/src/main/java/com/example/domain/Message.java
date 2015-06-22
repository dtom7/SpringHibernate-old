package com.example.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "MESSAGE_TBL")
public class Message {

	@Id
	@GeneratedValue
	@Column(name = "MESSAGE_ID")
	private long id;
	@Column(name = "MESSAGE_TEXT")
	private String text;
	@Version
	@Column(name = "MESSAGE_VERSION")
	private long version;

	public Message() {
	}

	public Message(String text) {
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getVersion() {
		return version;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Message rhs = (Message) obj;
		return Objects.equals(this.getText(), rhs.getText());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getText());
	}

}
