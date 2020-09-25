package com.example.demo.exception;

// GTB：- 业务异常应该继承自RuntimeException
public class ItemsNotEnoughException extends Exception{
    public ItemsNotEnoughException(String message) {
        super(message);
    }
}
