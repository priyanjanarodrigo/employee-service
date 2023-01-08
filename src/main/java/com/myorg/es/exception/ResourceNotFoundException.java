package com.myorg.es.exception;


import java.io.Serial;
import java.io.Serializable;
import lombok.ToString;

@ToString
public class ResourceNotFoundException extends RuntimeException implements Serializable {

  @Serial
  private static final long serialVersionUID = 2643495397785446841L;

  public ResourceNotFoundException(String message) {
    super(message);
  }
}
