package com.abdul.springbootgraphqlsecond.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String movieDoesNotExist) {
        super(movieDoesNotExist);
    }
}
