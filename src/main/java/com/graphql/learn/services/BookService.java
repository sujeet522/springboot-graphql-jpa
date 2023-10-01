package com.graphql.learn.services;

import com.graphql.learn.entities.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {

    List<Book> getAll() throws IOException;

    Book get(int bookId);

}
