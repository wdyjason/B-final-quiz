package com.example.demo.exception;

public class ItemsNotEnoughException extends Exception{
    public ItemsNotEnoughException(String message) {
        super(message);
    }
}
