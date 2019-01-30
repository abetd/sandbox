package com.example.infrastructure;

import com.example.domain.Author;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorDao {
    List<Author> authors = Arrays.asList(
            new Author(1, "hogehoge"),
            new Author(2, "fugafuga"),
            new Author(3, "poyopoyo")
    );

    public Author getAuthorById(int id) {
        Optional<Author> result = authors.stream().filter(author -> author.getId() == id).findFirst();
        return result.orElse(new Author(4, "foo"));
    }
}
