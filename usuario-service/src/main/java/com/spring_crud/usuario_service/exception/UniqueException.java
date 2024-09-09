package com.spring_crud.usuario_service.exception;

public class UniqueException extends RuntimeException {
  public UniqueException(String message) {
    super(message);
  }
}
