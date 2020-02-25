package com.learning.springboot.Services;

import com.learning.springboot.Model.Employee;
import com.learning.springboot.Model.EmployeeContactInfo;
import com.learning.springboot.Repositories.EmployeeContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Component
public class EmloyeeContactInfoService {

    @Autowired
    EmployeeContactInfoRepository employeeContactInfoRepository;

    public List<EmployeeContactInfo> findAllEmployeeContactInfo(){
        return employeeContactInfoRepository.findAll();
    }

    public EmployeeContactInfo createNewEmployeeInfo(EmployeeContactInfo employeeContactInfo){
         return  employeeContactInfoRepository.save(employeeContactInfo);
    }
}
