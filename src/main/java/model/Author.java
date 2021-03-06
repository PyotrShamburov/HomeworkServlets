package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private String description;
    private List<Book> books = new ArrayList<>();
    private String urlPhoto;

    public Author() {
    }

    public Author(String firstName, String lastName, String description, String urlPhoto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.urlPhoto = urlPhoto;
    }

    public Author(int id, String firstName, String lastName, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    public Author(int id, String firstName, String lastName, String description, String urlPhoto) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.urlPhoto = urlPhoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public  void setBooks(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }
    public void deleteBook(Book book){
        books.remove(book);
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(description, author.description) &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, description, books);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id: " + id +
                ", firstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'' +
                ", description: '" + description + '\'' +
                ", books: " + books +
                '}';
    }
}
