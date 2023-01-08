package com.myorg.es.serviceImpl;

import static com.myorg.es.entity.mapper.EmployeeMapper.mapEmployeeRequestToEmployee;
import static com.myorg.es.entity.mapper.EmployeeMapper.mapEmployeeToEmployeeResponse;

import com.myorg.es.entity.dto.request.EmployeeRequest;
import com.myorg.es.entity.dto.response.EmployeeResponse;
import com.myorg.es.entity.mapper.EmployeeMapper;
import com.myorg.es.entity.model.Employee;
import com.myorg.es.exception.ResourceNotFoundException;
import com.myorg.es.repository.EmployeeRepository;
import com.myorg.es.service.EmployeeService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  @Qualifier("employeeRepository")
  public EmployeeRepository employeeRepository;

  public EmployeeResponse save(EmployeeRequest employeeRequest) {
    Employee employee = employeeRepository.save(mapEmployeeRequestToEmployee(employeeRequest));
    return mapEmployeeToEmployeeResponse(employee);
  }

  public EmployeeResponse update(int id, EmployeeRequest employeeRequest) {
    Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Employee not found for id: " + id));

    Employee updatedEmployee = mapEmployeeRequestToEmployee(employeeRequest);
    updatedEmployee.setId(existingEmployee.getId());

    return mapEmployeeToEmployeeResponse(employeeRepository.save(updatedEmployee));
  }

  @Override
  public void delete(int id) {
    Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Employee not found for id: " + id));
    employeeRepository.deleteById(existingEmployee.getId());
  }

  @Override
  public EmployeeResponse getEmployeeById(int id) {
    return employeeRepository.findById(id).map(EmployeeMapper::mapEmployeeToEmployeeResponse)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for id: " + id));
  }

  @Override
  public List<EmployeeResponse> getAllEmployees() {
    return employeeRepository.findAll().stream().map(EmployeeMapper::mapEmployeeToEmployeeResponse)
        .collect(Collectors.toList());
  }
}
