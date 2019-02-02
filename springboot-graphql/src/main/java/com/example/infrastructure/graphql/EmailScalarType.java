package com.example.infrastructure.graphql;

import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.stereotype.Component;

@Component
public class EmailScalarType extends GraphQLScalarType {

    private static final String DEFAULT_NAME = "Email";

    public EmailScalarType() {
        this(DEFAULT_NAME);
    }

    public EmailScalarType(final String name) {
        super(name, "A custom scalar that handles emails", new Coercing<Email, String>() {
            @Override
            public String serialize(Object dataFetcherResult) {
                return dataFetcherResult.toString();
            }

            @Override
            public Email parseValue(Object input) {
                return parseEmailFromVariable(input);
            }

            @Override
            public Email parseLiteral(Object input) {
                return parseEmailFromAstLiteral(input);
            }
        });
    }

    private static boolean looksLikeAnEmailAddress(String possibleEmailValue) {
        // ps.  I am not trying to replicate RFC-3696 clearly
        // return Pattern.matches("[A-Za-z0-9]@[.*]", possibleEmailValue);
        return true;
    }

    private static String serializeEmail(Object dataFetcherResult) {
        return String.valueOf(dataFetcherResult);
    }

    private static Email parseEmailFromVariable(Object input) {
        if (input instanceof String) {
            String possibleEmailValue = input.toString();
            if (looksLikeAnEmailAddress(possibleEmailValue)) {
                return new Email(possibleEmailValue);
            }
        }
        throw new CoercingParseValueException("Unable to parse variable value " + input + " as an email address");
    }

    private static Email parseEmailFromAstLiteral(Object input) {
        if (input instanceof StringValue) {
            String possibleEmailValue = ((StringValue) input).getValue();
            if (looksLikeAnEmailAddress(possibleEmailValue)) {
                return new Email(possibleEmailValue);
            }
        }
        throw new CoercingParseLiteralException(
                "Value is not any email address : '" + String.valueOf(input) + "'"
        );
    }
}
