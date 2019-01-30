package com.example.presentation;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.domain.Author;
import com.example.infrastructure.AuthorDao;
import org.springframework.stereotype.Component;

@Component
public class AuthorQueryResolver implements GraphQLQueryResolver {

    AuthorDao authorDao;

    public AuthorQueryResolver(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Author getAuthorById(int id) {
        return authorDao.getAuthorById(id);
    }
}
