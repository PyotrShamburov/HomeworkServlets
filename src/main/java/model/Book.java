package model;

import java.util.Objects;

public class Book {
    private int id;
    private String title;
    private String description;
    private Author author;
    private int yearOfPublishing;
    private double price;

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Book(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Book(int id, String title, String description, Author author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public Book(int id, String title, String description, Author author, int yearOfPublishing) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public Book(int id, String title, String description, Author author, int yearOfPublishing, double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                yearOfPublishing == book.yearOfPublishing &&
                Double.compare(book.price, price) == 0 &&
                Objects.equals(title, book.title) &&
                Objects.equals(description, book.description) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, author, yearOfPublishing, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id:" + id +
                ", title: '" + title + '\'' +
                ", description: '" + description + '\'' +
                ", author: " + author +
                ", yearOfPublishing: " + yearOfPublishing +
                ", price: " + price +
                '}';
    }
}
