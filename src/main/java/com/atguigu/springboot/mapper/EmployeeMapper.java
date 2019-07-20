package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Employee;

/**
 * @Author huct
 * @Date 2019/7/20 - 17:11
 */
public interface EmployeeMapper {
    public Employee getEmployeeById(Integer id);

    public void insertEmp(Employee em);
}
