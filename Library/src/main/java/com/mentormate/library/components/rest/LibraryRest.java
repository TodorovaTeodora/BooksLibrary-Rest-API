package com.mentormate.library.components.rest;

import com.mentormate.library.json.Book;
import com.mentormate.library.storage.Storage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryRest {

    @GetMapping("status")
    public String status() {
        return "Up and running";
    }

    @GetMapping("get-all")
    public List<Book> getAll() {
        return Storage.db().getAll();
    }

    @GetMapping(value = "get/{hashCode}")
    public Book getBook(@PathVariable Integer hashCode) {
        return Storage.db().get(hashCode);
    }

    @PutMapping(value = "update/{hashCode}")
    public boolean updateBook(@PathVariable Integer hashCode, @RequestBody Book book) {
        return Storage.db().update(book, hashCode);
    }

    @PostMapping("save")
    public Integer saveBook(@RequestBody Book book) {
        return Storage.db().save(book);
    }

    @DeleteMapping(value = "delete/{hashCode}")
    public boolean deleteBook(@PathVariable Integer hashCode) {
        return Storage.db().delete(hashCode);
    }

}
