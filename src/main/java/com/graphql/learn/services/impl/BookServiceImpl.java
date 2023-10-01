package com.graphql.learn.services.impl;

import com.graphql.learn.entities.Book;
import com.graphql.learn.repositories.BookRep;
import com.graphql.learn.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    private BookRep bookRep;

    private GraphQLService graphQLService;

    @Autowired
    public BookServiceImpl(BookRep bookRep,GraphQLService graphQLService) {
        this.bookRep = bookRep;
        this.graphQLService=graphQLService;
    }

    @Override
    public List<Book> getAll() {
        return this.bookRep.findAll();
    }

    @Override
    public Book get(int bookId) {
        return this.bookRep.findById(bookId).orElseThrow(() -> new RuntimeException("Book you are looking for not found on server !!"));
    }
}
