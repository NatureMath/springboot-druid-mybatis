package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.DepartmentMapper;
import com.atguigu.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huct
 * @Date 2019/7/20 - 16:42
 */
@RestController
public class DeptController {
    @Autowired
    DepartmentMapper mapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return mapper.getDepartmentById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department dept){
        mapper.insertDept(dept);
        return dept;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        System.out.println("employeeid===="+id);
        return employeeMapper.getEmployeeById(id);
    }
}
