package com.abdul.springbootgraphqlsecond.exception;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice  //centralize exception handling
public class GlobalExceptionHandler {

    @GraphQlExceptionHandler //handling graphql exception handler
    public GraphQLError handleMovieNotFoundException(MovieNotFoundException ex){
        return GraphQLError.newError()
                .message(ex.getMessage())
                .build();
    }
}
