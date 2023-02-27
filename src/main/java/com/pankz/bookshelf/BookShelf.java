package com.pankz.bookshelf;
//Bookshelf using OOA&D
import java.util.*;

public class BookShelf {
    private Set<Book> books; //Store our books
    private boolean visible;
    public BookShelf()
    {
        this(false);
    }

    public BookShelf(boolean visible) {
        this.visible=visible;
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
        return Collections.unmodifiableList(sorted);
    }

    public List<Book> listBooksByDesc() {
        List<Book> sorted=new ArrayList<>(this.books);
        Collections.sort(sorted, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getTitle().compareTo(o1.getTitle());
            }
        });
        return Collections.unmodifiableList(sorted);
    }

    public boolean share(String sharingType,String toEmail) {
        if (isNotVisible()) {
            throw new IllegalStateException("You can't share private bookshelf");
        }
        if (Objects.equals(sharingType, "email")) {
            sendEmail(toEmail);
            return true;
        }
        return  false;
    }

    private void sendEmail(String toEmail) {
        System.out.println("Send email to"+toEmail);
    }

    private  boolean isNotVisible()
    {
        return !this.visible;
    }
}
