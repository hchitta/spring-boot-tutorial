package com.codecracker.springboot.tutorial.controller;

import com.codecracker.springboot.tutorial.entity.Department;
import com.codecracker.springboot.tutorial.error.DepartmentNotFoundException;
import com.codecracker.springboot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments() {
        LOGGER.info("inside fetchDepartments of DepartmentController");
        return  departmentService.fetchDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {
        LOGGER.info("inside getDepartmentById of DepartmentController");
        return departmentService.getDepartmentById(deptId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDeptById(@PathVariable("id") Long deptId) {

        departmentService.deleteDeptById(deptId);
        return "department deleted successfully";

    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long deptId, @RequestBody Department department) {
        return departmentService.updateDepartment(deptId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDeptByName(@PathVariable("name") String deptName){
        return departmentService.fetchDeptByName(deptName);
    }


}
