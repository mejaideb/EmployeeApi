package com.learning.springboot.Services;

import com.learning.springboot.Dto.PaginationResponseList;
import com.learning.springboot.Exception.EmployeeNotFoundException;
import com.learning.springboot.Model.Employee;
import com.learning.springboot.Model.OrderBy;
import com.learning.springboot.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@Component
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        
       return employeeRepository.save(employee);
    }

    public PaginationResponseList<Employee> findEmployee(Integer pageNumber, Integer pageSize, String sortBy) throws EmployeeNotFoundException {
        Pageable paging= PageRequest.of(pageNumber,pageSize, Sort.by(sortBy).ascending());
        Page<Employee> pagedResult=  employeeRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return new PaginationResponseList<Employee>(pagedResult.getContent(),pagedResult.getNumber(),pagedResult.getSize()
                    ,pagedResult.getTotalPages(),pagedResult.getSort().toString().split(":")[0],
                    OrderBy.valueOf(pagedResult.getSort().toString().split(":")[1].trim()));
        } else {
            return  new PaginationResponseList<Employee>();
        }
    }

    public Employee findEmployeeById(int id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElseThrow(()->new EmployeeNotFoundException("Employee Not Found with id :"+id));
    }

    public void deleteEmployeeById(int id){
        employeeRepository.deleteById(id);
    }
}
