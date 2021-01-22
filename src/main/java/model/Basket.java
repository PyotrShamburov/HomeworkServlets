package model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }
    public List<Book> getAll(){
        return new ArrayList<>(books);
    }
}
