package com.myorg.es.service;

import com.myorg.es.entity.dto.request.EmployeeRequest;
import com.myorg.es.entity.dto.response.EmployeeResponse;
import java.util.List;

public interface EmployeeService {

  EmployeeResponse save(EmployeeRequest employeeRequest);

  void delete(int id);

  EmployeeResponse update(int id, EmployeeRequest employeeRequest);

  EmployeeResponse getEmployeeById(int id);

  List<EmployeeResponse> getAllEmployees();
}
