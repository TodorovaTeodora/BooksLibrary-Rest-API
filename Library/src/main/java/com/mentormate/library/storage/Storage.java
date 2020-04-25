package com.mentormate.library.storage;

import com.mentormate.library.json.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static final Storage INSTANCE = new Storage();
    private Map<Integer, Book> bookDB;

    private Storage() {
        bookDB = new HashMap<>();
    }

    public static Storage db() {
        return INSTANCE;
    }

    public Integer save(Book book) {
        int hashCode = book.hashCode();

        if (bookDB.containsKey(hashCode))
            return null;

        bookDB.put(hashCode, book);
        return hashCode;
    }

    public boolean update(Book book, Integer hashCode) {
        if (!bookDB.containsKey(hashCode))
            return false;

        if (bookDB.containsKey(book.hashCode()))
            return false;

        bookDB.put(hashCode, book);
        return true;
    }

    public boolean delete(Integer hashCode) {
        if (!bookDB.containsKey(hashCode))
            return false;

        bookDB.remove(hashCode);
        return true;
    }

    public Book get(Integer hashCode) {
        return bookDB.get(hashCode);
    }

    public List<Book> getAll() {
        return new ArrayList<>(bookDB.values());
    }

}
