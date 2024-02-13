package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.dto.Response;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class BookController {
    final BookService service;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        service.addBook(book);
    }
    @GetMapping("/get")
    public Iterable<BookEntity> getBooks(){
        return service.getBooks();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteBook(@PathVariable Long id){
         return service.deleteBook(id) ?
      new Response(String.format("Deleted Book Id(%s)",id)):
                 new Response(String.format("Unable to Delete Book Id(%s)",id));
    }
    @GetMapping("search/{id}")
    public Book getBookById(@PathVariable Long id){
       return service.getBookById(id);
    }
}
