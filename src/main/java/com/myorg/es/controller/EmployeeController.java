package com.myorg.es.controller;

import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.myorg.es.entity.dto.request.EmployeeRequest;
import com.myorg.es.entity.dto.response.EmployeeResponse;
import com.myorg.es.service.EmployeeService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@Validated
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

  @Autowired
  @Qualifier("employeeService")
  public EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<EmployeeResponse> createEmployee(
      @Valid @RequestBody EmployeeRequest employeeRequest) {
    log.info("createEmployee invoked with employeeRequest : {}", employeeRequest);

    EmployeeResponse employeeResponse = employeeService.save(employeeRequest);
    return ResponseEntity.created(URI.create("employee/" + employeeResponse.getId()))
        .body(employeeResponse);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EmployeeResponse> updateEmployee(
      @PathVariable(value = "id") int id, @RequestBody EmployeeRequest employeeRequest) {
    log.info("updateEmployee invoked with id : {} and employeeRequest : {}", id, employeeRequest);
    return ResponseEntity.ok(employeeService.update(id, employeeRequest));
  }

  @GetMapping("/{id}")
  public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable(value = "id") int id) {
    log.info("getEmployeeById invoked with id : {}", id);
    return ResponseEntity.ok(employeeService.getEmployeeById(id));
  }

  @GetMapping
  public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
    log.info("getAllEmployees invoked");
    return ResponseEntity.ok(employeeService.getAllEmployees());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEmployeeById(@PathVariable(value = "id") int id) {
    log.info("deleteEmployeeById invoked with id : {}", id);
    employeeService.delete(id);
    return new ResponseEntity<>(NO_CONTENT);
  }
}
