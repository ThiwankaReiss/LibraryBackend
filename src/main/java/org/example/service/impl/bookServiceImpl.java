package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class bookServiceImpl implements BookService {

    final BookRepository repository;

    ModelMapper mapper;
    @Bean
    public void setUp(){
        this.mapper=new ModelMapper();
    }

    @Override
    public void addBook(Book book) {
        BookEntity map=mapper.map(book, BookEntity.class);
        repository.save(map);
    }

    @Override
    public List<BookEntity> getBooks() {
        return (List<BookEntity>) repository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public Book getBookById(Long id) {
        Optional<BookEntity> byId=repository.findById(id);
        return mapper.map(byId,Book.class);
    }
}
