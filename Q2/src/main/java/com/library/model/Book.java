package com.library.model;

public class Book {
	private int id;
	private String title;
	private String author;
	private double price;

	/*
	 * CREATE TABLE book ( id INT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(200), author VARCHAR(100), price DOUBLE );
	 * INSERT INTO book(title,author,price) VALUES('Java Basics','James',450.0);
	 */
	public Book() {
	}

	public Book(int id, String title, String author, double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
}
