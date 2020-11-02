package com.actual.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Indexed //сущность индексируемая и будет попадать в полнотекстовый индекс
//@Document(indexName = "resource", type = "books") //объект, кот.будет сохранен в эластике
//@Table(name = "books")
public class Book {
	//@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	//@Field(termVector = TermVector.YES)
	//@Size(min = 3, max = 1000)
	//@Column(name = "annotation")
	//@NotEmpty
	private String annotation;

	//@Field(termVector = TermVector.YES)
	//@Column(name = "author")
	//@NotEmpty
	private String author;

	//@Field(termVector = TermVector.YES)
	//@Column(name = "title")
	//@NotEmpty
	private String title;

	//@Field
	//@Pattern(regexp = "[0-9]{1,4}")
	//@Column(name = "year")
	private int year;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Book(Long id, String annotation, String author, String title, int year) {
		super();
		this.id = id;
		this.annotation = annotation;
		this.author = author;
		this.title = title;
		this.year = year;
	}
	public Book() {

	}

	@Override
	public String toString() {
		return "Book [id=" + id +
				", annotation=" + annotation +
				", author=" + author+
				", title=" + title +
				", year=" + year +
				"]";
	}
}
