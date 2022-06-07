package com.codecracker.springboot.tutorial.service;

import com.codecracker.springboot.tutorial.entity.Department;
import com.codecracker.springboot.tutorial.error.DepartmentNotFoundException;
import com.codecracker.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long deptId) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(deptId);
        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDeptById(Long deptId) {
        departmentRepository.deleteById(deptId);
    }

    @Override
    public Department updateDepartment(Long deptId, Department department) {
        Department deptFromDb =  departmentRepository.findById(deptId).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            deptFromDb.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            deptFromDb.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            deptFromDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        return  departmentRepository.save(deptFromDb);
    }

    @Override
    public Department fetchDeptByName(String deptName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(deptName);
    }


}
