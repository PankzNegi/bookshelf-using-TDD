package com.pankz.bookshelf;

import java.util.Objects;

public class Book implements  Comparable<Book>{
    private final String title;
    public Book(String title) {
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }
}
