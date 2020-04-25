package com.mentormate.library.json;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Book {
    @Getter @Setter
    private String title;

    @Getter @Setter
    private String publisher;

    @Getter @Setter
    private int year;

    @Getter @Setter
    private String author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return year == book.year &&
                title.equals(book.title) &&
                publisher.equals(book.publisher) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publisher, year, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                '}';

    }

//    public static void main(String[] args) {
//        Book b1 = new Book();
//        Book b2 = new Book();
//
//        b1.setTitle("Title 1");
//        b2.setTitle("Title 1");
//
//        System.out.println(b1.hashCode());
//        System.out.println(b2.hashCode());
//    }

}
