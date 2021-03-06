package com.example.presentation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.domain.Author;
import com.example.infrastructure.graphql.Email;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {

    public Author addEmail(Email email) {
        return new Author(1, "hoge", email.value());
    }

    public Author addAuthor(ArgumentAuthor author) {
        return new Author(1, author.name, author.email.value());
    }
}
