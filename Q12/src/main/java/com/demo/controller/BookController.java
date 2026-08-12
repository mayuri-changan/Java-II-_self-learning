package com.demo.controller;

import com.demo.model.Book;
import com.demo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
	private final BookRepository repo;

	public BookController(BookRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("books", repo.findAll());
		return "index";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		System.out.println("Add form called");
		model.addAttribute("book", new Book());
		return "addBook"; // must match addBook.html
	}

	@PostMapping("/save")
	public String saveBook(@ModelAttribute Book book) {
		repo.save(book);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Book book = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
		model.addAttribute("book", book);
		return "editBook"; // must match editBook.html
	}

	@PostMapping("/update/{id}")
	public String updateBook(@PathVariable("id") Long id, @ModelAttribute Book book) {
		book.setId(id);
		repo.save(book);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		repo.deleteById(id);
		return "redirect:/";
	}
}
