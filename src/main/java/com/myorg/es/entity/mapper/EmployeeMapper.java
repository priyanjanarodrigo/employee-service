package com.myorg.es.entity.mapper;

import com.myorg.es.entity.dto.request.EmployeeRequest;
import com.myorg.es.entity.dto.response.EmployeeResponse;
import com.myorg.es.entity.model.Employee;

public final class EmployeeMapper {

  public static Employee mapEmployeeRequestToEmployee(EmployeeRequest employeeRequest) {
    return Employee.builder()
        .firstName(employeeRequest.getFirstName())
        .lastName(employeeRequest.getLastName())
        .email(employeeRequest.getEmail())
        .build();
  }

  public static EmployeeResponse mapEmployeeToEmployeeResponse(Employee employee) {
    return EmployeeResponse.builder()
        .id(employee.getId())
        .firstName((employee.getFirstName()))
        .lastName(employee.getLastName())
        .email(employee.getEmail())
        .build();
  }
}
