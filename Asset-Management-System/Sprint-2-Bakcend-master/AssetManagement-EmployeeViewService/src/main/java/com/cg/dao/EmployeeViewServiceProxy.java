package com.cg.dao;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.bean.Employee;
import com.cg.bean.EmployeeIdsAndNames;

@FeignClient(name = "employee-service", url = "https://asset-mgmt-employee-service.herokuapp.com")
@RibbonClient(name = "employee-service")
public interface EmployeeViewServiceProxy {

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees();

	@GetMapping("/findById")
	public Employee findById(@RequestParam int employeeId);

	@GetMapping("/findByName")
	public List<Employee> findByName(@RequestParam String employeeName);

	@GetMapping("/countEmployees")
	public Long countEmployess();
	
	@GetMapping("/getEmployeeIdsAndNames")
	public EmployeeIdsAndNames getEmployeeIds();
}
