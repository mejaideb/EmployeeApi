package com.learning.springboot.Repositories;

import com.learning.springboot.Model.EmployeeContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeContactInfoRepository extends JpaRepository<EmployeeContactInfo,Integer> {

}
