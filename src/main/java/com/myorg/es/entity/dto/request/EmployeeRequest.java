package com.myorg.es.entity.dto.request;

import java.io.Serial;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public final class EmployeeRequest implements Serializable {

  @Serial
  private static final long serialVersionUID = 3241421469903128849L;

  @NotBlank(message = "{request.employee.firstName.notBlank}")
  private String firstName;

  @NotBlank(message = "{request.employee.lastName.notBlank}")
  private String lastName;

  @Email(message = "{request.employee.email}")
  @NotBlank(message = "{request.employee.email.notBlank}")
  private String email;
}
