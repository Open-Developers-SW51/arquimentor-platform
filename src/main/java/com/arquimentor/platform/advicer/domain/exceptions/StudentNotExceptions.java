package com.arquimentor.platform.advicer.domain.exceptions;

public class StudentNotExceptions extends RuntimeException{
     public StudentNotExceptions(){
        super("Students not found");
    }
}
