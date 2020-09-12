package com.danilo.springboot.docker.exception;

public class LatLongException extends RuntimeException
{

    private static final long serialVersionUID = -6348178415492562403L;

    public LatLongException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
