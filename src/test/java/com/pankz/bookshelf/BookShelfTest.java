package com.pankz.bookshelf;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookShelfTest {
    @Test
    public void should_be_able_to_add_a_book_to_bookstore() {
        BookShelf bookShelf = new BookShelf();
        bookShelf.add(new Book("Effective Java"));
        int count = bookShelf.numberOfBooks(); //Bookshelf should return the number of books
        Assertions.assertThat(count).isEqualTo(1);

    }
    @Test
    public void should_not_allow_same_book_to_be_added_to_bookshelf()
    {
        BookShelf bookShelf = new BookShelf();
        bookShelf.add(new Book("Effective Java"));
       //What should happen when same books added twice ?? it might throw an exception ..
        try {
            bookShelf.add(new Book("Effective Java"));
            fail("This should not happen"); //code will never reach here can check by sysout below
        } catch (Exception e) {
            //Book with same title means your  arguments are same hence it will throw this exception
            Assertions.assertThat(e).isInstanceOf(IllegalArgumentException.class);
            Assertions.assertThat(e.getMessage()).isEqualTo("You can't add same book twice!!!");
            //We are also trying to verify the message of that as well/verifying this msg from our code

        }
        System.out.println(bookShelf.numberOfBooks()); //o/p will be 2,therfore something is not right here
       // IMPORTANT POINT-In Hashcode and set kind of stuff untill you didn't use equalsto() and hashcode()
        //different(here 2) object will be created (no. of times you call each time diff. hashcode)
        //different two object we are trying to save to hash set,it will by default save it
        //We must implement hashcode() & equals() method
        // Then only it will set two different hashcode for same values,otherwise it will do reference equality
        //After implementing hashcode and equals() above o/p will be 1 . Hence it didn't added the 2nd book9coz same hashcode)
        }
        @Test
    public void should_delete_an_existing_book_from_bookshelf()
        {
            BookShelf bookShelf = new BookShelf();
            bookShelf.add(new Book("Effective Java"));
            bookShelf.add(new Book("Clean Code"));
           boolean deleted= bookShelf.delete(new Book("Effective Java"));
           //Same here we set delete of type bollean ,it will return true if deleted otherwise false
            //Same implementation as that of bollean added but here design is different,we can do as previous
            //Here also as per the contract of remove method in "set.java"
            Assertions.assertThat(deleted).isTrue();
        }
        @Test
    public void should_not_delete_book_from_bookshelf_that_is_present()
        {
            BookShelf bookShelf = new BookShelf();
            bookShelf.add(new Book("Effective Java"));
            bookShelf.add(new Book("Clean Code"));
            boolean deleted= bookShelf.delete(new Book("The Pragmatic Programmer"));
            Assertions.assertThat(deleted).isFalse(); //isFalse becoz this book is not present hence remove method return false
        }//remove couldn't find this book,hence remove method just returns false.

    @Test
    public void should_return_books_in_default_sorted_order()
    {  //Arrange
        BookShelf bookShelf = new BookShelf();
        Book effectiveJavaBook = new Book("Effective Java");  //assigning local variable to each book
        Book cleanCodeBook = new Book("Clean Code");
        Book thePragmaticProgrammerBook = new Book("The Pragmatic Programmer");

        bookShelf.add(effectiveJavaBook);
        bookShelf.add(cleanCodeBook);
        bookShelf.add(thePragmaticProgrammerBook);
       //Act
        List<Book>books= bookShelf.listBooks();

        //Assert
       Assertions.assertThat(books).containsExactly(cleanCodeBook,effectiveJavaBook,thePragmaticProgrammerBook);
    }
}


