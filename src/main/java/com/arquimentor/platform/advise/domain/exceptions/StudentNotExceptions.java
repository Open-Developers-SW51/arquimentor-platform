package com.arquimentor.platform.advise.domain.exceptions;

public class StudentNotExceptions extends RuntimeException{
     public StudentNotExceptions(){
        super("Students not found");
    }
}
