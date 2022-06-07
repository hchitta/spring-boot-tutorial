package com.codecracker.springboot.tutorial.service;

import com.codecracker.springboot.tutorial.entity.Department;
import com.codecracker.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartments();

    Department getDepartmentById(Long deptId) throws DepartmentNotFoundException;

    void deleteDeptById(Long deptId);

    Department updateDepartment(Long deptId, Department department);

    Department fetchDeptByName(String deptName);
}
