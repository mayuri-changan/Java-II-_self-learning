package com.library.model;

public class Book {
	private int id;
	private String title;
	private String author;

	/*
	 * CREATE TABLE books ( id INT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(100), author VARCHAR(100) );
	 */
	public Book() {
	}

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
}
