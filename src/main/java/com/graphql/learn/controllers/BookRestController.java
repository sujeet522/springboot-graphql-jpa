package com.graphql.learn.controllers;

import com.graphql.learn.services.impl.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/books")
@RestController
public class BookRestController {

    @Autowired
    GraphQLService graphQLService;

    @GetMapping
    public ResponseEntity<Object> getAllBooks(@RequestBody String query) throws IOException {
        graphQLService.loadSchema();
        ExecutionResult execute = graphQLService.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
