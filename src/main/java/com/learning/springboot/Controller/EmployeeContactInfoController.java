package com.learning.springboot.Controller;

import com.learning.springboot.Model.EmployeeContactInfo;
import com.learning.springboot.Services.EmloyeeContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employeeContactInfo")
public class EmployeeContactInfoController {

    @Autowired
    EmloyeeContactInfoService employeeContactInfoService;

    @GetMapping
    public List<EmployeeContactInfo> getAllEmployeeWithContactInfo(){
        return employeeContactInfoService.findAllEmployeeContactInfo();
    }

    @PostMapping
    public EmployeeContactInfo createContactInfo(@RequestBody EmployeeContactInfo employeeContactInfo){
        return employeeContactInfoService.createNewEmployeeInfo(employeeContactInfo);
    }


}
