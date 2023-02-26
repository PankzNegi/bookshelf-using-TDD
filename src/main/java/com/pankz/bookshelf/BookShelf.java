package com.pankz.bookshelf;

import java.util.*;

public class BookShelf {
    private Set<Book> books; //Store our books

    public BookShelf() {
        this.books = new HashSet<>();
    }

    public void add(Book book) {
        boolean added = this.books.add(book); //Adding books to our collection
        //Below condition is according to add method implementation of sets hashcode & equal
        if(!added)   //if book is not added because of equality operation of hashcode(here added=false thus !added become true
        {
            throw new IllegalArgumentException("You can't add same book twice!!!");
        }


    }

    public int numberOfBooks() {
        return  this.books.size() ; //Returning the size of book in bookshelf
    }

    public boolean delete(Book book) {

        return this.books.remove(book);//Here also as per the contract of remove method in "set.java"(remove())
        //As "Book" implements equals and hashcode method so if the book is present, it willfirst find the bucket  using the hashcode
        //then compares the elements using equals() and finally it will be able to find the book and able to remove from hash
    }

    public List<Book> listBooks() {
        List<Book> sorted=new ArrayList<>(this.books);
        Collections.sort(sorted);
        return sorted;
    }
}
