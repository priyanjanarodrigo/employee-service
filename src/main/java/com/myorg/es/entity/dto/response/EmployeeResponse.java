package com.myorg.es.entity.dto.response;

import java.io.Serial;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public final class EmployeeResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = -2451727258944144871L;

  private int id;

  private String firstName;

  private String lastName;

  private String email;
}
