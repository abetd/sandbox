package com.example.infrastructure.graphql;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateScalarType extends GraphQLScalarType {

    private static final String DEFAULT_NAME = "Date";

    public DateScalarType() {
        this(DEFAULT_NAME);
    }

    public DateScalarType(final String name) {
        super(name, "Date type", new Coercing<LocalDate, String>() {
            @Override
            public String serialize(Object input) {
                System.out.println("serialize");
                if (input instanceof LocalDate)
                    return DateTimeFormatter.ISO_LOCAL_DATE.format((LocalDate) input);
                throw new CoercingSerializeException("Invalid value '" + input + "' for LocalDate");
            }

            @Override
            public LocalDate parseValue(Object input) {
                System.out.println("parseValue");
                if (input instanceof String)
                    return LocalDate.parse((String)input);
                throw new CoercingParseValueException("Invalid value '" + input + "' for LocalDate");
            }

            @Override
            public LocalDate parseLiteral(Object input) {
                System.out.println("parseLiteral");
                if (input instanceof StringValue)
                    return LocalDate.parse(((StringValue) input).getValue());
                throw new CoercingParseValueException("Invalid value '" + input + "' for LocalDate");
            }
        });
    }
}
