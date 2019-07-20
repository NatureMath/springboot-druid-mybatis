package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @Author huct
 * @Date 2019/7/20 - 16:35
 */
//@Mapper用mapperscan代替
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDepartmentById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department dept);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department dept);
}
