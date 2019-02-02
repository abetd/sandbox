package com.example.presentation;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.domain.Author;
import com.example.domain.Book;
import com.example.infrastructure.datasource.AuthorDao;
import com.example.infrastructure.graphql.Email;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AuthorQueryResolver implements GraphQLQueryResolver {

    AuthorDao authorDao;

    public AuthorQueryResolver(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Author getAuthorById(int id) {
        return authorDao.getAuthorById(id);
    }

    public Author getAuthorByEmail(Email email) {
        return new Author(1, "hoge", email.value());
    }

    public Book getBook() {
        return new Book(1, "bookname", new Author(1, "hoge", "hoge@example.com"));
    }

    public List<Book> allBooks() {
        return Arrays.asList(
                new Book(1, "bookname", new Author(1, "hoge", "hoge@example.com")),
                new Book(2, "Book", new Author(1, "hoge", "hoge@example.com"))
        );
    }
}
