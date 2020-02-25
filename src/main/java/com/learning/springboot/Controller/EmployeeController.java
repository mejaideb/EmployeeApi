package com.learning.springboot.Controller;

import com.learning.springboot.Dto.PaginationResponseList;
import com.learning.springboot.Exception.EmployeeNotFoundException;
import com.learning.springboot.Model.Employee;
import com.learning.springboot.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


//    @GetMapping
//    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
//                                                          @RequestParam(defaultValue = "10") Integer pageSize,
//                                                          @RequestParam(defaultValue = "id") String sortBy) throws EmployeeNotFoundException {
//        List<Employee> employee=employeeService.findEmployee(pageNo,pageSize,sortBy);
//        System.out.println(employee.size());
//        if(employee.size()<0) throw new EmployeeNotFoundException("Employees Not Found");
//        return new ResponseEntity<List<Employee>>(employee,new HttpHeaders(), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<PaginationResponseList<Employee>> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                                                            @RequestParam(defaultValue = "id") String sortBy) throws EmployeeNotFoundException {

        return new ResponseEntity<PaginationResponseList<Employee>>( employeeService.findEmployee(pageNo,pageSize,sortBy),new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id" ) int id) throws EmployeeNotFoundException {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable(name = "id",required = true) int id){
        employeeService.deleteEmployeeById(id);
    }


}
